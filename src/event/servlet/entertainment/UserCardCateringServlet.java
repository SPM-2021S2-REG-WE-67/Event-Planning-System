package event.servlet.entertainment;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.dao.EntertainmentDao;
import event.model.Caterings;


@WebServlet("/listcardcatering")
public class UserCardCateringServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntertainmentDao CateringsDao;

	public void init() {
		CateringsDao = new EntertainmentDao();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		List<Caterings> listCaterings = CateringsDao.selectAllCaterings();
		// System.out.print(listUser);
		request.setAttribute("listCaterings", listCaterings);
		RequestDispatcher dispatcher = request.getRequestDispatcher("UserCateringCardList.jsp");
		dispatcher.forward(request, response);
		
	}

	
}