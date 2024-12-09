package Controller.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ValidateUtils.UserValidate;
import objects.User;
import service.UserService;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String URLPAGE ="/WEB-INF/view/client";   
	private UserService userService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
        
    }
    @Override
    public void init() throws ServletException {
    	userService = new UserService();
    	super.init();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(URLPAGE+"/register.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int count = 0;
		String user_name = request.getParameter("username");
		String user_pass = request.getParameter("userpass");
		String user_fullname = request.getParameter("userfullname");
		String user_gender = request.getParameter("usergender");
		String user_email = request.getParameter("useremail");
		String user_phone = request.getParameter("userphone");
		String user_address = request.getParameter("useraddress");
		Map<String,String> errors = new HashMap<>();
		if(user_name==null || user_name.trim().length()<5) {
			errors.put("errorName", "Tài khoản phải từ 5 ký tự trở lên");
			count++;
		}
		if(user_pass == null  || user_pass.trim().length()<5) {
			errors.put("errorPass", "Mật khẩu phải từ 5 ký tự trở lên");
			count++;
		}
		if(user_fullname==null || user_fullname.trim().equals("")) {
			errors.put("errorFullname", "Tên không được trống");
			count++;
		}
		if(!UserValidate.getInstance().isEmail(user_email))
		{
			errors.put("errorEmail", "Email không đúng");
			count++;
		}
		
		if(! UserValidate.getInstance().isPhone(user_phone)) {
			errors.put("errorPhone", "Số điện thoại phải 10 chữ số");
			count ++;
			
		}
		if(user_address==null || user_address.trim().equals("")) {
			errors.put("errorAddress", "Địa chỉ không được trống");
		}	
		
		if(count !=0) {
			request.setAttribute("errors", errors);
			doGet(request, response);
		}else {
			User user = new User();
			user.setUser_name(user_name);
			user.setUser_pass(user_pass);
			user.setUser_fullname(user_fullname);
			if(user_gender.equals("Nam")) {
				user.setUser_gender(1);
			}else
			{
				user.setUser_gender(0);
			}
			user.setUser_email(user_email);
			user.setUser_phone(user_phone);
			user.setUser_address(user_address);
			user.setUser_image("");
			user.setUser_role(1);
			if(userService.add(user)) {
				// đóng kết nối khi thực hiện song
				this.userService.relaseConnection();
				String msg ="Đăng ký thành công";
				HttpSession session = request.getSession();
				session.setAttribute("msg", msg);
				response.sendRedirect(request.getContextPath()+"/login");
			}else {
				String msg = "Đăng ký thất bại";
				request.setAttribute("msg", msg);
				doGet(request, response);
			}
			
		}
		
	}

}
