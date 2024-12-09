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
		Pair<List<Category>, List<Product>>  pair= userService.getProductAndCategory();	
		this.userService.relaseConnection();
		request.setAttribute("categorys", pair.getValue(0));
		request.setAttribute("products", pair.getValue(1));
		request.setAttribute("title","Trang chủ");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/client/home.jsp");
	        dispatcher.forward(request, response);
	       
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
