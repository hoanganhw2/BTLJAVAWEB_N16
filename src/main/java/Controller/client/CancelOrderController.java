package Controller.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.OrderService;

/**
 * Servlet implementation class CancelOrderController
 */
@WebServlet("/order/cancel")
public class CancelOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderService orderService ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	orderService = new OrderService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action")!=null) {
				
				int orderid = Integer.parseInt(request.getParameter("action"));		
				this.orderService.CancelOrder(orderid, 4);
				request.getSession(false).setAttribute("msg", "Hủy đơn hàng thành ông");
				this.orderService.releaseConnection();
				response.sendRedirect(request.getContextPath()+"/order/list");
			
		}
	}

}
