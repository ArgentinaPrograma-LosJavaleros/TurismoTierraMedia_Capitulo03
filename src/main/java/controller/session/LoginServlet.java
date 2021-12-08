package controller.session;

import java.io.IOException;
import java.sql.SQLException;

import app.NoExisteTematicaException;
import app.Sistema;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import services.UsuarioService;
import utils.Crypt;

@WebServlet("/login")
public class LoginServlet extends HttpServlet implements Servlet{

	private static final long serialVersionUID = 2394449831904434113L;
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//UsuarioService use = new UsuarioService();
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		
	//	System.out.println(Crypt.hash(pass));
		
		try {
			Sistema.cargarDatos();
		} catch (SQLException | NoExisteTematicaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	/*	for(Usuario U: Sistema.getUsuarios() ) {
			U.setPass(Crypt.hash(U.getNombre()));
			try {
				use.update(U);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
		if(Sistema.login(new Usuario(user), pass)) {			
			request.getSession().setAttribute("usuario", Sistema.getUsuarioActual().getNombre());
			request.getSession().setAttribute("preferencia", Sistema.getUsuarioActual().getPreferencia());
			request.getSession().setAttribute("monedas", Sistema.getUsuarioActual().getCantidadMonedas());
			request.getSession().setAttribute("tiempo", Sistema.getUsuarioActual().getTiempoDisponible());
			//response.sendRedirect("index.jsp");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.do");
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("error","Usuario y/o Contraseña incorrectos");
						
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
