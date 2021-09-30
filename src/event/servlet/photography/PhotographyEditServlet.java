package event.servlet.photography;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import photography.dao.PhotographyDao;
import photography.model.Photography;


@WebServlet("/editphotography")
public class PhotographyEditServlet extends HttpServlet {
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
		Photography photography = PhotographyDao.selectPhotography(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("NewPhotography.jsp");
		request.setAttribute("user", PhotographyDao);
		dispatcher.forward(request, response);
		
	}

	

}