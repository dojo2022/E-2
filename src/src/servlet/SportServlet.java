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

import dao.SportDao;
import dao.WeightDao;
import model.Caloriesout;
import model.Loginuser;
import model.Result;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		if (session.getAttribute("userid") == null) {
			response.sendRedirect("/healthcare/LoginServlet");
			return;
		}

		//体重呼び出し
		Loginuser userid = (Loginuser) session.getAttribute("userid");
		WeightDao wDao = new WeightDao();
		Weight weight = wDao.findweight(userid);
		request.setAttribute("weight", weight);
		//総消費カロリー呼び出し
		SportDao sDao = new SportDao();
		Caloriesout caloriesout = sDao.findcalo(userid);
		request.setAttribute("caloriesout", caloriesout);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/sports.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Loginuser userid = (Loginuser) session.getAttribute("userid");
		request.setCharacterEncoding("UTF-8");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		//if文
		int calories;
		if(!request.getParameter("calories").equals("") && request.getParameter("calories") != null) {
			calories = Integer.parseInt(request.getParameter("calories"));
		}else {
			 calories = 0;
		}
		String indaily = year + "-" + month + "-" + day;
		Date sqldate = Date.valueOf(indaily);
		System.out.println(sqldate);

		SportDao sDao = new SportDao();
		if (request.getParameter("SUBMIT").equals("保存")) {
			if (sDao.save(new Caloriesout(calories, sqldate), userid)) { // 登録成功

				request.setAttribute("result",
						new Result("登録成功", "運動計算へ戻る", "/healthcare/SportServlet"));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/sportscmp.jsp");
				dispatcher.forward(request, response);
			} else { // 登録失敗
				request.setAttribute("result",
						new Result("登録失敗！", "運動計算へ戻る", "/healthcare/SportServlet"));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
				dispatcher.forward(request, response);
			}
		} else {//日にちに対応した総消費カロリーを表示する
			Caloriesout caloriesout = sDao.findcalo(userid,sqldate);
			request.setAttribute("caloriesout", caloriesout);
			//体重呼び出し
			WeightDao wDao = new WeightDao();
			Weight weight = wDao.findweight(userid);
			request.setAttribute("weight", weight);
			request.setAttribute("year", year);
			request.setAttribute("month", month);
			request.setAttribute("day", day);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/sports.jsp");
			dispatcher.forward(request, response);
		}
	}
}
