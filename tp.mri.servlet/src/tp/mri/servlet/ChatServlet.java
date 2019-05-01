package tp.mri.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChatServlet
 */
@WebServlet("/chat")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private StringBuffer chatContent;
	
    public ChatServlet() {
		chatContent = new StringBuffer();

		chatContent.append("Bienvenue sur le chat. ");

		chatContent.append("Soyez polis. ").append("\n");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("chat.jsp");
		request.setAttribute("content", chatContent.toString());
		//Création variable de Session 
		HttpSession session = request.getSession();
		
		String format = "dd/MM/yy H:mm:ss";
		String log="";
		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
		java.util.Date date = new java.util.Date();
		
		if(session.getAttribute("logger")==null) {
			rd = request.getRequestDispatcher("login.jsp");
		}
		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			log= request.getParameter("loginName");
			session.setAttribute( "logger", log );
		    request.setAttribute("content", chatContent.toString());
		    rd = request.getRequestDispatcher("chat.jsp");
		}
		if (action != null && action.equals("logOut")) {
			session.invalidate();   // logOut
			rd = request.getRequestDispatcher("login.jsp");
		}
		if (action != null && action.equals("submit") ) {
		    chatContent.append("\n"+formater.format( date )+"  "+ session.getAttribute("logger") +" > "+  request.getParameter("ligne"));
		    request.setAttribute("content", chatContent.toString());
		}
		
		rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
