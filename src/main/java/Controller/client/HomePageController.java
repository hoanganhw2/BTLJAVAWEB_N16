package Controller.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javatuples.Pair;
import org.javatuples.Triplet;

import objects.Category;
import objects.Product;
import service.UserService;


@WebServlet(value = "",name = "homepageController")
public class HomePageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService ;
   
    public HomePageController() {
    	super(); 
    	
    	
    	
    }

	
    @Override
    public void init() throws ServletException {
    	userService= new UserService();
    	super.init();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 1;
        int recordsPerPage = 8;
        
        if(request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }        
        int start = (page - 1) * recordsPerPage;    
        Triplet<List<Category>, List<Product>, Integer> trip = this.userService.getProductAndCategory(start, recordsPerPage);
		//đã đóng kết nối
        this.userService.relaseConnection();
		int totalProducts =trip.getValue2();
		 int totalPages = (int) Math.ceil(totalProducts * 1.0 / recordsPerPage);	 
		request.setAttribute("categorys", trip.getValue(0));
		request.setAttribute("products", trip.getValue(1));
		 request.setAttribute("currentPage", page);
	        request.setAttribute("totalPages", totalPages);
		request.setAttribute("title","Trang chủ");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/client/home.jsp");
	        dispatcher.forward(request, response);
	       
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
