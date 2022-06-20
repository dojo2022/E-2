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
import model.Result;
import model.Userdata;

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
        String password = request .getParameter ("PW");
		String email = request.getParameter("EMAIL");
        String gender =request. getParameter("GENDER") ;
        java.util.Date birth = java.sql.Date.valueOf(request.getParameter("birth"));
        double targetwight =Double.parseDouble(request.getParameter("TARGETWIGHT"));
        int daily =Integer.parseInt(request.getParameter("DAILY"));
        java.util.Date lastlogin =  java.sql.Date.valueOf (request.getParameter("LASTLOGIN"));
        	double height  =Double.parseDouble(request.getParameter("HEIGHT"));

        UserDao uDao = new UserDao();
		if (uDao.nw(new Userdata (userid, password,email,gender,birth,targetwight,daily,lastlogin,height))){		// 新規登録画面成功
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

