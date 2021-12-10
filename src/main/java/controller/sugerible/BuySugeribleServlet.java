package controller.sugerible;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.Promocion;
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("atraccion") != null) {
			Integer idAtraccion = Integer.valueOf(request.getParameter("atraccion"));
			System.out.println(idAtraccion);
			
			try {
				Atraccion a = atraccionService.findById(idAtraccion);
				System.out.println(Sistema.verificarSugerible(a));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(request.getParameter("promocion") != null) {
			Integer idPromocion = Integer.valueOf(request.getParameter("promocion"));
			System.out.println(idPromocion);
			
			try {
				Promocion p = promocionService.findById(idPromocion);
				System.out.println(Sistema.verificarSugerible(p));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
