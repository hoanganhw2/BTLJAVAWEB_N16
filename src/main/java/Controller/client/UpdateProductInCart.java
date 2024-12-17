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
 * Servlet implementation class UpdateProductInCart
 */
@WebServlet("/cart/update")
public class UpdateProductInCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
      CartService carService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductInCart() {
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action = request.getParameter("action");
	        System.out.println(action);
	        String[] arr = action.split("_");
	        //1 cartitemid , 2 product id
	        String hanhdong = arr[0];
	       if(hanhdong.equals("update"))
	       {	
	    	   int cartitemid =Integer.parseInt(arr[1]);	    	  
	    	   int productid= Integer.parseInt(arr[2]);
	    	   int cart_id = Integer.parseInt(arr[3]);
	    	   int quantity = Integer.parseInt(request.getParameter("quantity_"+cartitemid));
	    	   System.out.println("số lượng lấy được:"+quantity);
	    	  if(this.carService.updateCartitem(cart_id, productid, quantity)) {
	    		  this.carService.relaseConnection();
	    		  System.out.println("Cập nhật thành công số lượng "+quantity);
	    		  request.getSession(false).setAttribute("msg", "Cập nhật thành công");
	    		  response.sendRedirect(request.getContextPath()+"/cart");
    	  }
	    	   
	    	  
	       }else if(hanhdong.equals("delete")) {
	    	   int cartitemid =Integer.parseInt(arr[1]);	    	  
	    	   int productid= Integer.parseInt(arr[2]);
	    	   int cartid = Integer.parseInt(arr[3]);
	    	   int user_id =(int)request.getSession(false).getAttribute("id");
	    	   if(this.carService.delCartitem(cartid, productid,user_id)) {
	    		   carService.relaseConnection();
	    		   HttpSession session = request.getSession(false);
	    		   session.setAttribute("msg", "Xóa thành công");
	    		   int sum = Integer.parseInt(session.getAttribute("cart_sum").toString());
	    		   session.setAttribute("cart_sum", sum-1);
	    		   response.sendRedirect(request.getContextPath()+"/cart");
	    	   }
	       }
	       
	}

}
