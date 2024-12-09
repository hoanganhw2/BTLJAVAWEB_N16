package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;

import basic.BasicImpl;
import basic.ShareControl;
import dao.CategoryDao;
import dao.UserDao;
import dao.impl.CategoryDaoImpl;
import dao.impl.UserDaoImpl;
import objects.Category;
import objects.Product;
import objects.User;


public class UserService {
	UserDao user;
	public UserService() {
		 
		 user = new UserDaoImpl("user");
	}
	
	public Pair<List<Category>,List<Product>> getProductAndCategory(){
		List<Category> categorys = new ArrayList<>();
		List<Product> products = new ArrayList<>();
		Pair<List<Category>,List<Product>> pair = new Pair<List<Category>, List<Product>>(categorys, products);
		ArrayList<ResultSet> rs = user.getUsers("SELECT * FROM tblcategory; SELECT * FROM tblproduct;");
		try {
			if(!rs.isEmpty()) {
					while(rs.get(0).next()) {
						Category category = new Category();
						category.setCategory_name(rs.get(0).getString("category_name"));
						category.setCategory_image(rs.get(0).getString("category_image"));
						categorys.add(category);
					}
					while(rs.get(1).next()) {
						Product product = new Product();
						product.setProduct_id(rs.get(1).getInt("product_id"));
						product.setProduct_name(rs.get(1).getString("product_name"));
						product.setProduct_image(rs.get(1).getString("product_image"));
						product.setProduct_price(rs.get(1).getFloat("product_price"));
						product.setProduct_discount(rs.get(1).getFloat("product_discount"));
						product.setProduct_shortdesc(rs.get(1).getString("product_shortdesc"));
						product.setProduct_description(rs.get(1).getString("product_description"));
						product.setProduct_quantity(rs.get(1).getInt("product_quantity"));
						product.setProduct_target(rs.get(1).getString("product_target"));
						product.setProduct_category(rs.get(1).getInt("product_category"));
						products.add(product);					
					}
					pair.setAt0(categorys);
					pair.setAt1(products);
					
				return pair;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("không lấy dc dữ liệu");
		return  null;
		
	}
	
	public Pair<User, String> getUser(String name, String pass) {
		 User user = null;
		 String role_name ="";
		 ResultSet rs = this.user.getUser(name, pass);
		 try {
			if(rs.next()) {
				 user=new User();
				 user.setUser_id(rs.getInt("user_id"));
				 user.setUser_name(rs.getString("user_name"));
				 user.setUser_pass(rs.getString("user_pass"));
				 user.setUser_image(rs.getString("user_image"));
				 user.setUser_fullname(rs.getString("user_fullname"));
				 user.setUser_gender(rs.getInt("user_gender"));
				 user.setUser_phone(rs.getString("user_phone"));
				 user.setUser_address(rs.getString("user_address"));
				 user.setUser_role(rs.getInt("user_role"));
				 user.setUser_createAt(rs.getDate("user_createAt"));
				 user.setUser_updateAt(rs.getDate("user_updateAt"));
				 role_name=rs.getString("role_name");
			 }
			return new Pair<User, String>(user, role_name);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	public boolean add(User item) {
		if(user.isUser(item.getUser_name())) {
			return false ;
		}
		return user.addUser(item);
		
	}
	public static void main(String[] args) {
		UserService userService = new UserService();
		System.out.println(userService.getProductAndCategory().toString());
	}
	
	
	public void relaseConnection() {
		this.user.releaseConnection();
	}
	
	
	
	
			
	
}
