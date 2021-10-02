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
import event.model.entertainment;

@WebServlet("/listEntertainment")
public class EntertainmentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	privateEntertainmentDao EntertainmentDao;

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
		List<Entertainment> listEntertainment = EntertainmentDao.selectAllEntertainment();
		// System.out.print(listUser);
		request.setAttribute("listEntertainment", listEntertainment);
		RequestDispatcher dispatcher = request.getRequestDispatcher("entertainmentlist.jsp");
		dispatcher.forward(request, response);

	}

}