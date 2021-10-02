package event.servlet.cateringbooking;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import catering.dao.CateringsBookingDao;
import catering.model.CateringBooking;

@WebServlet("/insertuserCateringBook")
public class UserInsertBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CateringsBookingDao CateringsBookingDao;
	
	public void init() {
		CateringsBookingDao = new CateringsBookingDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		String user = request.getParameter("user");
		String nic = request.getParameter("nic");
		int mobile = Integer.parseInt(request.getParameter("mobile"));
		String email = request.getParameter("email");
		String bookingdate = (request.getParameter("bookingdate"));
		String additionalneeds = (request.getParameter("additionalneeds"));
		int noofplates = Integer.parseInt(request.getParameter("noofplates"));
		int advancedPayment = Integer.parseInt(request.getParameter("advancedPayment"));
		
		CateringBooking rm = new CateringBooking( user, nic, mobile,email,bookingdate,additionalneeds,noofplates,,advancedPayment);
		try {
			CateringsBookingDao.insertCateringsBook(rm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("listUserCateringBook");
	
	}

	

}