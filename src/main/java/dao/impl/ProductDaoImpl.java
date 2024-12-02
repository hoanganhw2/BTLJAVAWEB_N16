package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import basic.BasicImpl;
import dao.ProductDao;

public class ProductDaoImpl extends BasicImpl implements ProductDao {

	public ProductDaoImpl(String objectname) {
		super(objectname);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addProduct(objects.Product item) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tblproduct (`product_name`, `product_image`, `product_shortdesc`, `product_description`, `product_price`, `product_discount`, `product_quantity`, `product_target`, `product_category`, `product_creatAt`, `product_updateAt`)");
			sql.append("VALUES (?, ?, ?, ?, ?,?, ?, ?, ?, now(), now())");
			sql.append("");
			sql.append("");
			sql.append("");
			sql.append("");
			sql.append("");
			sql.append("");
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
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
	public boolean editProduct(objects.Product item) {
		StringBuilder sql = new StringBuilder();
		sql.append("");
		sql.append("");
		sql.append("");
		sql.append("");
		sql.append("");
		sql.append("");
		sql.append("");
		sql.append("");
		return false;
	}

	@Override
	public boolean delProduct(objects.Product item) {
		StringBuilder sql = new StringBuilder();
		sql.append("");
		sql.append("");
		sql.append("");
		sql.append("");
		sql.append("");
		sql.append("");
		sql.append("");
		sql.append("");
		return false;
	}

	@Override
	public ResultSet getProduct(int id) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM tblproduct ");
			sql.append("WHERE product_id = ?");
			sql.append("");
			sql.append("");
			sql.append("");
			sql.append("");
			sql.append("");
			sql.append("");
			PreparedStatement pre  =  this.con.prepareStatement(sql.toString());
			return this.get(sql.toString(), id);
		} catch (SQLException e) {
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<ResultSet> getProducts(String multiselect) {
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
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tblproduct ");
		sql.append(" ");
		sql.append("ORDER BY product_id DESC ");
		sql.append("LIMIT ").append(at).append(",").append(total).append(";");

		// Dem so luong nguoi su dung
		sql.append("SELECT COUNT(product_id) AS total FROM tblproduct;");

		return this.gets(sql.toString());

	}

}
