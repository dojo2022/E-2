package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ContactDao;
import model.Contact;
import model.Result;

/**
 * Servlet implementation class ContactServlet
 */
@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		if (session.getAttribute("Userid") == null) {
			response.sendRedirect("/healthcare/LoginServlet");
			return;
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/contact.jsp");
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

        ContactDao cDao = new ContactDao();
        if (cDao.contactin(new Contact (userid , email ,contact))) {	// 登録成功
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/contactcomplete.jsp");
    		dispatcher.forward(request, response);
		}
		else {												// 登録失敗
			request.setAttribute("result",
			new Result("登録失敗！", "レコードを登録できませんでした。", "/healthcare/MypageServlet"));
			RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			 dispatcher.forward(request, response);
		}
	}
}
