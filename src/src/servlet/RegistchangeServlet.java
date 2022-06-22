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
import dao.WeightDao;
import model.Result;
import model.Userdata;

/**
 * Servlet implementation class RegistchangeServlet
 */
@WebServlet("/RegistchangeServlet")
public class RegistchangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		Object userid = session.getAttribute("userid");

		UserDao uDao = new UserDao();
		Userdata email = uDao.findemail();
		request.setAttribute("email", email);
		//身長呼び出し
		Userdata height = uDao.findheight();
		request.setAttribute("height", height);
		//目標体重
		WeightDao wDao = new WeightDao();
		Userdata tagweight = wDao.findtagweight(userid);
		request.setAttribute("tagweight", tagweight);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registchange.jsp");//この中のloginをファイル名に変えてください
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Userdata pass = (Userdata) session.getAttribute("password");
		request.setCharacterEncoding("UTF-8");
		String password = request.getParameter("PW");
		String email = request.getParameter("email");
		double height = Double.parseDouble(request.getParameter("height"));
		double targetweight = Double.parseDouble(request.getParameter("targetweight"));

		UserDao uDao = new UserDao();
		WeightDao wDao = new WeightDao();

		if (uDao.save(new Userdata(password, email,height),pass) && wDao.save(new Userdata(targetweight))) { // 登録成功

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
			dispatcher.forward(request, response);
		} else { // 登録失敗
			request.setAttribute("result",
					new Result("登録失敗！", "レコードを登録できませんでした。", "/healthcare/ResultServlet"));
		}


	}

}
