package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import objects.*;

public interface ProductDao {
	boolean addProduct(Product item);

	boolean editProduct(Product item);

	boolean delProduct(Product item);

	ResultSet getProduct(int id);
	
	ArrayList<ResultSet> getProducts(String multiselect);

	ArrayList<ResultSet> Products(String multiselect, int at, int total);
}
