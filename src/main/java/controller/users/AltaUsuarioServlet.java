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
import utils.Crypt;

@WebServlet("/admin-alta.admin")
public class AltaUsuarioServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -4139807152556264888L;
	private UsuarioService usuarioService;
	private TematicaService tematicaService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.usuarioService = new UsuarioService();
		this.tematicaService = new TematicaService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {

			List<Tematica> tematicas = tematicaService.findAll();
			
			req.setAttribute("tematicas", tematicas);
			
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/views/admin/alta-usuario.jsp");
			disp.forward(req, res);
		} catch (SQLException | NoExisteTematicaException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			String nombre = req.getParameter("nombre");
			String password = Crypt.hash(req.getParameter("pass"));
			Tematica preferencia = tematicaService.findById(Integer.parseInt(req.getParameter("preferencia")));
			Double tiempoDisponible = Double.parseDouble(req.getParameter("tiempo"));
			Integer cantidadMonedas = Integer.parseInt(req.getParameter("monedas"));
			Boolean isAdmin = false;
			
			if(req.getParameter("admin") != null)
				isAdmin = true;
			
			Usuario nuevoUsuario = new Usuario(0, nombre, password, cantidadMonedas, tiempoDisponible, preferencia, isAdmin, true);
			
			usuarioService.insert(nuevoUsuario);
			
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/home.admin");
			disp.forward(req, res);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
