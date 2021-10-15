package event.servlet.photographybooking;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.dao.PhotographysBookingDao;
import event.model.PhotographyBooking;


@WebServlet("/insertuserPhotographyBook")
public class UserInsertPhotographyBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PhotographysBookingDao PhotographysBookingDao;
	
	public void init() {
		PhotographysBookingDao = new PhotographysBookingDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		String user = request.getParameter("User");
		String nic = request.getParameter("nic");
		int mobile = Integer.parseInt(request.getParameter("mobile"));
		String email = request.getParameter("email");
		String bookingdate = (request.getParameter("bookingdate"));
		String studioname = (request.getParameter("studioname"));
		String packagename = (request.getParameter("packagename"));
		int advancedpayment = Integer.parseInt(request.getParameter("advancedpayment"));
		
		PhotographyBooking pho = new PhotographyBooking(user,nic,mobile,email,bookingdate,studioname,packagename,advancedpayment);
		try {
			PhotographysBookingDao.insertPhotographysBook(pho);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("listUserPhotographyBook");
	
	}

	

}