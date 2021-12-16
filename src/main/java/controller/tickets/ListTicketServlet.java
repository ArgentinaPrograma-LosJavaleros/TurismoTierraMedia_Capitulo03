package controller.tickets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Ticket;
import services.TicketService;

@WebServlet("/tickets/list.do")
public class ListTicketServlet extends HttpServlet {
	
	private static final long serialVersionUID = 718481580909136459L;
	private TicketService ticketService;

	@Override
	public void init() throws ServletException {
		super.init();
		ticketService = new TicketService();	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Ticket> tickets = null;
		
		try {
			tickets = ticketService.findAllBy("id_usuario","=", (String) request.getParameter("id_user"));
			request.setAttribute("tickets", tickets);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ticket.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
