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

@WebServlet("/admin-editar.admin")
public class EditarUsuarioServlet extends HttpServlet implements Servlet {

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
			
			int id = Integer.parseInt(req.getParameter("id"));
			
			Usuario usuario = usuarioService.findById(id);
			List<Tematica> tematicas = tematicaService.findAll(); 
			
			req.setAttribute("usuario", usuario);
			req.setAttribute("tematicas", tematicas);
			
			
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/views/admin/modificar-usuario.jsp");
			disp.forward(req, res);
		} catch (SQLException | NoExisteTematicaException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));			
			Usuario usuario = usuarioService.findById(id);
			
			Tematica preferencia = tematicaService.findById(Integer.parseInt(req.getParameter("preferencia")));
			Double tiempoDisponible = Double.parseDouble(req.getParameter("tiempo"));
			Integer cantidadMonedas = Integer.parseInt(req.getParameter("monedas"));
			String nombre = req.getParameter("nombre");
			Boolean isAdmin = usuario.getIsAdmin();
			
			Usuario usuarioEditado = new Usuario(id, nombre, usuario.getPass(), cantidadMonedas, tiempoDisponible, preferencia, isAdmin, usuario.getActivo());
			
			usuarioService.update(usuarioEditado);
			
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/home.admin");
			disp.forward(req, res);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
