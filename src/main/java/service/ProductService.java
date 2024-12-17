package service;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;
import org.javatuples.Triplet;

import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import objectDTO.ProductReviewDTO;
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
		public Pair<Product, List<ProductReviewDTO>> getProduct(int id) {
				Product product1 = new Product();
				List<ProductReviewDTO>  productReviewDTOs = new ArrayList<>();
			try {
				ArrayList<ResultSet> arrResultSets = this.product.getProductAndReview(id);
				
				if(!arrResultSets.isEmpty()) {
				if(arrResultSets.get(0).next()) {
				
				product1.setProduct_id(arrResultSets.get(0).getInt("product_id"));
				product1.setProduct_name(arrResultSets.get(0).getString("product_name"));
				product1.setProduct_image(arrResultSets.get(0).getString("product_image"));	
				product1.setProduct_shortdesc(arrResultSets.get(0).getString("product_shortdesc"));	 
				product1.setProduct_description(arrResultSets.get(0).getString("product_description"));	 
				product1.setProduct_price(arrResultSets.get(0).getFloat("product_price"));
				product1.setProduct_discount(arrResultSets.get(0).getFloat("product_discount"));
				product1.setProduct_quantity(arrResultSets.get(0).getInt("product_quantity"));
				product1.setProduct_target(arrResultSets.get(0).getString("product_target"));
				product1.setProduct_category(arrResultSets.get(0).getInt("product_category"));
				product1.setProduct_creatAt(arrResultSets.get(0).getDate("product_creatAt"));	 
				product1.setProduct_updateAt(arrResultSets.get(0).getDate("product_updateAt"));
					 				
				}
				while(arrResultSets.get(1).next()) {
					ProductReviewDTO productReviewDTO = new ProductReviewDTO();
					productReviewDTO.setName(arrResultSets.get(1).getString("user_fullname"));
					productReviewDTO.setContent(arrResultSets.get(1).getString("productreview_content"));
					productReviewDTO.setRating(arrResultSets.get(1).getInt("productreview_ratingscore"));
					productReviewDTO.setDateCreate(arrResultSets.get(1).getDate("productreview_createAt"));
					productReviewDTOs.add(productReviewDTO);
				}
					return new Pair<Product, List<ProductReviewDTO>>(product1, productReviewDTOs);
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			return  new Pair<Product, List<ProductReviewDTO>>(new Product(), new ArrayList<>());
			
		}
		public Pair<List<Product>, Integer> getProducts(int at, int toltal){
			List<Product> products = new ArrayList<>();
			int totalProduct =0 ;
			try {
				products = new ArrayList<>();
				ArrayList<ResultSet> rs= this.product.Products("",at,  toltal);
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
				
				ResultSet countRS = rs.get(1);
		        if(countRS.next()) {
		            totalProduct = countRS.getInt("total");
		        }
		        
		        return new Pair<>(products,totalProduct);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new Pair<List<Product>, Integer>(new ArrayList<>(), 0);
			}
			
			
			
		}
		public List<Category> getAllCegory(){
			List<Category> categories = new ArrayList<>();
			ArrayList<ResultSet> arr = product.getProducts("SELECT * FROM tblcategory");
			if(!arr.isEmpty()) {
				ResultSet rs = arr.get(0);
				try {
					while(rs.next()) {
						Category category = new Category();
						category.setCategory_id(rs.getInt("category_id"));
						category.setCategory_name(rs.getString("category_name"));
						category.setCategory_image(rs.getString("category_image"));
						categories.add(category);
					}
					return categories;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			return null;
		}
		public void relaseConnection() {
			this.product.releaseConnection();
		}
		public static void main(String[] args) {
			ProductService pr = new ProductService();
			Pair<Product, List<ProductReviewDTO>> pair =pr.getProduct(1);
			System.out.println(pair);
			pr.relaseConnection();
			
		}
	
		public boolean addProductReview(ProductReview item) {
			return product.addProductReview(item);
		}
}
