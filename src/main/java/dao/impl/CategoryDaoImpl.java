package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import JDBCUtils.ConnectionPoolImpl;
import basic.BasicImpl;
import dao.CategoryDao;
import objects.Category;

public class CategoryDaoImpl extends BasicImpl implements CategoryDao {


	public CategoryDaoImpl(String objectname) {
		super(objectname);
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public ArrayList<ResultSet> getCategorys(String multiselect) {
		if(con==null) {
			try {
				con = ConnectionPoolImpl.getInstance().getConnection("");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(multiselect!=null && !multiselect.trim().equals("")){
			return this.gets(multiselect);
		}else
		{
			String sql = "SELECT * FROM tblcategory";
			
			return this.gets(sql);
		}
		
	}
	public static void main(String[] args) {
		CategoryDao categoryDao = new CategoryDaoImpl("admin");
		ArrayList<ResultSet> rs = categoryDao.getCategorys("");
		ResultSet kq = rs.get(0);
		
		try {
			while(kq.next()) {
				System.out.println("ID:"+kq.getInt(1)+"\t"+"Tên :"+kq.getString(2)+"\t Image:"+kq.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	
}
