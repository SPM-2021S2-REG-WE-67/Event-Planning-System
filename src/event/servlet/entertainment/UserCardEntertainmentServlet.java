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


@WebServlet("/listcardentertainment")
public class UserCardEntertainmentServlet extends HttpServlet {
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
		List<Entertainments> listEntertainments = EntertainmentsDao.selectAllentertainments();
		// System.out.print(listUser);
		request.setAttribute("listEntertainments", listEntertainments);
		RequestDispatcher dispatcher = request.getRequestDispatcher("UserEntertainmentCardList.jsp");
		dispatcher.forward(request, response);
		
	}

	
}