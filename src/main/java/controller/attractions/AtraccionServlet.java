package controller.attractions;

import java.io.IOException;
import java.sql.SQLException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.AtraccionService;

@WebServlet("/atraccion/info")
public class AtraccionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -7039488770205761767L;
	private AtraccionService atraccionService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.atraccionService= new AtraccionService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {

			String id = (String)req.getParameter("id");
			
			String json = "";
			
			GsonBuilder gsonbuilder= new GsonBuilder();
			
			Gson gson = gsonbuilder.create();
			
			json = gson.toJson(this.atraccionService.findById(Integer.parseInt(id)));
			
			res.setContentType("application/json");
			res.getOutputStream().println(json);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
