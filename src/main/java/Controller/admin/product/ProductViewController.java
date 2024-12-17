package Controller.admin.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import objects.Product;
import service.ProductService;

/**
 * Servlet implementation class ProductViewController
 */
@WebServlet("/admin/product/view")
public class ProductViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ProductService productService ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductViewController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	productService = new ProductService();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = request.getParameter("id")==null ? 1 : Integer.parseInt(request.getParameter("id"));
		Product product = this.productService.getProduct(id).getValue0();
		request.setAttribute("product", product);
		this.productService.relaseConnection();
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/admin/product/view.jsp");
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
