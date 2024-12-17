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
import org.javatuples.Triplet;

import objects.Cart;
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
		this.userService.relaseConnection();
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
		
		Triplet<User, String, Cart> triplet = this.userService.getUser(username, password);
		// đã dóng kết nối
		this.userService.relaseConnection();
		User user =triplet.getValue0();
		
		if(user!=null) {
			
			HttpSession session=  request.getSession();
			session.setAttribute("user",triplet);
			session.setAttribute("id", user.getUser_id());
			session.setAttribute("fullname",user.getUser_fullname() );
			int cart_sum = 0;
			if(triplet.getValue2()!=null)
			{
				cart_sum= triplet.getValue2().getCart_sum();
			}
			session.setAttribute("cart_sum",cart_sum);
			session.setAttribute("cartid", triplet.getValue2().getCart_id());
			session.setAttribute("msg", "Đăng nhập thành công!");
			if(triplet.getValue1().equals("ROLE_USER")) {
			response.sendRedirect(request.getContextPath()+"/");
			}else {
				response.sendRedirect(request.getContextPath()+"/admin");
			}
			
			
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
