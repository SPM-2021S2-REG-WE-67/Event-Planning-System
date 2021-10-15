package event.servlet.pdf;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.dao.CateringsDao;
@WebServlet("/cateringpdf")
public class CateringPdf extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CateringsDao CateringsDao;

	public void init() {
		CateringsDao = new CateringsDao();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		RequestDispatcher dispatcher = request.getRequestDispatcher("ExportcateringPdf.jsp");
		dispatcher.forward(request, response);
	}

	
}