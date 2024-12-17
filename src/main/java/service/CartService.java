package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CartDao;
import dao.impl.CartDaoImpl;
import objectDTO.*;
import objects.Cart;
import objects.CartItem;

public class CartService {
	private CartDao cartDao;

	public CartService() {
		cartDao = new CartDaoImpl("user");
	}
	public List<CartItemDTO> getCartItem(int cartid){
		List<CartItemDTO> cartItemDTOs = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT  product_id,product_name,product_image,cartitem_id,cartitem_cartid,cartitem_price,cartitem_quantity from tblcartitem inner join tblproduct on tblproduct.product_id = tblcartitem.cartitem_productid WHERE cartitem_cartid = ").append(cartid);
		ArrayList<ResultSet> resultSets = cartDao.getCartItem(sql.toString());
		try {
			if(resultSets!=null) {
				while(resultSets.get(0).next()) {
					CartItemDTO cartitem = new CartItemDTO();
					cartitem.setProduct_id(resultSets.get(0).getInt("product_id"));
					cartitem.setId(resultSets.get(0).getInt("cartitem_id"));
					cartitem.setCart_id(resultSets.get(0).getInt("cartitem_cartid"));
					cartitem.setName(resultSets.get(0).getString("product_name"));
					cartitem.setImage(resultSets.get(0).getString("product_image"));
					cartitem.setPrice(resultSets.get(0).getFloat("cartitem_price"));
					cartitem.setQuantity(resultSets.get(0).getInt("cartitem_quantity"));
					cartItemDTOs.add(cartitem);
				}
				return cartItemDTOs;
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
		return null;
	}
	public int addProductInCart(int userid, int productid, int quatity) {
	int kq = cartDao.addProductToCart(userid, productid, quatity);
		if(kq==1) {
			Cart cart = getCart(userid);
			System.out.println("đã vào đây : ");
			System.out.println(cart);
			int sum = cart.getCart_sum();
			System.out.println(sum);
			cart.setCart_sum(sum+1);
			System.out.println(cart);
			return cartDao.editCart(cart)==true ? 1 : -1;
	}else if(kq==0)
		{
			return 0;
		}
		return -1;	
	}
	public boolean updateCartitem(int cartid, int productid, int quantity) {
		return this.cartDao.updateCartitem(cartid, productid, quantity);
	}
	public void relaseConnection()
	{
		this.cartDao.releaseConnection();
	}
	public boolean delCartitem(int cartid,int productid,int user_id) {
		if(cartDao.delCartItem(cartid, productid)) {
			Cart cart = getCart(user_id);
			int sum = cart.getCart_sum();
			cart.setCart_sum(sum-1);
			return cartDao.editCart(cart);
		}
		return false;
	}
	public Cart getCart(int cartid) {
		Cart cart = null;
		ResultSet rs = cartDao.getCart(cartid);
		try {
			if(rs!=null) {
				if(rs.next()) {
					cart = new Cart();
					cart.setCart_id(rs.getInt("cart_id"));
					cart.setCart_userid(rs.getInt("cart_userid"));
					cart.setCart_sum(rs.getInt("cart_sum"));
					cart.setCart_creatAt(rs.getDate("cart_creatAt"));
				}
				return cart;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cart;
	}
	public static void main(String[] args) {
		CartService cartService = new CartService();
		List<CartItem> cartItems = cartService.getAllCartitemByCartid(3);
		cartItems.forEach(x ->  System.out.println(x));
		cartService.relaseConnection();
	}
	public List<CartItem> getAllCartitemByCartid(int cartid){
		List<CartItem> cartItems = new ArrayList<>();
		String sql = "SELECT * FROM tblcartitem WHERE cartitem_cartid ="+cartid;
		ArrayList<ResultSet> arrayList = this.cartDao.getCartItem(sql);
		try {
			if(arrayList!=null) {
				ResultSet rs = arrayList.get(0);
				while(rs.next()) {
					CartItem cartItem = new CartItem();
					cartItem.setCartitem_id(rs.getInt("cartitem_id"));
					cartItem.setCartitem_cartid(rs.getInt("cartitem_cartid"));
					cartItem.setCartitem_productid(rs.getInt("cartitem_productid"));
					cartItem.setCartitem_price(rs.getFloat("cartitem_price"));
					cartItem.setCartitem_quantity(rs.getInt("cartitem_quantity"));
					cartItem.setCartitem_creatAt(rs.getDate("cartitem_creatAt"));
					cartItems.add(cartItem);
				}
				return cartItems;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public boolean setSumCart(int userid) {
		Cart cart = new Cart();
		cart.setCart_sum(0);
		cart.setCart_userid(userid);
		return this.cartDao.editCart(cart);
	}
}
