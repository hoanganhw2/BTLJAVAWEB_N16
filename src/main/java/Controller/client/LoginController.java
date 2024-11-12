package Controller.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String URLPAGE ="/WEB-INF/view/";
    
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(URLPAGE+"login.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username").toString();
		String password = request.getParameter("password").toString();
		String message ="";
		if(username.trim().equals(""))
		{
			message="Ten khong duoc trong ";
			request.setAttribute("errorUsername", message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
			requestDispatcher.forward(request, response);
			
		}
		
		
		if (username.equals("hoanganh") && password.equals("hoanganh")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/view/ok.jsp");
			requestDispatcher.forward(request, response);
		}
		response.sendRedirect(request.getContextPath()+"/login");
		
		
	}

}
