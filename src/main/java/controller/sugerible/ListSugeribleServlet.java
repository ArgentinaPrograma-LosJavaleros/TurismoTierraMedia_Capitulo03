package controller.sugerible;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
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
import utils.OrdenadorPorTematica;
import utils.Sistema;

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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			
			List<Atraccion> atracciones = atraccionService.findAll();
			List<Promocion> promociones = promocionService.findAll();
			
			Collections.sort(atracciones, new OrdenadorPorTematica());
			Collections.sort(promociones, new OrdenadorPorTematica());
			
			req.setAttribute("atracciones", atracciones);
			req.setAttribute("promociones", promociones);

			
			RequestDispatcher disp = req.getRequestDispatcher("home.do");

			disp.forward(req, res);
		} catch (SQLException | NoExisteTematicaException e) {
			e.printStackTrace();
		}
	}
}
