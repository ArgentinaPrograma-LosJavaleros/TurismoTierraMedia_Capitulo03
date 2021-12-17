package controller.users;

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
import model.Tematica;
import model.Usuario;
import services.TematicaService;
import services.UsuarioService;

@WebServlet("/admin-baja.admin")
public class BajaUsuarioServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -4139807152556264888L;
	private UsuarioService usuarioService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.usuarioService = new UsuarioService();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			Integer id = Integer.valueOf(req.getParameter("id"));			
			Integer activo = Integer.valueOf(req.getParameter("activo"));
			
			this.usuarioService.actualizarActivo(id, activo);
			
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/home.admin");
			disp.forward(req, res);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
