package event.servlet.entertainment;

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
import event.model.Entertainments;


@WebServlet("/editentertainment")
public class EntertainmentEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntertainmentDao EntertainmentsDao;

	public void init() {
		EntertainmentsDao = new EntertainmentDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		int id = Integer.parseInt(request.getParameter("id"));
		Entertainments entertainment = EntertainmentsDao.selectEntertainment(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Newentertainment.jsp");
		request.setAttribute("user", entertainment);
		dispatcher.forward(request, response);
		
	}

	

}