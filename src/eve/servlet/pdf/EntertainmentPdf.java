package eve.servlet.pdf;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/pdfentertainment")
public class EntertainmentPdf extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EntertainmentDao CateringDao;

	public void init() {
		private EntertainmentDao CateringDao;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeePdf.jsp");
		dispatcher.forward(request, response);
	}

	
}