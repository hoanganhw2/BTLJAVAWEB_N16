package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import JDBCUtils.ConnectionPoolImpl;

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
		
		PreparedStatement pre;
		try {
			if(con==null) {
				con = ConnectionPoolImpl.getInstance().getConnection("");
			}
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE tblproduct SET ");
			sql.append("`product_name` = ? , `product_image` = ? , `product_shortdesc = ?`, `product_description`= ? ,");
			sql.append("`product_price`= ?, `product_discount`= ?, `product_quantity`=?,");
			sql.append("`product_target`= ?, `product_category`= ?, `product_updateAt`= now()");
			sql.append(" ");
			sql.append("WHERE product_id =  ?");
			sql.append("");
			sql.append("");
			sql.append("");
			sql.append("");
			sql.append("");
			pre = this.con.prepareStatement(sql.toString());
			pre.setString(1,item.getProduct_name());
			pre.setString(2,item.getProduct_image());
			pre.setString(3, item.getProduct_shortdesc());
			pre.setString(4, item.getProduct_description());
			pre.setFloat(5,item.getProduct_price());
			pre.setFloat(6, item.getProduct_discount());
			pre.setInt(7, item.getProduct_quantity());
			pre.setString(8, item.getProduct_target());
			pre.setInt(9, item.getProduct_category());
			pre.setInt(10, item.getProduct_id());
			return this.edit(pre);
		} catch (SQLException e) {
		
			
			e.printStackTrace();
		}
		return  false ;
	}

	@Override
	public boolean delProduct(objects.Product item) {
		try {
			if(con==null) {
				con = ConnectionPoolImpl.getInstance().getConnection("");
			}
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM tblproduct WHERE product_id = ?");
			sql.append("");
			sql.append("");
			sql.append("");
			sql.append("");
			sql.append("");
			sql.append("");
			sql.append("");
			PreparedStatement pre = con.prepareStatement(sql.toString());
			pre.setInt(1, item.getProduct_id());
			return this.del(pre);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
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
	
}
