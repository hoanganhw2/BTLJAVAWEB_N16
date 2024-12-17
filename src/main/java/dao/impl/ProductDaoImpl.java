package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import JDBCUtils.ConnectionPoolImpl;

import java.sql.PreparedStatement;
import basic.BasicImpl;
import dao.ProductDao;
import objects.Product;
import objects.ProductReview;

public class ProductDaoImpl extends BasicImpl implements ProductDao {

	public ProductDaoImpl(String objectname) {
		super(objectname);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addProduct(objects.Product item) {
		try {
			if(con==null) {
				con = ConnectionPoolImpl.getInstance().getConnection("");
			}
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tblproduct (`product_name`, `product_image`, `product_shortdesc`, `product_description`, `product_price`, `product_discount`, `product_quantity`, `product_target`, `product_category`, `product_creatAt`, `product_updateAt`)");
			sql.append("VALUES (?, ?, ?, ?, ?,?, ?, ?, ?, now(), now())");
			sql.append("");
			sql.append("");
			sql.append("");
			sql.append("");
			sql.append("");
			sql.append("");
			PreparedStatement pre = con.prepareStatement(sql.toString());
			pre.setString(1,item.getProduct_name());
			pre.setString(2,item.getProduct_image());
			pre.setString(3, item.getProduct_shortdesc());
			pre.setString(4, item.getProduct_description());
			pre.setFloat(5,item.getProduct_price());
			pre.setFloat(6, item.getProduct_discount());
			pre.setInt(7, item.getProduct_quantity());
			pre.setString(8, item.getProduct_target());
			pre.setInt(9, item.getProduct_category());
			return this.add(pre);
			
		} catch (SQLException e) {
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editProduct(Product item) {
	    PreparedStatement pre = null;
	    try {
	        if(con == null) {
	            con = ConnectionPoolImpl.getInstance().getConnection("");
	        }
	        
	        // Sử dụng StringBuilder hiệu quả hơn
	        StringBuilder sql = new StringBuilder()
	            .append("UPDATE tblproduct SET ")
	            .append("product_name = ?, ")
	            .append("product_image = ?, ")
	            .append("product_shortdesc = ?, ")
	            .append("product_description = ?, ")
	            .append("product_price = ?, ")
	            .append("product_discount = ?, ")
	            .append("product_quantity = ?, ")
	            .append("product_target = ?, ")
	            .append("product_category = ?, ")
	            .append("product_updateAt = now() ")
	            .append("WHERE product_id = ?");

	        pre = this.con.prepareStatement(sql.toString());
	        
	       
	        pre.setString(1, item.getProduct_name());
	        pre.setString(2, item.getProduct_image());
	        pre.setString(3, item.getProduct_shortdesc());
	        pre.setString(4, item.getProduct_description());
	        pre.setFloat(5, item.getProduct_price());
	        pre.setFloat(6, item.getProduct_discount());
	        pre.setInt(7, item.getProduct_quantity());
	        pre.setString(8, item.getProduct_target());
	        pre.setInt(9, item.getProduct_category());
	        pre.setInt(10, item.getProduct_id());

	        return this.edit(pre);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    } finally {
	        // Đóng PreparedStatement
	        try {
	            if(pre != null) {
	                pre.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	@Override
	public boolean addProductReview(ProductReview item) {
		try {
			if(con==null) {
				con = ConnectionPoolImpl.getInstance().getConnection("");
			}
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tblproductreview (productreview_userid, productreview_productid, productreview_status, productreview_content, productreview_ratingscore, productreview_createAt)");
			sql.append("VALUES (?, ?, ?, ?, ?, now())");
			sql.append("");
			PreparedStatement pre = con.prepareStatement(sql.toString());
			pre.setInt(1,item.productreview_userid );
			pre.setInt(2, item.productreview_productid);
			pre.setInt(3, item.getProductreview_status());
			pre.setString(4, item.productreview_content);
			pre.setInt(5, item.getProductreview_ratingscore());
			return this.add(pre);
			}
			catch (SQLException e) {
		        e.printStackTrace();
		        return false;
		    }
	}
	
	@Override
	public ResultSet getProduct(int id) {
		if(con==null) {
			try {
				con = ConnectionPoolImpl.getInstance().getConnection("");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tblproduct ");
		sql.append("WHERE product_id = ?");
		sql.append("");
		sql.append("");
		sql.append("");
		sql.append("");
		sql.append("");
		sql.append("");			
		return this.get(sql.toString(), id);
	
	}

	@Override
	public ArrayList<ResultSet> getProducts(String multiselect) {
		if(con==null) {
			try {
				con = ConnectionPoolImpl.getInstance().getConnection("");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (multiselect != null && !multiselect.trim().equals("")) {
			return gets(multiselect);
		} else {
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append("SELECT * FROM tblproduct");
			return gets(sqlBuilder.toString());
		}
	}
	
	@Override
	public ArrayList<ResultSet> Products(String multiselect, int at, int total) {
		if(con==null) {
			try {
				con = ConnectionPoolImpl.getInstance().getConnection("");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tblproduct ");
		sql.append(" ");
		sql.append("ORDER BY product_id DESC ");
		sql.append("LIMIT ").append(at).append(",").append(total).append(";");

		// Dem so luong nguoi su dung
		sql.append("SELECT COUNT(product_id) AS total FROM tblproduct;");

		return this.gets(sql.toString());

	}

	@Override
	public boolean delProduct(Product item) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args) {
		
	
		ProductDao pr = new ProductDaoImpl("");
		ArrayList<ResultSet> rs = pr.getProductAndReview(1);
		System.out.println(rs.size());
		pr.releaseConnection();
	}

	@Override
	public ArrayList<ResultSet> getProductAndReview(int id) {	
		if(con==null) {
			try {
				con = ConnectionPoolImpl.getInstance().getConnection("");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tblproduct ")
		   .append("WHERE product_id = ").append(id)
		   .append(";");
		sql.append("SELECT user_fullname, productreview_content, ")  
		   .append("productreview_ratingscore, productreview_createAt ")
		   .append("FROM tblproductreview ")
		   .append("INNER JOIN tbluser ON tbluser.user_id = tblproductreview.productreview_userid ")
		   .append("WHERE productreview_productid = ").append(id) 
		   .append(";");
		return this.gets(sql.toString());
	}
}
