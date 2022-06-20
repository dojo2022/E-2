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
import model.Loginuser;
import model.Result;
import model.Userdata;

/**
 * Servlet implementation class IdentityServlet
 */
@WebServlet("/IdentityServlet")
public class IdentityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/identity.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String userid =request.getParameter("ID");
		String password = request.getParameter("password");

		//認証処理
		UserDao uDao = new UserDao();
		if (request.getParameter("submit").equals("login")) { // 認証成功
			if (uDao.LoginOK(new Userdata(userid, password))) {

				HttpSession session = request.getSession();
				session.setAttribute("id", new Loginuser(userid));

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
		}
	}
}
