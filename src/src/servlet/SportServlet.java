package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SportDao;
import dao.WeightDao;
import model.LoginUser;
import model.Result;
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
		request.setCharacterEncoding("UTF-8");
		int time = Integer.parseInt( request.getParameter("time"));
		double weight = Double.parseDouble(request.getParameter("weight"));
		double number = .parseDouble(request.getParameter("mets"));

		SportDao sport = new SportDao();
		if (request.getParameter("SUBMIT").equals("計算")) {
			if (sport.sportscalc(time, weight)) { // 計算成功
				// セッションスコープにIDを格納する
				HttpSession session = request.getSession();
				session.setAttribute("id", new LoginUser(id));

			} else { // 計算失敗
				// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
				request.setAttribute("result",
						new Result("ログイン失敗！", "IDまたはPWに間違いがあります。", "/simpleBC/LoginServlet"));

				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

}
