package controller.tickets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import app.NoExisteTematicaException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Ticket;
import model.Usuario;
import services.TicketService;
import services.UsuarioService;

@WebServlet("/tickets-list.admin")
public class ListAdminTicketServlet extends HttpServlet {
	
	private static final long serialVersionUID = 718481580909136459L;
	private TicketService ticketService;
	private UsuarioService usuarioService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.ticketService = new TicketService();	
		this.usuarioService = new UsuarioService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Ticket> tickets = null;
		List<Usuario> usuarios = null;
		
		try {
			tickets = ticketService.findAll();
			usuarios = usuarioService.findAll();
			request.setAttribute("tickets", tickets);
			request.setAttribute("usuarios", usuarios);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/admin/ticket-list.jsp");
			
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NoExisteTematicaException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
