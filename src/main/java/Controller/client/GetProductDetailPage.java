package Controller.client;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import classMethod.*;
/**
 * Servlet implementation class GetProductDetailPage
 */
@WebServlet("/productDetail")
public class GetProductDetailPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProductDetailPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/productDetail.jsp");
//		System.out.println(dispatcher);
//        dispatcher.forward(request, response);
		Product p = new ProductImpl();
		int productId = 1;
	 // Giả sử ID sản phẩm được truyền qua URL
        ResultSet product = p.getProduct(productId); // Gọi phương thức để lấy thông tin sản phẩm
        System.out.println(product);
        request.setAttribute("product", product); // Đưa sản phẩm vào request

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/client/productDetail.jsp");
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