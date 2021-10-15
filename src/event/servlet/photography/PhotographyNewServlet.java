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

@WebServlet("/newphotography")
public class PhotographyNewServlet extends HttpServlet {
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

		RequestDispatcher dispatcher = request.getRequestDispatcher("Newphotography.jsp");
		dispatcher.forward(request, response);
	}

	
}