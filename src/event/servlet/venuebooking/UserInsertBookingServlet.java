package event.servlet.venuebooking;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.dao.VenueBookingDao;
import event.model.VenueBooking;


@WebServlet("/insertuserVenueBook")
public class UserInsertBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VenueBookingDao VenueBookingDao;
	
	public void init() {
		VenueBookingDao = new VenueBookingDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		String user = request.getParameter("User");
		int mobile = Integer.parseInt(request.getParameter("Mobile"));
		String nic = request.getParameter("Nic");
		String email = request.getParameter("Email");
		int numberofguests = Integer.parseInt(request.getParameter("NumberOfGuests"));
		String additionalservices = (request.getParameter("AdditionalServices"));
		String bookingdate = (request.getParameter("BookingDate"));
		int advancedpayment = Integer.parseInt(request.getParameter("AdvancedPayment"));
		
		VenueBooking venue = new VenueBooking( user, mobile, nic,email,numberofguests,additionalservices,bookingdate,advancedpayment);
		try {
			VenueBookingDao.insertVenueBook(venue));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("listUserVenueBook");
	
	}

	

}