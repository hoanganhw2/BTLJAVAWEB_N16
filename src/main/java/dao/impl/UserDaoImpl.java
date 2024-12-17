package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import JDBCUtils.ConnectionPoolImpl;
import basic.BasicImpl;
import dao.UserDao;
import objects.*;

public class UserDaoImpl extends BasicImpl implements UserDao {

	public UserDaoImpl(String objectname) {
		super(objectname);
		// TODO Auto-generated constructor stub
	
	}
	
	@Override
	public boolean addUser(User item) {
		try {
			
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tbluser (user_name, user_pass, user_fullname, user_gender, user_image, user_email, user_phone, user_address, user_role, user_createAt) ");
			sql.append("VALUES (?, md5(?), ?, ?, ?, ?, ?, ?, ?, now())");
			PreparedStatement pre = con.prepareStatement(sql.toString());
			pre.setString(1, item.getUser_name());
			pre.setString(2, item.getUser_pass());
			pre.setString(3, item.getUser_fullname());
			pre.setInt(4, item.getUser_gender());
			pre.setString(5, item.getUser_image());
			pre.setString(6, item.getUser_email());
			pre.setString(7, item.getUser_phone());
			pre.setString(8, item.getUser_address());
			pre.setInt(9, item.getUser_role());

			return this.exe(pre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editUser(User item) {

		try {
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE tbluser ").append("SET ");
			sql.append(
					"user_name = ? , user_pass = ?,user_fullname = ?,user_gender = ?,user_image = ? ,user_email =?,user_phone = ?,user_address = ?,user_role = ?");
			sql.append(" WHERE user_id = ? ");
			PreparedStatement pre = con.prepareStatement(sql.toString());
			pre.setString(1, item.getUser_name());
			pre.setString(2, item.getUser_pass());
			pre.setString(3, item.getUser_fullname());
			pre.setInt(4, item.getUser_gender());
			pre.setString(5, item.getUser_image());
			pre.setString(6, item.getUser_email());
			pre.setString(7, item.getUser_phone());
			pre.setString(8, item.getUser_address());
			pre.setInt(9, item.getUser_role());
			pre.setInt(1, item.getUser_id());
			return this.exe(pre);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean delUser(User item) {
		try {
			String sqlString = "DELETE tbluser WHERE user_id = ? ";
			PreparedStatement pre = con.prepareStatement(sqlString);
			pre.setInt(1, item.getUser_id());
			return this.exe(pre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean isUser(String name) {
		boolean flag = false ;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tbluser WHERE user_name = ?");
		sql.append("");
		ResultSet rs = get(sql.toString(), name);
		try {
			if(rs.next()) {
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return flag;
	}
	public boolean isCart(int user_id) {
		boolean flag = false ;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tblcart WHERE user_id = ?");
		sql.append("");
		ResultSet rs = get(sql.toString(), user_id);
		try {
			if(rs.next()) {
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return flag;
	}
	@Override
	public ResultSet getUser(int id) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT user_name,user_pass,user_fullname,user_email,user_phone,user_address");
		sql.append(" WHERE user_id = ? ");
		return get(sql.toString(), id);
	}

	@Override
	public ResultSet getUser(String username, String userpass) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u.user_id, u.user_name, u.user_pass, u.user_image, u.user_fullname, ")
		   .append("u.user_gender, u.user_email, u.user_phone, u.user_address, u.user_role, ")
		   .append("u.user_createAt, u.user_updateAt, r.role_name, ")
		   .append("c.cart_id, c.cart_userid, c.cart_sum, c.cart_creatAt, c.cart_updateAt ")
		   .append("FROM tbluser u ")
		   .append("LEFT JOIN tblrole r ON u.user_role = r.role_id ")
		   .append("LEFT JOIN tblcart c ON u.user_id = c.cart_userid ")
		   .append("WHERE u.user_name = ? ")
		   .append("AND u.user_pass = md5(?) ");
		return get(sql.toString(), username, userpass);
	}

	@Override
	public ArrayList<ResultSet> getUsers(String multiselect) {
		try {
			if(con==null) {
				con=ConnectionPoolImpl.getInstance().getConnection("");
			}
			if(con.getAutoCommit()) {
				con.setAutoCommit(false);
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		if (multiselect != null && !multiselect.trim().equals("")) {
			
			return gets(multiselect);
		} else {
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append("SELECT * FROM tbluser");
			return gets(sqlBuilder.toString());
		}
	}
	

	@Override
	public ArrayList<ResultSet> getUsers(String multiselect, int at, int total) {
		try {
			if(con==null) {
				con=ConnectionPoolImpl.getInstance().getConnection("");
			}
			if(con.getAutoCommit()) {
				con.setAutoCommit(false);
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		StringBuilder sql = new StringBuilder();
		if(multiselect.trim().equals("")) {
		
		sql.append("SELECT * FROM tbluser ");
		sql.append(" ");
		sql.append("ORDER BY user_id DESC ");
		sql.append("LIMIT ").append(at).append(",").append(total).append(";");

		// Dem so luong nguoi su dung
		sql.append("SELECT COUNT(user_id) AS total FROM tbluser;");
		}else {
			return this.gets(multiselect);
		}
			
		return this.gets(sql.toString());
		

	}
	
	
	
	
}
