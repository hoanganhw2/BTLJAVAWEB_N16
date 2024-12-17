package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import basic.ShareControl;
import objects.*;

public interface ProductDao extends ShareControl {
	boolean addProduct(Product item);

	boolean editProduct(Product item);

	boolean delProduct(Product item);
	boolean addProductReview(ProductReview item);

	ResultSet getProduct(int id);
	ArrayList<ResultSet> getProductAndReview(int id);
	
	ArrayList<ResultSet> getProducts(String multiselect);

	ArrayList<ResultSet> Products(String multiselect, int at, int total);
	
}
