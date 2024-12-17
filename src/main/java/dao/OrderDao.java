package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import basic.ShareControl;
import objects.CartItem;
import objects.Order;
import objects.User;

public interface OrderDao  extends ShareControl{
		int add(Order order);
		boolean edit(Order order);
		boolean del(Order order);	
		boolean add(int orderid,List<CartItem> cartitems);
		ResultSet getOrder(int Orderid);
		ArrayList<ResultSet> getOrder(String multiselect);
		ArrayList<ResultSet> getOrder(String multiselect, int at, int total);
		
	
		
		
		
}
