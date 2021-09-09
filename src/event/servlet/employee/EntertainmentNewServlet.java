package event.servlet.employee;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.dao.EntertainmentDao;
import event.model.entertainment;

@WebServlet("/newEntertainment")
public class EntertainmentNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntertainmentDao EmployeeDao;

	public void init() {
		EntertainmentDao = new EntertainmentDao();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		RequestDispatcher dispatcher = request.getRequestDispatcher("AddEmployee.jsp");
		dispatcher.forward(request, response);
	
	}
	

}