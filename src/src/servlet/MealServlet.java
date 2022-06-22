package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MealDao;
import model.Meal;
import model.Result;
import model.Userdata;

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
		//画像と満腹度の呼び出し
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Userdata userid = (Userdata) session.getAttribute("userid");
		MealDao mDao = new MealDao();
		Meal meal = mDao.imgfind();
		request.setAttribute("meal", meal);
		Meal satiety = mDao.imgfind();
		request.setAttribute("meal", satiety);


				// 結果ページにフォワードする
		if (session.getAttribute("userid") == null) {
			response.sendRedirect("/healthcare/LoginServlet");
			return;
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/meal.jsp");//この中のmealをファイル名に変えてください
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String userid = request.getParameter("ID");
		int foodnumber = Integer.parseInt(request.getParameter("fnumber"));
		String daily = year + "-" + month + "-" + day;
		Date sqldate = Date.valueOf("daily");
		String meal = request.getParameter("me");
		int satiety = Integer.parseInt(request.getParameter("sati"));

		MealDao mDao = new MealDao();
		if (mDao.meal(new Meal(userid, foodnumber, daily, meal, satiety))) { //過去データの検索成功
			request.setAttribute("result",
					new Result("", "", "/healthcare/MealresutServlet"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/meal.jsp");
			dispatcher.forward(request, response);
		} else { // 過去データの検索失敗
			request.setAttribute("result",
					new Result("登録失敗！", "レコードを登録できませんでした。", "/healthcare/MealServlet"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			dispatcher.forward(request, response);
		}
	}
}
