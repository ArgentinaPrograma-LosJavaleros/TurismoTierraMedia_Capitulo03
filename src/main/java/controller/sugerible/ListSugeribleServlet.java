package controller.sugerible;

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
import model.Atraccion;
import model.Promocion;
import services.AtraccionService;
import services.PromocionService;

@WebServlet("/home.do")
public class ListSugeribleServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 8316260090126443753L;
	
	private AtraccionService atraccionService;
	private PromocionService promocionService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
		this.promocionService = new PromocionService();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			
			req.setAttribute("atracciones", this.atraccionService.findAll());
			req.setAttribute("promociones", this.promocionService.findAll());
			
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/home.jsp");
			disp.forward(req, res);
			
			
			
		} catch (SQLException | NoExisteTematicaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
