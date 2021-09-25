package event.servlet.catering;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import catering.dao.CateringDao;
import catering.model.Catering;

@WebServlet("/listcardcatering")
public class UserCardCateringServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CateringDao CateringDao;

	public void init() {
		CateringDao = new CateringDao();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		List<Catering> listVenue = CateringDao.selectAllCatering();
		// System.out.print(listUser);
		request.setAttribute("listCatering", listCatering);
		RequestDispatcher dispatcher = request.getRequestDispatcher("UserCateringCardList.jsp");
		dispatcher.forward(request, response);
		
	}

	
}