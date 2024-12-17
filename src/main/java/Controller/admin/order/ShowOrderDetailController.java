package Controller.admin.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javatuples.Pair;

import objectDTO.OrderItemDTO;
import objects.Order;
import service.OrderService;

/**
 * Servlet implementation class ShowOrderDetailController
 */
@WebServlet("/admin/order/view")
public class ShowOrderDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      OrderService orderService ; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowOrderDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	orderService = new OrderService();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")!=null) {
			int orderid = 0;
			try {
				orderid = Integer.parseInt(request.getParameter("id"));
			} catch (NumberFormatException e) {
				request.getSession(false).setAttribute("msg", "Có lỗi xảy ra");
				response.sendRedirect(request.getContextPath()+"/");
				e.printStackTrace();
			}
		Pair<List<OrderItemDTO>,Order> pair = orderService.getOrderItem(orderid);
		this.orderService.releaseConnection();
		List<OrderItemDTO> orderitems = pair.getValue0();
		float price =0 ;
		for(OrderItemDTO x : orderitems) {
			price+= x.getPrice();
		}
		Order order = pair.getValue1();
		request.setAttribute("total", price);
		float delivery = order.getOrder_delivery() == 1 ? 25000 : 50000;
		request.setAttribute("delivery", delivery);
		request.setAttribute("orderitems", orderitems);
		request.setAttribute("order", order);		
		RequestDispatcher dispatcher  = request.getRequestDispatcher("/WEB-INF/view/admin/order/view.jsp");
		dispatcher.forward(request, response);
	}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
