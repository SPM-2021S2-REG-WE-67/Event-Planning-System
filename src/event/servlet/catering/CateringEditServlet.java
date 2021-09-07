package event.servlet.catering;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.dao.CateringDao;
import event.model.Catering;
import event.model.Employee;
import event.model.Inventory;

@WebServlet("/editcatering")
public class CateringEditServlet extends HttpServlet {
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
		Catering catering = CateringDao.selectCatering(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Newcatering.jsp");
		request.setAttribute("user", catering);
		dispatcher.forward(request, response);
		
	}

	

}