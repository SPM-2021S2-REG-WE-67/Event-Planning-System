package event.servlet.photography;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import photography.dao.PhotographyDao;
import photography.model.Photography;


@WebServlet("/updatephotography")
public class PhotographyUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PhotographyDao PhotographyDao;

	public void init() {
		PhotographyDao = new PhotographyDao();
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
		String location = request.getParameter("location");
		String workingdays = request.getParameter("workingdays");
		
	

		Photography photography = new Photography(id,studioname, availableservices, location, workingdays);
		try {
			PhotographyDao.updatePhotography(photography);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("listphotography");
		
	}

	

}