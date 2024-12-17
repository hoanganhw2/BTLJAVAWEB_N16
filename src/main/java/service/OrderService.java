package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;

import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import objectDTO.OrderItemDTO;
import objects.CartItem;
import objects.Order;



public class OrderService {
	public OrderDao orderDao ;
	
	public OrderService() {
		orderDao = new OrderDaoImpl("user-order");
	}
	public int addOrder(Order order) {
		return this.orderDao.add(order);
	}
	public boolean CartitemToOrderItem(int orderid, List<CartItem> cartItems) {
		return this.orderDao.add(orderid,cartItems);
	}
	public Pair<List<Order>, Integer> getAllOrders(int at, int toltal){
		List<Order> orders = new ArrayList<>();
		
	
		int totalOrder =0 ;
		try {
			ArrayList<ResultSet> rs= this.orderDao.getOrder("", at, toltal);
			ResultSet resultSet =rs.get(0);
			while(resultSet.next()) {
				Order order = new Order();
				order.setOrder_id(resultSet.getInt("order_id"));
				order.setOrder_userid(resultSet.getInt("order_userid"));
				order.setOrder_price(resultSet.getFloat("order_price"));
				order.setOrder_satuts(resultSet.getInt("order_satuts"));
				order.setOrder_delivery(resultSet.getInt("order_delivery"));
				order.setOrder_creatAt(resultSet.getDate("order_creatAt"));
				order.setOrder_updateAt(resultSet.getDate("order_updateAt"));
				orders.add(order);
			}
			
			ResultSet countRS = rs.get(1);
	        if(countRS.next()) {
	            totalOrder = countRS.getInt("total");
	        }
	        
	        return new Pair<>(orders,totalOrder);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Pair<List<Order>, Integer>(new ArrayList<>(), 0);
		}
		
	}
	public Pair<List<Order>, Integer> getAllOrders(int userid,int at, int toltal){
		List<Order> orders = new ArrayList<>();
		
	
		int totalOrder =0 ;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM tblorder WHERE order_userid = ").append(userid);
			sql.append(" ORDER BY order_id DESC LIMIT ");
			sql.append(at).append(",").append(toltal).append(";");
			sql.append("SELECT COUNT(order_userid) AS total FROM tblorder").append(" ;");
			
			ArrayList<ResultSet> rs= this.orderDao.getOrder(sql.toString(), at, toltal);
			ResultSet resultSet =rs.get(0);
			while(resultSet.next()) {
				Order order = new Order();
				order.setOrder_id(resultSet.getInt("order_id"));
				order.setOrder_userid(resultSet.getInt("order_userid"));
				order.setOrder_price(resultSet.getFloat("order_price"));
				order.setOrder_satuts(resultSet.getInt("order_satuts"));
				order.setOrder_delivery(resultSet.getInt("order_delivery"));
				order.setOrder_creatAt(resultSet.getDate("order_creatAt"));
				order.setOrder_updateAt(resultSet.getDate("order_updateAt"));
				orders.add(order);
			}
			
			ResultSet countRS = rs.get(1);
	        if(countRS.next()) {
	            totalOrder = countRS.getInt("total");
	        }
	        
	        return new Pair<>(orders,totalOrder);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Pair<List<Order>, Integer>(new ArrayList<>(), 0);
		}
		
	}
	public Pair<List<OrderItemDTO>,Order> getOrderItem(int orderid){
		List<OrderItemDTO> orderItemDTOs = new ArrayList<>();
		Order order = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT  orderitem_id,product_id,product_name,product_image,orderitem_price,orderitem_quantity from tblorderitem inner join tblproduct on tblproduct.product_id = tblorderitem.orderitem_productid WHERE orderitem_orderid = ").append(orderid).append(" ;");
		sql.append("SELECT * FROM tblorder where order_id = ").append(orderid);
		ArrayList<ResultSet> resultSets = orderDao.getOrder(sql.toString());
		try {
			if(resultSets!=null) {
				while(resultSets.get(0).next()) {
					OrderItemDTO orderItemDTO = new OrderItemDTO();
					orderItemDTO.setId(resultSets.get(0).getInt("orderitem_id"));
					orderItemDTO.setProductid(resultSets.get(0).getInt("product_id"));
					orderItemDTO.setProductname(resultSets.get(0).getString("product_name"));
					orderItemDTO.setImage(resultSets.get(0).getString("product_image"));
					orderItemDTO.setPrice(resultSets.get(0).getInt("orderitem_price"));
					orderItemDTO.setQuantity(resultSets.get(0).getInt("orderitem_quantity"));
					orderItemDTOs.add(orderItemDTO);
				}
				while(resultSets.get(1).next()) {
					order = new Order();
					order.setOrder_id(resultSets.get(1).getInt("order_id"));
					order.setOrder_userid(resultSets.get(1).getInt("order_userid"));
					order.setOrder_price(resultSets.get(1).getFloat("order_price"));
					order.setOrder_satuts(resultSets.get(1).getInt("order_satuts"));
					order.setOrder_delivery(resultSets.get(1).getInt("order_delivery"));
					order.setOrder_fullname(resultSets.get(1).getString("order_fullname"));
					order.setOrder_phone(resultSets.get(1).getString("order_phone"));
					order.setOrder_address(resultSets.get(1).getString("order_address"));
					order.setOrder_creatAt(resultSets.get(1).getDate("order_creatAt"));
					order.setOrder_updateAt(resultSets.get(1).getDate("order_updateAt"));
				}
				return new Pair<List<OrderItemDTO>, Order>(orderItemDTOs, order);
			}
		} catch (SQLException e) {
			try {
				resultSets.get(0).close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return new Pair<List<OrderItemDTO>, Order>(new ArrayList<>(), order);
	}
	public boolean CancelOrder(int orderid , int statut) {
		Order order = new Order();
		order.setOrder_id(orderid);
		order.setOrder_satuts(statut);
		return orderDao.edit(order);
	}
	public void releaseConnection() {
		orderDao.releaseConnection();
	}
	public static void main(String[] args) {
		OrderService orderService = new OrderService();
//		Pair<List<Order>, Integer> pair= orderService.getAllOrders(2,0, 4);
//		orderService.releaseConnection();
		Pair<List<Order>,Integer> pair = orderService.getAllOrders(1, 0, 4);
		System.out.println(pair);
	}
}
