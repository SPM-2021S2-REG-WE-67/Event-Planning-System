package event.servlet.catering;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import catering.dao.CateringDao;
import catering.model.Catering;


@WebServlet("/updatecatering")
public class CateringUpdateServlet extends HttpServlet {
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
		int id = Integer.parseInt(request.getParameter("id"));
		String cateringname = request.getParameter("cateringname");
		String cateringmenudetails = request.getParameter("cateringmenudetails");
		String workingdays = request.getParameter("workingdays");
		String location = request.getParameter("location");
	

		Catering catering = new Catering(id,cateringname, cateringmenudetails, workingdays, location);
		try {
			CateringDao.updateCatering(catering);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("listcatering");
		
	}

	

}