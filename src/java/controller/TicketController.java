package controller;

import java.sql.SQLException;
import java.util.List;

import dao.TicketDAOImp;
import model.Ticket;

public class TicketController extends TicketDAOImp {
	@Override
	public List<Ticket> findAll()  throws SQLException{
		return super.findAll();
	}
	
	@Override	
	public int countAll() throws SQLException {
		 return super.countAll();	
	}
	
	@Override	
	public int insert(Ticket t) throws SQLException {
		return super.insert(t);
	}

	@Override
	public int update(Ticket t) throws SQLException {
		return super.update(t);
	}

	@Override
	public int delete(Ticket t) throws SQLException {
		return super.delete(t);
	}

	@Override
	public int deleteBy(String campo, String operador, String valor) throws SQLException {
		return super.deleteBy(campo, operador, valor);
	}
	
	@Override
	public Ticket findBy(String campo, String operador, String valor) throws SQLException {
		return super.findBy(campo, operador, valor);
	}

	@Override
	public Ticket findById(int id) throws SQLException {
		return super.findById(id);
	}
	
	@Override
	public List<Ticket> findAllBy(String campo, String operador, String valor)  throws SQLException{
		return super.findAllBy(campo, operador, valor);
	}
	
}
