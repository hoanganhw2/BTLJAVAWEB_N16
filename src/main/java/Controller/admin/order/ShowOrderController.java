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

import objects.Order;
import objects.Product;
import service.OrderService;

/**
 * Servlet implementation class ShowOrderController
 */
@WebServlet("/admin/order")
public class ShowOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private OrderService orderService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowOrderController() {
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
		int page = 1;
        int recordsPerPage = 4;
        
        if(request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }        
        int start = (page - 1) * recordsPerPage;    
        Pair<List<Order>, Integer> result = orderService.getAllOrders(start, recordsPerPage);
        this.orderService.releaseConnection();
        List<Order> orders = result.getValue0();
        int totalOrder = result.getValue1();
        int totalPages = (int) Math.ceil(totalOrder * 1.0 / recordsPerPage);
        
        request.setAttribute("orders", orders);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/admin/order/show.jsp");	
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
