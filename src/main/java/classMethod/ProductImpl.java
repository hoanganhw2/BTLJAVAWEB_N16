package classMethod;

import java.sql.*;
import java.util.*;

import basic.Basicimpl;
import object.ProductObject;


public class ProductImpl extends Basicimpl implements Product {
	public ProductImpl() {
		super("Product");
	}
	@Override
	public boolean addProduct(ProductObject item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editProduct(ProductObject item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delProduct(ProductObject item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<ResultSet> getProducts(String multiSelect) {
		// TODO Auto-generated method stub
		
		if(multiSelect != null && !"".equals(multiSelect)) {
			return this.gets(multiSelect);
		}else {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM tbluser ");
			sql.append(" ");
			sql.append("ORDER BY user_id DESC ");
			sql.append("LIMIT 10;");
			
			return this.gets(sql.toString());
		}
	}

	@Override
	public ResultSet getProduct(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tbluser WHERE user_id=?";
		return this.get(sql, id);
	}

	@Override
	public ResultSet getProduct(String name, String pass) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tbluser WHERE (user_name=?) AND (user_pass=?)";
		return this.get(sql, name, pass);
	}
	
	@Override
	public ArrayList<ResultSet> getProducts(String multiSelect, int at, byte total) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tbluser ");
		sql.append(" ");
		sql.append("ORDER BY user_id DESC ");
		sql.append("LIMIT ").append(at).append(",").append(total).append(";");
		
		//Dem so luong nguoi su dung
		sql.append("SELECT COUNT(user_id) AS total FROM tbluser;");
		
		return this.gets(sql.toString());
	}
	
	public static void main(String[] args) {
		Product u = new ProductImpl();
		
		//Danh sach tap ket qua
		ArrayList<ResultSet> res = u.getProducts(null, 0, (byte)15);
		ResultSet rs = res.get(0); //Danh sach nguoi su dung
			String row = "";
			try {
				while(rs.next()) {
					row = "ID: " + rs.getInt("user_id");
					row += "\tName: " + rs.getString("user_name");
					row += "\tFullName: " + rs.getString("user_fullname");
					row += "\tPass: " + rs.getString("user_pass");
					System.out.println(row);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs = res.get(1);
			if(rs!=null) {
				try {
					if(rs.next()) {
						System.out.println("------- Tong so nguoi su dung " + rs.getInt("total"));
					}
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}


}
