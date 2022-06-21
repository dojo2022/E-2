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
import model.Loginuser;
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
		//消費カロリーを保存
		request.setCharacterEncoding("UTF-8");
		String indaily = request.getParameter("year");
		String indaily2 = request.getParameter("month");
		String indaily3 = request.getParameter("day");
		String caloriesout = request.getParameter("caloriesout");

		SportDao sDao = new SportDao();
		if (sDao.LoginOK(new caloriesout())) {

			HttpSession session = request.getSession();
			session.setAttribute("id", new Loginuser(userid));

			// メニューサーブレットにリダイレクトする
			response.sendRedirect("/healthcare/MypageServlet");
			}
	}


