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
import model.Loginpass;
import model.Loginuser;
import model.Result;
import model.Userdata;

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

		HttpSession session = request.getSession();
		if (session.getAttribute("Userid") == null) {
			response.sendRedirect("/healthcare/LoginServlet");
			return;
		}

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

		// ログイン処理を行う
		UserDao uDao = new UserDao();
		if (request.getParameter("submit").equals("login")) {
			if (uDao.LoginOK(new Userdata(userid, password))) {
				// ログイン成功
				HttpSession session = request.getSession();
				session.setAttribute("userid", new Loginuser(userid));
				session.setAttribute("password", new Loginpass(password));

				// メニューサーブレットにリダイレクトする
				response.sendRedirect("/healthcare/MypageServlet");
			} else { // ログイン失敗
				// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
				request.setAttribute("result",
						new Result("IDまたはパスワードに間違いがあります。", "", "/healthcare/LoginServlet"));
				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
				dispatcher.forward(request, response);
			}
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Signup.jsp");
			dispatcher.forward(request, response);
		}
	}
}