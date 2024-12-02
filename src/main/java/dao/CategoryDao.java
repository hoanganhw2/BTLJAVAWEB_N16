package dao;

import java.sql.ResultSet;
import java.util.ArrayList;


public interface CategoryDao {
	
	ArrayList<ResultSet> getCategorys(String multiselect);
	
}
