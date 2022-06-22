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

import dao.SportDao;
import dao.WeightDao;
import model.Caloriesout;
import model.Result;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		if (session.getAttribute("Userid") == null) {
			response.sendRedirect("/healthcare/LoginServlet");
			return;
		}

		//体重呼び出し
		Userdata userid = (Userdata) session.getAttribute("userid");
		WeightDao wDao = new WeightDao();
		Weight weight = wDao.findweight();
		request.setAttribute("weight", weight);
		//総消費カロリー呼び出し
		SportDao sDao = new SportDao();
		Caloriesout caloriesout = sDao.findcalo();
		request.setAttribute("caloriesout", caloriesout);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/sports.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		int caloriesout = Integer.parseInt(request.getParameter("calories"));
		String indaily = year + "-" + month + "-" + day;
		Date sqldate = Date.valueOf(indaily);

		SportDao sDao = new SportDao();
		if (sDao.save(new Caloriesout(caloriesout, sqldate))) { // 登録成功

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/sports.jsp");
			dispatcher.forward(request, response);
		} else { // 登録失敗
			request.setAttribute("result",
					new Result("登録失敗！", "レコードを登録できませんでした。", "/simpleBC/MenuServlet"));
		}
	}
}

