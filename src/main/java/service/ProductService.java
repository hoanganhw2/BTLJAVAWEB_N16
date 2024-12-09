package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import objects.*;
public class ProductService {
	private ProductDao product;

	public ProductService() {
		product = new ProductDaoImpl("Admin");
	}
	// thêm
	public boolean add(Product item) {
		return this.product.addProduct(item);
	}
	//sửa
	public boolean update(Product item) {
		return this.product.editProduct(item);
	}
	public boolean delete(Product item) {
		return this.product.delProduct(item);
	}
	public Product getProduct(int id) {
		
		try {
			Product product1 = new Product();
			ResultSet rs = product.getProduct(id);
			while(rs.next()) {
			product1.setProduct_id(rs.getInt("product_id"));
			product1.setProduct_name(rs.getString("product_name"));
			product1.setProduct_image(rs.getString("product_image"));	
			product1.setProduct_shortdesc(rs.getString("product_shortdesc"));	 
			product1.setProduct_description(rs.getString("product_description"));	 
			product1.setProduct_price(rs.getFloat("product_price"));
			product1.setProduct_discount(rs.getFloat("product_discount"));
			product1.setProduct_quantity(rs.getInt("product_quantity"));
			product1.setProduct_target(rs.getString("product_target"));
			product1.setProduct_category(rs.getInt("product_category"));
			product1.setProduct_creatAt(rs.getDate("product_creatAt"));	 
			product1.setProduct_updateAt(rs.getDate("product_updateAt"));
				 				
			}
			
			return product1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return null;
		
	}
	public List<Product> getAll(){
		List<Product> products;
		try {
			products = new ArrayList<>();
			ArrayList<ResultSet> rs= this.product.getProducts("");
			ResultSet resultSet =rs.get(0);
			while(resultSet.next()) {
				Product product1 = new Product();
				product1.setProduct_id(resultSet.getInt("product_id"));
				product1.setProduct_name(resultSet.getString("product_name"));
				product1.setProduct_image(resultSet.getString("product_image"));	
				product1.setProduct_shortdesc(resultSet.getString("product_shortdesc"));	 
				product1.setProduct_description(resultSet.getString("product_description"));	 
				product1.setProduct_price(resultSet.getFloat("product_price"));
				product1.setProduct_discount(resultSet.getFloat("product_discount"));
				product1.setProduct_quantity(resultSet.getInt("product_quantity"));
				product1.setProduct_target(resultSet.getString("product_target"));
				product1.setProduct_category(resultSet.getInt("product_category"));
				product1.setProduct_creatAt(resultSet.getDate("product_creatAt"));	 
				product1.setProduct_updateAt(resultSet.getDate("product_updateAt"));
				products.add(product1);
			}
			
			return products;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	public void relaseConnection() {
		this.product.releaseConnection();
	}
	public static void main(String[] args) {
		ProductService productService = new ProductService();
		List<Product> products = productService.getAll();
		for(Product pr : products) {
			System.out.println(pr);
		}
	}
}
