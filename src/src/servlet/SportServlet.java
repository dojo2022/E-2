package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.WeightDao;
import model.Userdata;
import model.Weight;

/**
 * Servlet implementation class SportServlet
 */
@WebServlet("/SportServlet")
public class SportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//体重呼び出し
				HttpSession session = request.getSession();
				Userdata userid = (Userdata) session.getAttribute("userid");
				WeightDao wDao = new WeightDao();
				Weight weight = wDao.findweight();
				request.setAttribute("weight", weight);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/sports.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		java.util.Date daily = java.sql.Date.valueOf(request.getParameter("day"));

			}
	}


