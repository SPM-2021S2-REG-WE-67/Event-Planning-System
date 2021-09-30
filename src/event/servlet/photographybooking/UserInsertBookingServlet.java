package event.servlet.photographybooking;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import photography.model.PhotographyBooking;
import photography.dao.PhotographyBookingDao;

@WebServlet("/insertuserPhotographyBook")
public class UserInsertBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PhotographyBookingDao PhotographyBookingDao;
	
	public void init() {
		PhotographyBookingDao = new PhotographyBookingDao();
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
		String studioname = (request.getParameter("studioname"));
		String packagename = (request.getParameter("packagename"));
		int advancedPayment = Integer.parseInt(request.getParameter("advancedPayment"));
		
		PhotographyBooking rm = new PhotographyBooking( user, nic, mobile,email,bookingdate,studioname,packagename,advancedPayment);
		try {
			PhotographyBookingDao.insertPhotographyBook(rm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("listUserPhotographyBook");
	
	}

	

}