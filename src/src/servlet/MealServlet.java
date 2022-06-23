package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.MealDao;
import model.Loginuser;
import model.Meal;
import model.Result;

/**
 *
 * Servlet implementation class MealServlet
 */
@MultipartConfig(location = "C:\\pleiades\\workspace\\healthcare\\WebContent\\mealimg")
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
		Part part = request.getPart("IMAGE");// getPartで取得
		String image = this.getFileName(part);
		Loginuser userid = (Loginuser) session.getAttribute("userid");
		MealDao mDao = new MealDao();

		Meal meal = mDao.imgfind();

		request.setAttribute("meal", meal);

		Meal satiety = mDao.imgfind();

		request.setAttribute("meal", satiety);

		/*
						// 結果ページにフォワードする
				if (session.getAttribute("userid") == null) {
					response.sendRedirect("/healthcare/LoginServlet");
					return;
				}
		*/
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/meal.jsp");//この中のmealをファイル名に変えてください
		dispatcher.forward(request, response);
	}

	private String getFileName(Part part) {
        String name = null;
        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
            if (dispotion.trim().startsWith("filename")) {
                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
                name = name.substring(name.lastIndexOf("\\") + 1);
                break;
            }
        }		// TODO 自動生成されたメソッド・スタブ
		return name;
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
					new Result("登録成功!", "食事記録へ戻る", "/healthcare/MealresultServlet"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/meal.jsp");
			dispatcher.forward(request, response);
		} else { // 過去データの検索失敗
			request.setAttribute("result",
					new Result("登録失敗！", "食事記録へ戻る", "/healthcare/MealServlet"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			dispatcher.forward(request, response);
		}
	}
}