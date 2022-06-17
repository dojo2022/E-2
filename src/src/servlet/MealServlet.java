package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MealDao;
import model.Meal;
import model.Result;

/**
 * Servlet implementation class MealServlet
 */
@WebServlet("/MealServlet")
public class MealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/meal.jsp");//この中のmealをファイル名に変えてください
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("ID");
		int foodnumber = Integer.parseInt(request.getParameter("fnumber"));
		Date daily = request.changeSessionId("day");
		String meal = request.getParameter("me");
		String satiety = request.getParameter("sati");

		MealDao mDao = new MealDao();
		if (mDao.meal(new Meal(userid, foodnumber, daily, meal, satiety))) { //登録成功
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/meal.jsp");
			dispatcher.forward(request, response);
		} else { // 登録失敗
			request.setAttribute("result",
					new Result("登録失敗！", "レコードを登録できませんでした。", "/healthcare/MealServlet"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			dispatcher.forward(request, response);
		}

	}

}
