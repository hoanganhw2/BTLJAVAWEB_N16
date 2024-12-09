package Controller.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.javatuples.Pair;

import objects.User;
import service.UserService;



@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String URLPAGE ="/WEB-INF/view/client";
    private  UserService userService;
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	userService= new UserService();
    	super.init();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("user")!=null) {
			response.sendRedirect(request.getContentType()+"/");
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(URLPAGE+"/login.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username").toString();
		String password = request.getParameter("password").toString();
		String error ="";
		if(username.trim().equals("") || username.length()<5 || password.trim().equals("") || password.length()<5 )
		{
			error="Tài khoản và mật khẩu phải trên 5 ký tự";
			request.setAttribute("error", error);
			doGet(request, response);
		}else {
		
		Pair<User, String> pair  = this.userService.getUser(username, password);
		User user = pair.getValue0();
		if(user!=null) {
			System.out.println(user.getUser_name());
			System.out.println(user.getUser_pass());
			HttpSession session=  request.getSession();
			session.setAttribute("user",user);
			session.setAttribute("login", "Đăng nhập thành công!");
			response.sendRedirect(request.getContextPath()+"/");
			
		}else
			{	
			System.out.println("Không thành công");
			error="Tài khoản hoặc mật khẩu không đúng";
			request.setAttribute("error", error);
			doGet(request, response);
		}
		
		}
	}


	

}
