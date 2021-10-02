package event.servlet.photographybooking;

import java.io.IOException;

import photography.dao.PhotographyBookingDao;


@WebServlet("/newUserPhotographyBook")

public class UserAddPhotographyBookingServlet extends HttpServlet {
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
		Cookie c1[] = request.getCookies();

		System.out.println("Cookies get for Photography Booking ");
		System.out.println(c1[0].getValue());
		String loginuser = c1[0].getValue();
		System.out.println("Request");
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("AddBookUser.jsp");
		request.setAttribute("user", loginuser);
		dispatcher.forward(request, response);
	}

	
}