package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		//わからんから置ておく。↓初期値
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/wrecord.jsp");//この中のloginをファイル名に変えてください
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		int weight = 0; // 体重を格納する変数

		// jspから送られてきた値を受け取る
		weight = Integer.parseInt(request.getParameter("weight")); // 体重の受け取り

		//呼び出す文を書く


		// 次の画面(jsp)に値を渡す
		request.setAttribute("weight", weight);

		// 次の画面に遷移
		request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp").forward(request, response);
	}

}
