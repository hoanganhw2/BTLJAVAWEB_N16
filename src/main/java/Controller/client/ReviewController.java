package Controller.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import objects.ProductReview;
import service.ProductService;

/**
 * Servlet implementation class ReviewController
 */
@WebServlet("/product/review")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private ProductService productService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    public void init() throws ServletException {
    	
    	super.init();
    	productService= new ProductService();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String product_id = request.getParameter("id");
		String rating = request.getParameter("product_review_rating");
		String content = request.getParameter("product_review_content");
		HttpSession session = request.getSession();
		int user_id = Integer.parseInt(session.getAttribute("id").toString());
		ProductReview productReview = new ProductReview();
		productReview.setProductreview_userid(user_id);
		productReview.setProductreview_ratingscore(Integer.parseInt(rating));
		productReview.setProductreview_productid(Integer.parseInt(product_id));
		productReview.setProductreview_content(content);
		productReview.setProductreview_status(1);
		if(productService.addProductReview(productReview))
		{
			session.setAttribute("msg", "Đã thêm bình luận");
			this.productService.relaseConnection();
			response.sendRedirect(request.getContextPath()+"/product?id="+product_id);
		}
		
	}

}
