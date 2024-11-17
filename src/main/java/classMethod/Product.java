package classMethod;

import java.sql.ResultSet;
import java.util.ArrayList;

import object.ProductObject;
public interface Product {
	boolean addProduct(ProductObject item);
	boolean editProduct(ProductObject item);
	boolean delProduct(ProductObject item);
	ArrayList<ResultSet> getProducts(String multiSelect, int at, byte total);
	ArrayList<ResultSet> getProducts(String multiSelect);
	ResultSet getProduct(int id);
	ResultSet getProduct(String name, String pass);
}
