package Controller.client;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.javatuples.Triplet;

import objects.Cart;
import objects.CartItem;
import objects.Order;
import objects.User;
import service.CartService;
import service.OrderService;

/**
 * Servlet implementation class OrderController
 */
@WebServlet("/order")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private OrderService orderService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/client/order.jsp");
		dispatcher.forward(request, response);
	}
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		orderService = new OrderService();
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Đã vào method post");
		int cartid = Integer.parseInt(request.getParameter("cartid"));
		float toltalprice = Float.parseFloat(request.getParameter("total"));
		int delivery = Integer.parseInt(request.getParameter("delivery-method"));
		if(delivery==1) {
			toltalprice = toltalprice +25000;
		}else
		{
			toltalprice = toltalprice+50000;
		}
		Order order = new Order();
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		Triplet<User, String, Cart> triplet = (Triplet<User, String, Cart>) session.getAttribute("user");
		User user = triplet.getValue0();
		order.setOrder_userid(user.getUser_id());
		order.setOrder_price(toltalprice);
		order.setOrder_satuts(1);
		order.setOrder_delivery(delivery);
		order.setOrder_fullname(user.getUser_fullname());
		order.setOrder_phone(user.getUser_phone());
		order.setOrder_address(user.getUser_address());
		int orderid = orderService.addOrder(order);
		this.orderService.releaseConnection();
		CartService cartService = new CartService();
		System.out.println(cartid);
		List<CartItem> cartItems = cartService.getAllCartitemByCartid(cartid);
		System.out.println(cartItems);
	cartService.relaseConnection();
	if(orderid>-1) {
			if(orderService.CartitemToOrderItem(orderid, cartItems)) {
				this.orderService.releaseConnection();
			cartService.setSumCart(user.getUser_id());
				cartService.relaseConnection();
				session.setAttribute("cart_sum", 0);
				session.setAttribute("msg", "Đặt hàng thành công");
				response.sendRedirect(request.getContextPath()+"/");
			}
			
			
		}
		
	}

}
