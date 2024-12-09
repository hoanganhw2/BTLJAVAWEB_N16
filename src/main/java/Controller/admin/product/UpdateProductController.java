package Controller.admin.product;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import ValidateUtils.ProductValidate;
import objects.Category;
import objects.Product;
import service.ProductService;
import service.UploadFileService;
import service.UserService;

@WebServlet("/admin/product/update")
public class UpdateProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private UserService userService;
	    private UploadFileService uploadFileService;
	    private ProductService productService;
	    private final String folder = "product";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	this.userService= new UserService();
    	this.uploadFileService = new UploadFileService();
    	this.productService= new ProductService();
    	super.init();
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
				List<Category> categorys = this.userService.getProductAndCategory().getValue0();
				this.userService.relaseConnection();
				request.setAttribute("categorys", categorys);
				Product product=this.productService.getProduct(product_id);
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
		 String image_name = uploadFileService.uploadFile(product_image,folder);
		 Product product = new Product();
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
		 if(this.productService.update(product)==false)
		 {
			 String msg = "Sửa thất bại";
			 request.setAttribute("msg", msg);
			 doGet(request, response);
		 }
		 String msg ="Thêm thành công";
		 doGet(request, response);
		  
	 }
	
	}

}
