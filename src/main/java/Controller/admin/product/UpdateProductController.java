package Controller.admin.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import objects.Category;
import objects.Product;
import service.ProductService;
import service.UploadFileService;
import service.UserService;

/**
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/admin/product/update")
public class UpdateProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private UserService userService;
	    private UploadFileService uploadFileService;
	    private ProductService productService;
	    private final String folder = "product";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	this.userService= new UserService();
    	this.uploadFileService = new UploadFileService();
    	this.productService= new ProductService();
    	super.init();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id").toString();
		String url="";
		if(id!=null) {
			try {
				int product_id = Integer.parseInt(id);
				List<Category> categorys = this.userService.getAllCategory();
				request.setAttribute("categorys", categorys);
				Product product=this.productService.getProduct(product_id);
				request.setAttribute("product", product);
				url="/WEB-INF/view/admin/product/update.jsp";
			} catch (NumberFormatException e) {
				// TODO: handle exception
			}
			
			
		}	
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
