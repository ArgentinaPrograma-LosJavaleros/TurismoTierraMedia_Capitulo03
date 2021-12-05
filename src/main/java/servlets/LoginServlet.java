package servlets;

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
import utils.Crypt;

@WebServlet("/login")
public class LoginServlet extends HttpServlet implements Servlet{

	private static final long serialVersionUID = 2394449831904434113L;
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
//		System.out.println(Crypt.hash(pass));
		
		try {
			Sistema.cargarDatos();
		} catch (SQLException | NoExisteTematicaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(Sistema.login(new Usuario(user), pass)) {			
			request.getSession().setAttribute("usuario", Sistema.getUsuarioActual().getNombre());
			
			//response.sendRedirect("index.jsp");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

}
