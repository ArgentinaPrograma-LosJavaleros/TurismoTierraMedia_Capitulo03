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
import model.Usuario;
import services.UsuarioService;

@WebServlet("/admin/editar.admin")
public class EditarUsuarioServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -4139807152556264888L;
	private UsuarioService usuarioService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.usuarioService = new UsuarioService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			
			//req.getAttribute(getServletName())
			
			List<Usuario> usuarioList = usuarioService.findAll();
			
			//req.setAttribute("usuarios", usuariosList);
			
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/views/admin/usuario-list.jsp");
			disp.forward(req, res);
		} catch (SQLException | NoExisteTematicaException e) {
			e.printStackTrace();
		}
	}
}
