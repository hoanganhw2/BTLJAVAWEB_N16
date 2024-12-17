package Controller.admin.product;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import ValidateUtils.ProductValidate;
import objects.Category;
import objects.Product;
import service.ProductService;
import service.UploadFileService;

/**
 * Servlet implementation class UpdateProductController
 */
@WebServlet("/admin/product/update")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
maxFileSize=1024*1024*50,      	// 50 MB
maxRequestSize=1024*1024*100)   //100 MB
public class UpdateProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private  ProductService productService;
    private  UploadFileService uploadFileService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		productService= new ProductService();
		uploadFileService = new UploadFileService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id").toString();
		String url="";
		if(id!=null) {
			try {
				int product_id = Integer.parseInt(id);
				List<Category> categorys = this.productService.getAllCegory();
				
				request.setAttribute("categoris", categorys);
				Product product=this.productService.getProduct(product_id).getValue0();
				this.productService.relaseConnection();
				request.setAttribute("product", product);
				url="/WEB-INF/view/admin/product/update.jsp";
			} catch (NumberFormatException e) {
				// TODO: handle exception
			}
			
			
		}	
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		int countError = 0;
		String id = request.getParameter("id"); 
	 String product_name = request.getParameter("product_name"); 		
	 String product_shortdesc=request.getParameter("product_shortdesc"); 
	 String product_description=request.getParameter("product_description"); 
	 String product_price=request.getParameter("product_price")+""; 
	 String product_discount=request.getParameter("product_discount");  
	 String product_quantity=request.getParameter("product_quantity"); 
	 Part product_image=request.getPart("file");  
	 String product_target=request.getParameter("product_target"); 
	 String product_category=request.getParameter("product_category"); 
	 Map<String, String> errors = new HashMap<String, String>();
	 if(!ProductValidate.getProductValidate().validateProductName(product_name)) {
		 errors.put("errorName", "Tên phải từ 6 ký tự");	
		 countError ++ ;
	 }
	 if(!ProductValidate.getProductValidate().validatePrice(product_price)) {
		 errors.put("errorPrice","Giá phải lớn hơn 0");
		 countError ++ ;
	 }
	 if(!ProductValidate.getProductValidate().validatePrice(product_discount)) {
		 errors.put("errorDiscount", "Giá phải lớn hơn 0");		
		 countError ++ ;
	 }
	 if(!ProductValidate.getProductValidate().valideQuantity(product_quantity)) {
		 errors.put("errorQuantity","Số lượng phải lớn hơn hoặc bằng 0");
		 countError ++ ;
	 }
	 if(countError !=0) {
		 request.setAttribute("errors", errors);
		doGet(request, response);
	 }else {
		 float price = Float.parseFloat(product_price);
		 float price_discount = Float.parseFloat(product_discount);
		 int quantity = Integer.parseInt(product_quantity);
		 int category = Integer.parseInt(product_category);
		 int product_id = Integer.parseInt(id);
		 Product product = new Product();
		 String image_name = "";
		 if(product_image != null && product_image.getSize() > 0) {
			    image_name = uploadFileService.uploadFile(product_image,"product");
			    product.setProduct_image(image_name);
			} else {
			    image_name = request.getParameter("product_image").toString();
			}
		 
		 
		 product.setProduct_name(product_name);
		 product.setProduct_shortdesc(product_shortdesc);
		 product.setProduct_description(product_description);
		 product.setProduct_discount(price_discount);
		 product.setProduct_price(price);
		 product.setProduct_quantity(quantity);
		 product.setProduct_image(image_name);
		 product.setProduct_target(product_target);
		 product.setProduct_category(category);
		 product.setProduct_id(product_id);
		 System.out.println(product.toString());
		 if(this.productService.update(product)==false)
		 {
			 String msg = "Sửa thất bại";
			
			 System.out.println(msg);
			 this.productService.relaseConnection();
			 doGet(request, response);
		 }
		 else {
			 String update= "Sửa thành công";
			 HttpSession session = request.getSession();
			 session.setAttribute("update", update);
			 response.sendRedirect(request.getContextPath()+"/admin/product");
			 this.productService.relaseConnection();
		 }
		  
	 }
	
	

	}

}
