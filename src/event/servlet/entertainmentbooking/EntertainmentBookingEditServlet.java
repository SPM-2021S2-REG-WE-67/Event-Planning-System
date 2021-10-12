package event.servlet.entertainmentbooking;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.dao.EntertainmentBookingDao;
import event.model.EntertainmentBooking;




@WebServlet("/editEntertainmentBook")
public class EntertainmentBookingEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntertainmentBookingDao EntertainmentBookingDao;
	
	public void init() {
		EntertainmentBookingDao = new EntertainmentBookingDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		int id = Integer.parseInt(request.getParameter("id"));
		EntertainmentBooking existingUser = EntertainmentBookingDao.selectEntertainmentBooking(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("NewCateringBook.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
	}

	

}