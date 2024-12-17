package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import basic.ShareControl;
import objects.Cart;

public interface CartDao extends ShareControl {
	boolean addCart(Cart cart);
	boolean editCart(Cart cart);
	boolean delCart(Cart cart);
	ResultSet getCart(int user_id);
	int addProductToCart(int user_id,int product_id, int quantity);
	ArrayList<ResultSet> getCartItem(String multiselect);
	ArrayList<ResultSet> getCartItem(String multiselect, int at, int total);
	boolean delCartItem(int cartid, int cartitem);
	boolean updateCartitem(int cart_id, int product_id, int quantity);
}
