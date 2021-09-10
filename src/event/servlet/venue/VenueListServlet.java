package event.servlet.venue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.dao.VenueDao;
import event.model.Venue;

@WebServlet("/listvenue")
public class VenueListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VenueDao VenueDao;

	public void init() {
		VenueDao = new VenueDao();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		List<Venue> listVenue = VenueDao.selectAllVenue();
		
		// System.out.print(listUser);
		request.setAttribute("listVenue", listVenue);
		RequestDispatcher dispatcher = request.getRequestDispatcher("venuelist.jsp");
		dispatcher.forward(request, response);
		
	}

	
}