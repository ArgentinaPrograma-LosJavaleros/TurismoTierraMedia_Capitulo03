package controller.promotions;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import app.NoExisteTematicaException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Promocion;
import services.PromocionService;

@WebServlet("/Promociones/list.admin")
public class ListPromocionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 8316260090126443753L;
	
	private PromocionService PromocionService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.PromocionService = new PromocionService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		List<Promocion> promociones = null;
		
		try {
			
			promociones = this.PromocionService.findAll();

			req.setAttribute("Promociones", promociones);
			
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/views/admin/promocion-list.jsp");
			disp.forward(req, res);
			
		} catch (SQLException | NoExisteTematicaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
