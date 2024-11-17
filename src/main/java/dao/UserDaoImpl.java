package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import basic.BasicImpl;
import objects.User;

public class UserDaoImpl extends BasicImpl implements UserDao {

	public UserDaoImpl(String objectname) {
		super(objectname);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addUser(User item) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(
					"INSERT INTO user_name,user_pass,user_fullname,user_gender,user_image,user_email,user_phone,user_address,user_role");
			sql.append("VLUES ").append("(?,md5(?),?,?,?,?,?,?)");
			PreparedStatement pre = con.prepareStatement(sql.toString());
			pre.setString(1, item.getUser_name());
			pre.setString(2, item.getUser_pass());
			pre.setString(3, item.getUser_fullname());
			pre.setByte(4, item.getUser_gender());
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
			sql.append("WHERE user_id = ? ");
			PreparedStatement pre = con.prepareStatement(sql.toString());
			pre.setString(1, item.getUser_name());
			pre.setString(2, item.getUser_pass());
			pre.setString(3, item.getUser_fullname());
			pre.setByte(4, item.getUser_gender());
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

	@Override
	public ResultSet getUser(int id) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT user_name,user_pass,user_fullname,user_email,user_phone,user_address");
		sql.append("WHERE user_id = ? ");
		return get(sql.toString(), id);
	}

	@Override
	public ResultSet getUser(String username, String userpass) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT user_name,user_pass");
		sql.append("WHERE user_id = ?");
		return get(sql.toString(), username, userpass);
	}

	@Override
	public ArrayList<ResultSet> getUsers(String multiselect) {
		if (multiselect != null && !multiselect.trim().equals("")) {
			return gets(multiselect);
		} else {
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append("SELECT * FROM tbluser");
			return gets(sqlBuilder.toString());
		}
	}

	public static void main(String[] args) throws SQLException {
		UserDao userDao = new UserDaoImpl("User");
		ArrayList<ResultSet> rs = userDao.getUsers("");
		ResultSet resultSet = rs.get(0);
		while (resultSet.next()) {
			System.out.println("User_name : " + resultSet.getString("user_name"));
			System.out.println("User_pass: " + resultSet.getString("user_pass"));
			System.out.println("User_fullname : " + resultSet.getString("user_fullname"));
			System.out.println("User_address : " + resultSet.getString("user_address"));
		}

	}

	@Override
	public ArrayList<ResultSet> getUsers(String multiselect, int at, int total) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tbluser ");
		sql.append(" ");
		sql.append("ORDER BY user_id DESC ");
		sql.append("LIMIT ").append(at).append(",").append(total).append(";");

		// Dem so luong nguoi su dung
		sql.append("SELECT COUNT(user_id) AS total FROM tbluser;");

		return this.gets(sql.toString());

	}
}
