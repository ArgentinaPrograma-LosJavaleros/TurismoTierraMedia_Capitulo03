package controller.attractions;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import app.NoExisteTematicaException;
import app.SistemaFront;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import services.AtraccionService;
import utils.OrdenadorPorTematica;
import utils.Sistema;

@WebServlet("/atracciones-list.admin")
public class ListAtraccionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -6306519455235321483L;
	private AtraccionService atraccionService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		List<Atraccion> atracciones = null;
		
		try {
			
			atracciones = this.atraccionService.findAll();

			req.setAttribute("atracciones", atracciones);
			
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/views/admin/atraccion-list.jsp");
			disp.forward(req, res);
			
		} catch (SQLException | NoExisteTematicaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
