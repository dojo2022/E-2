package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import dao.WeightDao;
import model.Loginuser;
import model.Weight;

/**
 * Servlet implementation class WrecordServlret
 */
@WebServlet("/WrecordServlet")
public class WrecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WrecordServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//jspからjspから値を受け取って、結果を返却する
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("userid") == null) {
			response.sendRedirect("/healthcare/LoginServlet");
			return;
		}
		Loginuser userid = (Loginuser) session.getAttribute("userid");
		UserDao uDao = new UserDao();
		if(uDao.uplogin(userid)) {

		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/wrecord.jsp");//この中のloginをファイル名に変えてください
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		//String userid = new String();//IDを格納する
		int weight = 0; // 体重を格納する変数
		Date indaily = new Date(); //日付けを格納する変数

		// jspから送られてきた値を受け取る
		weight = Integer.parseInt(request.getParameter("weight")); // 体重の受け取り

		//呼び出す文を書く
		Weight w = new Weight();
		HttpSession session = request.getSession();
		Loginuser user = (Loginuser) session.getAttribute("userid");
		w.setUserid(user.getUserid());
		w.setWeight(weight);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fd = sdf.format(indaily);
		w.setIndaily(java.sql.Date.valueOf(fd));

		WeightDao wDao = new WeightDao();
		wDao.saveweight(w);

		// 次の画面(jsp)に値を渡す
		//request.setAttribute("weight", weight);

		// 次の画面に遷移
		response.sendRedirect("/healthcare/MypageServlet");
	}

}
