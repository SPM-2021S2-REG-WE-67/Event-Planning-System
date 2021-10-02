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

@WebServlet("/updatevenue")
public class VenueUpdateServlet extends HttpServlet {
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
		int id = Integer.parseInt(request.getParameter("id"));

		String resourcename = request.getParameter("resourcename");

		String typeofvenue = request.getParameter("typeofvenue");
		String location = request.getParameter("location");
		String workingdays = request.getParameter("workingdays");
	

		Venue venue = new Venue(id,resourcename, typeofvenue, location, workingdays);
		try {
			VenueDao.updateVenue(venue);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("listvenue");
		
	}

	

}