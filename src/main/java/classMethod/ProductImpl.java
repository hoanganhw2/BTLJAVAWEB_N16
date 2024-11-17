
package classMethod;

import java.sql.*;
import java.util.*;

import basic.BasicImpl;
import object.ProductObject;


public class ProductImpl extends BasicImpl implements Product {
	public ProductImpl() {
		super("Product");
	}
	@Override
	public boolean addProduct(ProductObject item) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(
					"INSERT INTO product_name,product_image,product_shortdesc,product_description,product_price,product_discount,product_quantity, product_target,product_category,product_createAt, product_updateAt");
			sql.append("VALUES ").append("(?,md5(?),?,?,?,?,?,?,?,?,?)");
			PreparedStatement pre = con.prepareStatement(sql.toString());
			pre.setString(1, item.getProduct_name());
			pre.setString(2, item.getProduct_image());
			pre.setString(3, item.getProduct_shortdesc());
			pre.setString(4, item.getProduct_description());
			pre.setString(5, item.getProduct_price());
			pre.setString(6, item.getProduct_discount());
			pre.setString(7, item.getProduct_quantity());
			pre.setString(8, item.getProduct_target());
			pre.setString(9, item.getProduct_category());
			pre.setString(10, item.getProduct_createAt());
			pre.setString(11, item.getProduct_updateAt());

			return this.exe(pre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editProduct(ProductObject item) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE tblproduct ").append("SET ");
			sql.append(
					"product_name = ? , product_image = ?,product_shortdesc = ?,product_description = ?,product_price = ? ,product_discount =?,product_quantity = ?,product_target = ?,product_category = ?,product_createAt = ?, product_updateAt = ?");
			sql.append("WHERE product_id = ? ");
			PreparedStatement pre = con.prepareStatement(sql.toString());
			pre.setString(1, item.getProduct_name());
			pre.setString(2, item.getProduct_image());
			pre.setString(3, item.getProduct_shortdesc());
			pre.setString(4, item.getProduct_description());
			pre.setString(5, item.getProduct_price());
			pre.setString(6, item.getProduct_discount());
			pre.setString(7, item.getProduct_quantity());
			pre.setString(8, item.getProduct_target());
			pre.setString(9, item.getProduct_category());
			pre.setString(10, item.getProduct_createAt());
			pre.setString(11, item.getProduct_updateAt());
			return this.exe(pre);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean delProduct(ProductObject item) {
		try {
			String sqlString = "DELETE tblproduct WHERE product_id = ? ";
			PreparedStatement pre = con.prepareStatement(sqlString);
			pre.setInt(1, item.getProduct_id());
			return this.exe(pre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<ResultSet> getProducts(String multiSelect) {
		// TODO Auto-generated method stub
		
		if(multiSelect != null && !"".equals(multiSelect)) {
			return this.gets(multiSelect);
		}else {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM tblproduct ");
			sql.append(" ");
			sql.append("ORDER BY user_id DESC ");
			
			return this.gets(sql.toString());
		}
	}

	@Override
	public ResultSet getProduct(int id) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * from tblproduct where product_id = ? ");
		return get(sql.toString(), id);
	}

	@Override
	public ResultSet getProduct(String name, int id) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT product_name,product_price form tblproduct ");
		sql.append("WHERE product_id = ?");
		return get(sql.toString(), name, String.valueOf(id));
	}
	
	@Override
	public ArrayList<ResultSet> getProducts(String multiSelect, int at, byte total) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tblproduct ");
		sql.append(" ");
		sql.append("ORDER BY product_id DESC ");
		sql.append("LIMIT ").append(at).append(",").append(total).append(";");
		
		//Dem so luong nguoi su dung
		sql.append("SELECT COUNT(user_id) AS total FROM tbluser;");
		
		return this.gets(sql.toString());
	}
	
	
			
	public static void main(String[] args) {
		Product pr = new ProductImpl();
		try {
			ResultSet rs = pr.getProduct(1);
			System.out.println(rs);
			while(rs.next()) {
					System.out.println("name : " +rs.getString("product_name"));
					System.out.println("Giá :" +rs.getString("product_price"));
					System.out.println("image : " +rs.getString("product_image"));
					System.out.println("shortdesc :" +rs.getString("product_shortdesc"));
					System.out.println("shortprice :" +rs.getString("product_price"));
					System.out.println("discount :" +rs.getString("product_discount"));
					System.out.println("quantity :" +rs.getString("product_quantity"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
