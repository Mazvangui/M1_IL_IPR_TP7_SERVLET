package tp.mri.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChatServlet
 */
@WebServlet("/chat")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private StringBuffer chatContent;
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public ChatServlet() {
		chatContent = new StringBuffer();

		chatContent.append("\nBienvenue sur le chat").append("\n");

		chatContent.append("Soyez polis").append("\n");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			request.setAttribute("logger", request.getParameter("loginName"));
		}
		if (action != null && action.equals("submit")) {
		    chatContent.append("\n"+request.getParameter("ligne"));
		}
		RequestDispatcher rd = request.getRequestDispatcher("chat.jsp");

		request.setAttribute("content", chatContent.toString());

		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
