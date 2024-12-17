package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;

import JDBCUtils.ConnectionPoolImpl;
import basic.BasicImpl;
import dao.OrderDao;
import objects.Cart;
import objects.CartItem;
import objects.Order;
import service.CartService;

public class OrderDaoImpl extends BasicImpl implements OrderDao {

	public OrderDaoImpl(String objectname) {
		super(objectname);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int add(Order order) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tblorder (order_userid,order_price,order_satuts,order_delivery,order_fullname,order_phone,order_address,order_creatAt)");
		sql.append("VALUES (?,?,?,?,?,?,?,now())");
		try {
			if(con==null) {
				con= ConnectionPoolImpl.getInstance().getConnection("");
			}
			PreparedStatement pre = con.prepareStatement(sql.toString());
			pre.setInt(1, order.getOrder_userid());
			pre.setFloat(2, order.getOrder_price());
			pre.setInt(3, order.getOrder_satuts());
			pre.setInt(4, order.getOrder_delivery());
			pre.setString(5,order.getOrder_fullname());
			pre.setString(6,order.getOrder_phone());
			pre.setString(7,order.getOrder_address());
			if(add(pre)) {
				String query = "SELECT order_id FROM tblorder WHERE order_userid = "+order.getOrder_userid();
				PreparedStatement pre1 = con.prepareStatement(query);
				ResultSet rs = pre1.executeQuery();
				if(rs.next()) {
					return  rs.getInt("order_id");
				}
				return -1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}

	@Override
	public boolean edit(Order order) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tblorder SET order_satuts= ?,order_updateAt = now() WHERE order_id = ? ");
		try {
			if(con==null) {
				con=ConnectionPoolImpl.getInstance().getConnection("");
			}
			PreparedStatement pre = con.prepareStatement(sql.toString());
			pre.setInt(1, order.getOrder_satuts());
			
			pre.setInt(2, order.getOrder_id());
			return this.edit(pre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean del(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet getOrder(int Orderid) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tblorder WHERE order_id = ? ");
		
		return this.get(sql.toString(), Orderid);
	}

	@Override
	public ArrayList<ResultSet> getOrder(String multiselect) {
		try {
			if(con==null) {
				con=ConnectionPoolImpl.getInstance().getConnection("");
			}
			if(con.getAutoCommit()) {
				con.setAutoCommit(false);
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		if (multiselect != null && !multiselect.trim().equals("")) {
			
			return gets(multiselect);
		} else {
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append("SELECT * FROM tblorderitem");
			return gets(sqlBuilder.toString());
		}
	}

	@Override
	public ArrayList<ResultSet> getOrder(String multiselect, int at, int total) {
		if(con==null) {
			try {
				con = ConnectionPoolImpl.getInstance().getConnection("");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(multiselect!=null && !multiselect.trim().equals("")) {
			return this.gets(multiselect);
		}else {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tblorder ");
		sql.append(" ");
		sql.append("ORDER BY order_id DESC ");
		sql.append("LIMIT ").append(at).append(",").append(total).append(";");

		// Dem so luong nguoi su dung
		sql.append("SELECT COUNT(order_id) AS total FROM tblorder;");

		return this.gets(sql.toString());
		}
		
	}
	

	public boolean delAllCartitem(int carid ) {
		String sql ="DELETE FROM tblcartitem WHERE cartitem_cartid = "+ carid;
		try {
			PreparedStatement pre =con.prepareStatement(sql);
			return this.del(pre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false ;
	}

	@Override
	public boolean add(int orderid,List<CartItem> cartitems) {
		int cartid =0;
		try {
			if(con==null) {
				con=ConnectionPoolImpl.getInstance().getConnection("");

			}
			
			for(CartItem cartItem : cartitems) {
				cartid=cartItem.getCartitem_cartid();
				StringBuilder sql = new StringBuilder();
				sql.append("INSERT INTO tblorderitem (orderitem_orderid,orderitem_productid,orderitem_price,orderitem_quantity,orderitem_creatAt)");
				sql.append(" VALUES (?,?,?,?,now())");
				PreparedStatement pre = con.prepareStatement(sql.toString());
				pre.setInt(1, orderid);
				pre.setInt(2 ,cartItem.getCartitem_productid());
				pre.setFloat(3, cartItem.getCartitem_price());
				pre.setInt(4, cartItem.getCartitem_quantity());
				this.add(pre);
			}
			if(delAllCartitem(cartid)) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public static void main(String[] args) {
		
		
		OrderDao orderDao = new OrderDaoImpl("");
		Order order = new Order();
		order.setOrder_id(8);
		order.setOrder_satuts(4);
		orderDao.edit(order);
		orderDao.releaseConnection();
	}
	
}
