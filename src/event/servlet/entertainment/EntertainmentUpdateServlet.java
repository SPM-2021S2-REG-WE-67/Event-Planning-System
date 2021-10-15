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


@WebServlet("/updateentertainment")
public class EntertainmentUpdateServlet extends HttpServlet {
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
		String resourcename = request.getParameter("resourcename");
		String typeofentertainment = request.getParameter("typeofentertainment");
		String workingdays = request.getParameter("workingdays");
		String location = request.getParameter("location");
	

		Entertainments entertainment = new Entertainments(id,resourcename, typeofentertainment, workingdays, location);
		try {
			EntertainmentsDao.updateentertainments(entertainment);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("listentertainment");
		
	}

	

}