package Controller.admin.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import objects.Product;
import service.ProductService;


@WebServlet("/admin/product/delete")
public class DeleteProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private ProductService productService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	productService = new ProductService();
    	super.init();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("ma")+"";
		request.setAttribute("id", id);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/view/admin/product/delete.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Product product = new Product();
		product.setProduct_id(id);
		if(productService.delete(product)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("toastMessage", "Xóa thành công!");
			response.sendRedirect(request.getContextPath() + "/admin/product");
					
		}
		this.productService.relaseConnection();
	}

}
