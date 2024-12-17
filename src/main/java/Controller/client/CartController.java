package Controller.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import objectDTO.CartItemDTO;
import service.CartService;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CartService cartService; ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	cartService = new CartService();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int cartid = (int)session.getAttribute("cartid") ;
		
		List<CartItemDTO> cartItemDTOs = this.cartService.getCartItem(cartid);
		float totalPrice = 0;
		// đóng kết nối
		this.cartService.relaseConnection();
		for(CartItemDTO cart : cartItemDTOs) {
			totalPrice += cart.getPrice();
		}
		request.setAttribute("totalprice", totalPrice);
		request.setAttribute("cartitems", cartItemDTOs);		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/view/client/cart.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
