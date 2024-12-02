package service;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CategoryDao;
import dao.UserDao;
import dao.impl.*;

import objects.Category;

public class UserService {
	CategoryDao category ;
	UserDao user;
	public UserService() {
		category = new CategoryDaoImpl("");
		user = new UserDaoImpl("");
	}
	public List<Category> getAllCategory(){
		List<Category> ds = new ArrayList<>();
		ArrayList<ResultSet> rs = category.getCategorys("");
		ResultSet kq = rs.get(0);
		
		try {
			while(kq.next()) {
				Category category = new Category();
				category.setCategory_id(kq.getInt(1));
				category.setCategory_name(kq.getString(2));
				category.setCategory_image(kq.getString(3));
				ds.add(category);
			}
			
			return ds;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
