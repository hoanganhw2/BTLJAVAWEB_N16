package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.javatuples.Pair;
import org.javatuples.Triplet;

import basic.BasicImpl;
import basic.ShareControl;

import dao.UserDao;

import dao.impl.UserDaoImpl;
import objects.Cart;
import objects.Category;
import objects.Product;
import objects.User;


public class UserService {
	UserDao user;
	public UserService() {
		 
		 user = new UserDaoImpl("user");
	}
	
	public Triplet<List<Category>,List<Product>,Integer> getProductAndCategory(int at, int total){
		List<Category> categories = new ArrayList<>();
	    List<Product> products = new ArrayList<>();
	    int totalProducts = 0;

	    // Tạo câu query
	    StringBuilder sql = new StringBuilder();
	    sql.append("SELECT * FROM tblproduct ORDER BY product_id DESC LIMIT ").append(at).append(",").append(total).append(";");
	    sql.append("SELECT * FROM tblcategory;");
	    sql.append("SELECT COUNT(product_id) AS total FROM tblproduct;");
	    ArrayList<ResultSet> resultSets = user.getUsers(sql.toString());
	    
	    try {
	        
	        
	        if (resultSets != null ) {
	            // Xử lý products - ResultSet thứ nhất
	            ResultSet productRS = resultSets.get(0);
	            while (productRS != null && productRS.next()) {
	                Product product = new Product();
	                product.setProduct_id(productRS.getInt("product_id"));
	                product.setProduct_name(productRS.getString("product_name"));
	                product.setProduct_image(productRS.getString("product_image"));
	                product.setProduct_price(productRS.getFloat("product_price"));
	                product.setProduct_discount(productRS.getFloat("product_discount"));
	                product.setProduct_shortdesc(productRS.getString("product_shortdesc"));
	                product.setProduct_description(productRS.getString("product_description"));
	                product.setProduct_quantity(productRS.getInt("product_quantity"));
	                product.setProduct_target(productRS.getString("product_target"));
	                product.setProduct_category(productRS.getInt("product_category"));
	                products.add(product);
	            }

	            // Xử lý categories - ResultSet thứ hai
	            ResultSet categoryRS = resultSets.get(1);
	            while (categoryRS != null && categoryRS.next()) {
	                Category category = new Category();
	                category.setCategory_name(categoryRS.getString("category_name"));
	                category.setCategory_image(categoryRS.getString("category_image"));
	                categories.add(category);
	            }

	            // Xử lý total - ResultSet thứ ba
	            ResultSet totalRS = resultSets.get(2);
	            if (totalRS != null && totalRS.next()) {
	                totalProducts = totalRS.getInt("total");
	            }
	            

	        } 

	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Lỗi khi xử lý dữ liệu: " + e.getMessage());
	    } finally {
	        // Đóng các ResultSet
	        try {
	            if (resultSets != null) {
	                for (ResultSet rs : resultSets) {
	                    if (rs != null) {
	                        rs.close();
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return new Triplet<>(categories, products, totalProducts);
	}
	
	@SuppressWarnings("null")
	public Triplet<User, String,Cart> getUser(String name, String pass) {
		 User user = null;
		 Cart cart = null;
		 String role_name ="";
		 ResultSet rs = this.user.getUser(name, pass);
		 try {
			if(rs.next()) {
				 user=new User();
				 user.setUser_id(rs.getInt("user_id"));
				 user.setUser_name(rs.getString("user_name"));
				 user.setUser_pass(rs.getString("user_pass"));
				 user.setUser_image(rs.getString("user_image"));
				 user.setUser_email(rs.getString("user_email"));
				 user.setUser_fullname(rs.getString("user_fullname"));
				 user.setUser_gender(rs.getInt("user_gender"));
				 user.setUser_phone(rs.getString("user_phone"));
				 user.setUser_address(rs.getString("user_address"));
				 user.setUser_role(rs.getInt("user_role"));
				 user.setUser_createAt(rs.getDate("user_createAt"));
				 user.setUser_updateAt(rs.getDate("user_updateAt"));
				 role_name=rs.getString("role_name");
				 cart = new Cart();
				 cart.setCart_id(rs.getInt("cart_id"));
				 cart.setCart_userid(rs.getInt("cart_userid"));
				 cart.setCart_sum(rs.getInt("cart_sum"));			
				 cart.setCart_creatAt(rs.getDate("cart_creatAt"));
				 cart.setCart_updateAt(rs.getDate("cart_updateAt"));
				 
			 }
			return  new Triplet<User, String, Cart>(user, role_name, cart);
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
	
	public Pair<List<User>,Integer> getAllUser(int at, int total){
		List<User> users = new ArrayList<>();
		ArrayList<ResultSet> resultSets = user.getUsers("", at, total);
		try {
			if(resultSets != null) {
				ResultSet rs  = resultSets.get(0);
				while(rs.next()) {
					User user = new User();
					user.setUser_id(rs.getInt("user_id"));
					user.setUser_name(rs.getString("user_name"));
					user.setUser_pass(rs.getString("user_pass"));
					user.setUser_fullname(rs.getString("user_fullname"));
					user.setUser_image(rs.getString("user_image"));
					user.setUser_gender(rs.getInt("user_gender"));
					user.setUser_email(rs.getString("user_email"));
					user.setUser_phone(rs.getString("user_phone"));
					user.setUser_address(rs.getString("user_address"));
					user.setUser_role(rs.getInt("user_role"));
					user.setUser_createAt(rs.getDate("user_createAt"));
					user.setUser_updateAt(rs.getDate("user_updateAt"));
					users.add(user);
					
				}
				int toltalUser = 0;
				ResultSet rs1 = resultSets.get(1);
				if(rs1.next()) {
					toltalUser = rs1.getInt("total");
				}
				return new Pair<List<User>, Integer>(users, toltalUser);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Pair<List<User>, Integer>(new ArrayList<>(), 0);
	}
	
	
	public void relaseConnection() {
		this.user.releaseConnection();
	}
	public static void main(String[] args) {
		UserService userService = new UserService();
		Pair<List<User>, Integer> pair  = userService.getAllUser(0, 3);
		System.out.println(pair);
		userService.relaseConnection();
	}
	
	
			
	
}
