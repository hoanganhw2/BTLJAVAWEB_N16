package Controller.client;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import objects.Product;
import service.ProductService;

/**
 * Servlet implementation class GetProductDetailPage
 */
@WebServlet("/product")
public class ProductDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      ProductService productService ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	super.init();
    	productService= new ProductService();
    	System.out.println("productService xem san pham dc tao");
    	
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Optional<String> id = Optional.of(request.getParameter("id"));
		if(id.isPresent() && Integer.parseInt(id.get().toString())>=1) {
			Product product = this.productService.getProduct(Integer.parseInt(id.get().toString()));
			this.productService.relaseConnection();
			request.setAttribute("product", product);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/client/productDetail.jsp");
	        dispatcher.forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
