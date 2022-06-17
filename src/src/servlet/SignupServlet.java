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
import model.Contact;
import model.Result;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");//この中のloginをファイル名に変えてください
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("ID");
		String email = request.getParameter("EMAIL");
        String contact= request.getParameter("TEXT");
        String loginid =request. getParameter("lOGINID") ;
        String loginpassword = request .getParameter ("PW");
        String gender = request .getParameter("GENDER");
        String dateofbirth
        String targetweight
        String registration

        UserDao cDao = new UserDao();
		if (cDao.contactin(new Contact (userid, email,contact))){		// 新規登録画面成功
			// セッションスコープにIDを格納する
			HttpSession session = request.getSession();
			session.getAttribute("");
						response.sendRedirect("/healthcare/LoginServlet");
		}

		else {					// 新規登録失敗
				request.setAttribute("result",
				new Result("！", ", ", "/healthcare/LoginServlet"));

									// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
				dispatcher.forward(request, response);
			}
	}
}

