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

import dao.UserDao;
import model.Loginpass;
import model.Loginuser;
import model.Result;
import model.Userdata;
import model.Userdatas;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("ID");
		String password = request.getParameter("PW");
		Userdata user = null;


		// ログイン処理を行う
		UserDao uDao = new UserDao();
		//WeightDao wDao = new WeightDao();
		if (request.getParameter("submit").equals("login")) {
			if (uDao.LoginOK(new Userdata(userid, password))) {
				// ログイン成功
				HttpSession session = request.getSession();
				session.setAttribute("userid", new Loginuser(userid));
				session.setAttribute("password", new Loginpass(password));

				user = uDao.findlastday(userid);
				Userdatas users = new Userdatas();
				Date todays = users.today();
				//初回ログインか判定
				if (user.getLastlogin().equals (todays)) {
					//session.setAttribute("password", new Loginday(lastlogin));
					// 2回目以降、メニューサーブレットにリダイレクトする
					response.sendRedirect("/healthcare/MypageServlet");
	            }else {
	            	//初回の場合

	        		uDao.updatelastday(userid);
					response.sendRedirect("/healthcare/WrecordServlet");
	            }
			} else { // ログイン失敗
				// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
				request.setAttribute("result",
						new Result("IDまたはパスワードに間違いがあります。", "ログインページへ戻る", "/healthcare/LoginServlet"));
				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
				dispatcher.forward(request, response);
			}
			} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/signup.jsp");
			dispatcher.forward(request, response);
		}
	}
}


