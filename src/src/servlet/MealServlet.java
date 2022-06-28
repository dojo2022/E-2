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
import model.Meal;
import model.Result;

/**
 *
 * Servlet implementation class MealServlet
 */
@MultipartConfig(location = "C:\\dojo6\\src\\WebContent\\mealimg")
@WebServlet("/MealServlet")
public class MealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();


		/*// 結果ページにフォワードする
		if (session.getAttribute("userid") == null) {
		response.sendRedirect("/healthcare/LoginServlet");
		return;
		}

<<<<<<< HEAD

		Part part = request.getPart("IMAGE");// getPartで取得
		String image = this.getFileName(part);


		Loginuser userid = (Loginuser) session.getAttribute("userid");
=======
		Loginuser userid = (Loginuser) session.getAttribute("userid");
		*/

		//画像と満腹度の呼び出し
		//Part part = request.getPart("IMAGE");// getPartで取得
		//String img = this.getFileName(part);


		MealDao mDao = new MealDao();

		Meal meal = mDao.imgfind();

		request.setAttribute("meal", meal);

		Meal satiety = mDao.imgfind();

		request.setAttribute("meal", satiety);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/meal.jsp");//この中のmealをファイル名に変えてください
		dispatcher.forward(request, response);
	}

	/*
		private String getFileName(Part part) {
	    String name = null;
	    for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
	        if (dispotion.trim().startsWith("filename")) {
	            name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
	            name = name.substring(name.lastIndexOf("\\") + 1);
	            break;
	        }
	    }
			return name;
		}
		*/
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Part part = request.getPart("IMAGE"); // getPartで取得
		String image = this.getFileName(part);
		request.setAttribute("image", image);
		// サーバの指定のファイルパスへファイルを保存
		//場所はクラス名↑の上に指定してある
		part.write(image);

		int foodnumber = 0;
		//int mealday;
		String userid = request.getParameter("ID");
		String mealnumber = request.getParameter("fnumber");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		//if文
		int mealday;
		if (!request.getParameter("mealday").equals("") && request.getParameter("mealday") != null) {
			mealday = Integer.parseInt(request.getParameter("mealday"));
		} else {
			mealday = 0;
		}
		String daily = year + "-" + month + "-" + day;
		Date sqldate = Date.valueOf(daily);
		System.out.println(sqldate);
		String meal = request.getParameter("me");
		int satiety = Integer.parseInt(request.getParameter("sati"));

		switch (foodnumber) {
		case 1:
			foodnumber = Integer.parseInt(mealnumber);
			foodnumber = 1;
			break;
		case 2:
			foodnumber = Integer.parseInt(mealnumber);
			foodnumber = 2;
			break;
		case 3:
			foodnumber = Integer.parseInt(mealnumber);
			foodnumber = 3;
			break;
		case 4:
			foodnumber = Integer.parseInt(mealnumber);
			foodnumber = 4;
			break;
		default:
			foodnumber = Integer.parseInt(mealnumber);
			foodnumber = 0;
			break;
		}

		//食事記録の登録
		MealDao fDao = new MealDao();
		if (fDao.meal(new Meal(userid, foodnumber, daily, meal, satiety))) { // 登録成功
			request.setAttribute("result",
					new Result("登録成功!", "食事記録へ戻る", "/healthcare/MealresulttServlet"));
		} else { // 登録失敗
			request.setAttribute("result",
					new Result("登録失敗！", "食事記録へ戻る", "/healthcare/MealServlet"));
		}

		//過去データの検索
		MealDao mDao = new MealDao();
		if (mDao.select(new Meal(userid, foodnumber, daily)) != null) { //過去データの検索成功
			request.setAttribute("result",
					new Result("検索成功!", "食事記録へ戻る", "/healthcare/MealServlet"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/meal.jsp");
			dispatcher.forward(request, response);
		} else { // 過去データの検索失敗
			request.setAttribute("result",
					new Result("検索失敗！", "食事記録へ戻る", "/healthcare/MealServlet"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			dispatcher.forward(request, response);
		}
	}

	private String getFileName(Part part) {
		String name = null;
		for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
			if (dispotion.trim().startsWith("filename")) {
				name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
				name = name.substring(name.lastIndexOf("\\") + 1);
				break;
			}
		} // TODO 自動生成されたメソッド・スタブ
		return name;
	}
}