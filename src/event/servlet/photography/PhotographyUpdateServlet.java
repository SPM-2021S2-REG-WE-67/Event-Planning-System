package event.servlet.photography;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.dao.PhotographysDao;
import event.model.Photographys;


@WebServlet("/updatephotography")
public class PhotographyUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PhotographysDao PhotographysDao;

	public void init() {
		PhotographysDao = new PhotographysDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		int id = Integer.parseInt(request.getParameter("id"));
		String studioname = request.getParameter("studioname");
		String availableservices = request.getParameter("availableservices");
		String workingdays = request.getParameter("workingdays");
		String location = request.getParameter("location");
	

		Photographys photography = new Photographys(id,studioname, availableservices, workingdays, location);
		try {
			PhotographysDao.updatePhotographys(photography);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("listphotography");
		
	}

	

}