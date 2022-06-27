package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SportDao;
import dao.UserDao;
import dao.WeightDao;
import model.Caloriesout;
import model.Loginuser;
import model.Userdata;
import model.Weight;

/**
 * Servlet implementation class MypageServlet
 */
@WebServlet("/MypageServlet")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**s
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		if (session.getAttribute("userid") == null) {
			response.sendRedirect("/healthcare/LoginServlet");
			return;
		}
		Loginuser userid = (Loginuser) session.getAttribute("userid");
		WeightDao wDao = new WeightDao();
		Userdata tagweight = wDao.findtagweight(userid);
		request.setAttribute("tagweight", tagweight);

		UserDao uDao = new UserDao();
		Userdata daily = uDao.finddaily(userid);
		request.setAttribute("daily", daily);

		List<Weight> findlist = wDao.findAll(userid);
		request.setAttribute("findlist", findlist);

		SportDao sDao = new SportDao();
		List<Caloriesout> findout = sDao.findAll(userid);
		request.setAttribute("findout", findout);


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
