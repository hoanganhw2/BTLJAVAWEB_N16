package Controller.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CartService;

/**
 * Servlet implementation class AddProductToCart
 */
@WebServlet("/cart/add")
public class AddProductToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CartService carService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductToCart() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	carService = new CartService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")==null) {
			System.out.println("Lỗi");
		}else
		{
			int productid = Integer.parseInt(request.getParameter("id"));
			HttpSession session = request.getSession(false);
			int userid = Integer.parseInt(session.getAttribute("id").toString());
			int kq =carService.addProductInCart(userid, productid,1);
			this.carService.relaseConnection();
			if(kq==1) {
				session.setAttribute("msg", "Thêm sản phẩm vào giỏ hàng thành công");
				int sum =(int) session.getAttribute("cart_sum");
				session.setAttribute("cart_sum", sum+1);
				response.sendRedirect(request.getContextPath()+"/");
			}else if (kq==0) {
				session.setAttribute("msg", "Thêm sản phẩm vào giỏ hàng thành công");
				response.sendRedirect(request.getContextPath()+"/");
			}else {
				session.setAttribute("msg", "Đã có lỗi xảy ra");
				response.sendRedirect(request.getContextPath()+"/");
			}
			
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
