package controller.attractions;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import app.NoExisteTematicaException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.Tematica;
import model.Usuario;
import services.AtraccionService;
import services.TematicaService;
import services.UsuarioService;

@WebServlet("/alta-atraccion.admin")
public class AltaAtraccionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -4139807152556264888L;
	private AtraccionService atraccionService;
	private TematicaService tematicaService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.atraccionService = new AtraccionService();
		this.tematicaService = new TematicaService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			
			int id = Integer.parseInt(req.getParameter("id"));
			
			Atraccion atraccion = atraccionService.findById(id);
			List<Tematica> tematicas = tematicaService.findAll(); 
			
			req.setAttribute("atracciones", atraccion);
			req.setAttribute("tematicas", tematicas);
			
			
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/views/admin/alta-atraccion.jsp");
			disp.forward(req, res);
		} catch (SQLException | NoExisteTematicaException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));			
			Atraccion atraccion = atraccionService.findById(id);
			
			Tematica preferencia = tematicaService.findById(Integer.parseInt(req.getParameter("preferencia")));
			Double tiempoDisponible = Double.parseDouble(req.getParameter("tiempo"));
			Integer cantidadMonedas = Integer.parseInt(req.getParameter("monedas"));
			String nombre = req.getParameter("nombre");
			
			Atraccion altaUsuario = new Atraccion(0, nombre, cantidadMonedas, tiempoDisponible, cantidadMonedas, preferencia, nombre, null);
			
			atraccionService.update(altaUsuario);
			
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/home.admin");
			disp.forward(req, res);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
