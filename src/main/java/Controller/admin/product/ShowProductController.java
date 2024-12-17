package Controller.admin.product;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javatuples.Pair;

import objects.Product;
import service.ProductService;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/admin/product")
public class ShowProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private ProductService productService ;
    /**
     * @see HttpServlet#HttpServlet()
     */
      @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	  this.productService= new ProductService();
    	super.init();
    }
    public ShowProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	int page = 1;
	        int recordsPerPage = 4;
	        
	        if(request.getParameter("page") != null) {
	            page = Integer.parseInt(request.getParameter("page"));
	        }        
	        int start = (page - 1) * recordsPerPage;    
	        Pair<List<Product>, Integer> result = productService.getProducts(start, recordsPerPage);
	        this.productService.relaseConnection();
	        List<Product> products = result.getValue0();
	        int totalProducts = result.getValue1();
	        int totalPages = (int) Math.ceil(totalProducts * 1.0 / recordsPerPage);	        
	        request.setAttribute("products", products);
	        request.setAttribute("currentPage", page);
	        request.setAttribute("totalPages", totalPages);
	        
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/view/admin/product/show.jsp");
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
