package controller.sugerible;

import java.io.IOException;
import java.sql.SQLException;

import app.NoExisteTematicaException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Sugerible;
import services.AtraccionService;
import services.PromocionService;
import utils.Sistema;

@WebServlet("/buy.do")
public class BuySugeribleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AtraccionService atraccionService;
	private PromocionService promocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
		this.promocionService = new PromocionService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		Sugerible producto = null;
		Integer id = 0;

		try {
			if (request.getParameter("atraccion") != null) {
				id = Integer.valueOf(request.getParameter("atraccion"));
				//System.out.println("Atraccion: " + id);
				producto = atraccionService.findById(id);
			}

			if (request.getParameter("promocion") != null) {
				id = Integer.valueOf(request.getParameter("promocion"));
				//System.out.println("Promoción: " + id);
				producto = promocionService.findById(id);
			}

			//System.out.println(Sistema.verificarSugerible(producto));
			request.setAttribute("mensaje", mensajeSegunAccion(Sistema.verificarSugerible(producto)));
			request.getSession().setAttribute("monedas", Sistema.getUsuarioActual().getCantidadMonedas());
			request.getSession().setAttribute("tiempo", Sistema.getUsuarioActual().getTiempoDisponible());
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/home.do");
			dispatcher.forward(request, response);
		
		} catch (SQLException | NoExisteTematicaException | ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private String mensajeSegunAccion(Integer accion) {
		// Si accion = 0
		String mensaje = "Muchas gracias por su compra.";
		
		if(accion < 0 || accion > 4)
			return "Error desconocido.";
		
		if(accion == 1)
			mensaje = "Usted ya ha comprado este producto.";
		
		if(accion == 2)
			mensaje = "Monedas y/o tiempo insuficientes para comprar este producto.";
			
		if(accion == 3)
			mensaje = "No quedan cupos para esta atracción.";
		
		if(accion == 4)
			mensaje = "Una de las atracciones incluidas en la promoción no tiene más cupos.";
		
		return mensaje;
	}
}
