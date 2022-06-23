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
<<<<<<< HEAD

		request.setCharacterEncoding("UTF - 8");
=======
		request.setCharacterEncoding("UTF-8");
>>>>>>> f45ddac65096127e155f228acd48c30810617c91
		String userid = request.getParameter("ID");
        String password = request .getParameter ("PW");
		String email = request.getParameter("EMAIL");
        String gender =request. getParameter("GENDER") ;
        String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String indaily = year + "-" + month + "-" + day;
		Date sqldate = Date.valueOf(indaily);
        double targetweight = Double.parseDouble(request.getParameter("TARGETWEIGHT"));
        int daily =Integer.parseInt(request.getParameter("DAILY"));
        java.sql.Date lastlogin =  Date.valueOf (request.getParameter("LASTLOGIN"));
        	double height  =Double.parseDouble(request.getParameter("HEIGHT"));

        UserDao uDao = new UserDao();
		if (uDao.userdata(new Userdata (userid, password ,email ,gender ,sqldate ,targetweight ,daily ,lastlogin ,height))){	// 新規登録画面成功
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
    		dispatcher.forward(request, response);

			// セッションスコープにIDを格納する
			HttpSession session = request.getSession();
			session.getAttribute("");
						response.sendRedirect("/healthcare/LoginServlet");
		}

		else {					// 新規登録失敗
				request.setAttribute("result",
				new Result("登録失敗！", "ログインページへ戻る ", "/healthcare/LoginServlet"));

									// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
				dispatcher.forward(request, response);
			}
	}
}

