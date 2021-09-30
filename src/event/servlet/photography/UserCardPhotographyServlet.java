package event.servlet.photography;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import photography.dao.PhotographyDao;
import photography.model.Photography;

@WebServlet("/listcardphotography")
public class UserCardPhotographyServlet extends HttpServlet {
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
		List<Photography> listPhotography = PhotographyDao.selectAllPhotography();
		// System.out.print(listUser);
		request.setAttribute("listPhotography", listPhotography);
		RequestDispatcher dispatcher = request.getRequestDispatcher("UserPhotographyCardList.jsp");
		dispatcher.forward(request, response);
		
	}

	
}