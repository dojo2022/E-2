package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import dao.WeightDao;
import model.Userdata;
import model.Weight;

/**
 * Servlet implementation class BmiServlet
 */
@WebServlet("/BmiServlet")
public class BmiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		if (session.getAttribute("Userid") == null) {
			response.sendRedirect("/healthcare/LoginServlet");
			return;
		}
		// TODO Auto-generated method stub

		//体重呼び出し

		Userdata userid = (Userdata) session.getAttribute("userid");
		WeightDao wDao = new WeightDao();
		Weight weight = wDao.findweight();
		request.setAttribute("weight", weight);

		//身長呼び出し
		UserDao uDao = new UserDao();
		Userdata height = uDao.findheight();
		request.setAttribute("height", height);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bmi.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
