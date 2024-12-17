package Controller.admin.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javatuples.Pair;

import objects.User;
import service.UserService;


@WebServlet("/admin/user")
public class ShowUsercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private UserService userService ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowUsercontroller() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	userService = new UserService();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 1 ;
		int recordsPerPage = 4;
		  if(request.getParameter("page") != null) {
	            page = Integer.parseInt(request.getParameter("page"));
	        }      
		  int start = (page - 1) * recordsPerPage;   
		  Pair<List<User>,Integer> pair = userService.getAllUser(start, recordsPerPage);
		  this.userService.relaseConnection();
		  List<User> users = pair.getValue0();
		  int totalUsers = pair.getValue1();
		  int totalPages = (int) Math.ceil(totalUsers* 1.0 / recordsPerPage);	        
	        request.setAttribute("users",users);
	        request.setAttribute("currentPage", page);
	        request.setAttribute("totalPages", totalPages);	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/admin/user/show.jsp");
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
