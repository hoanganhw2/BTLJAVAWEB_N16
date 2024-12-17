package Controller.admin.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.OrderService;

/**
 * Servlet implementation class UpdateStatusController
 */
@WebServlet("/admin/order/update")
public class UpdateStatusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderService orderService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStatusController() {
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
		if(request.getParameter("orderId")!=null)
		{	int orderid = Integer.parseInt(request.getParameter("orderId"));
			int status = Integer.parseInt(request.getParameter("status"));
			this.orderService.CancelOrder(orderid, status);
			this.orderService.releaseConnection();
			request.getSession().setAttribute("update", "Cập nhật thành công");
			
		}
		response.sendRedirect(request.getContextPath()+"/admin/order");
	}

}
