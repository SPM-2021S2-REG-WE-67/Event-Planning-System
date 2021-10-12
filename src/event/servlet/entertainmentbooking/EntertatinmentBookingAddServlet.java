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




@WebServlet("/insertEntertainmentBook")
public class EntertatinmentBookingAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntertainmentBookingDao EntertatinmentBookingDao;
	
	public void init() {
		EntertatinmentBookingDao = new EntertainmentBookingDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		String resourcename = request.getParameter("resourcename");
		String typeOfEntertainment = request.getParameter("typeOfEntertainment");
		int days = Integer.parseInt(request.getParameter("days"));
		String location = request.getParameter("location");
		String bookingdate = (request.getParameter("bookingdate"));
		String additionalneeds = (request.getParameter("additionalneeds"));
		
		int advancedpayment = Integer.parseInt(request.getParameter("advancedpayment"));
		
		EntertainmentBooking cat = new EntertainmentBooking( resourcename, typeOfEntertainment, days,location,bookingdate,additionalneeds,advancedpayment);
		try {
			EntertatinmentBookingDao.insertEntertainmentBook(cat);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("listEntertainmentBook");
	
	}

	

}