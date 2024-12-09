package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import basic.ShareControl;


public interface CategoryDao  extends ShareControl{
	ArrayList<ResultSet> getCategorys(String multiselect);
	
	
}
