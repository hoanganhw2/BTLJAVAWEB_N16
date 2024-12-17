package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import JDBCUtils.ConnectionPoolImpl;
import basic.BasicImpl;
import dao.CartDao;
import objects.Cart;

public class CartDaoImpl extends BasicImpl implements CartDao {

	public CartDaoImpl(String objectname) {
		super(objectname);
		
	}
	boolean isCart(int user_id) {
		boolean flag  = false ;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tblcart WHERE cart_userid = ?");
		sql.append(" ;");
		ResultSet rs = this.get(sql.toString(),user_id);
		try {
			if(rs.next()) {
				
				flag= true;
			}
		} catch (SQLException e) {
			System.out.println("Có lỗi xảy ra!");
			e.printStackTrace();
		}	
		
		return flag;
	}
	@Override
	public boolean addCart(Cart cart) {
		 StringBuilder sql = new StringBuilder();
		    
		    sql.append("INSERT INTO tblcart ")
		       .append("(cart_userid, cart_sum, cart_creatAt) ")
		       .append("VALUES (?, ?, now())");
		    try {
				PreparedStatement pre =con.prepareStatement(sql.toString());
				pre.setInt(1, cart.getCart_userid());
				pre.setInt(2, cart.getCart_sum());
				return this.add(pre);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public boolean editCart(Cart cart) {
		StringBuilder sql = new StringBuilder();
	    
	    sql.append("UPDATE tblcart SET ")
	       .append("cart_sum = ? WHERE cart_userid = ?");
	    
	    try {
	    	if(con==null) {
	    		con=ConnectionPoolImpl.getInstance().getConnection("");
	    	}
			PreparedStatement pre =con.prepareStatement(sql.toString());			
			if(cart==null)
			{
				System.out.println("cart bị null ở đây");
				return false;
			}else {
				pre.setInt(1, cart.getCart_sum());
				pre.setInt(2, cart.getCart_userid());
				return this.edit(pre);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return false;
	}

	@Override
	public boolean delCart(Cart cart) {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM tblcart WHERE cart_userid = ").append(cart.getCart_userid());
		try {
			PreparedStatement pre = con.prepareStatement(sql.toString());
			return this.del(pre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return  false;
	}

	@Override
	public ResultSet getCart(int user_id) {
		StringBuilder sql  = new StringBuilder();
		sql.append("SELECT * FROM tblcart WHERE cart_userid =  ? ");
		
			return this.get(sql.toString(), user_id);
		
	}

	@Override
	public ArrayList<ResultSet> getCartItem(String multiselect) {
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
			sqlBuilder.append("SELECT * FROM tblcartitem");
			return gets(sqlBuilder.toString());
		}	}

	@Override
	public ArrayList<ResultSet> getCartItem(String multiselect, int at, int total) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int addProductToCart(int user_id, int product_id, int quantity) {
		if(!isCart(user_id)) {
			Cart cart = new Cart();
			cart.setCart_userid(user_id);
			cart.setCart_sum(0);
			cart.setCart_updateAt(new Date());
			addCart(cart);
		}
		int cart_id = getCartByUserId(user_id);
		float price = getPriceByProductId(product_id);
		if(isProductInCart(cart_id, product_id)) {
			// nếu sản phẩm tồn tại trong cart thì tăng thêm số lượng ở cartitem
			int oldquantity = getQuantityInCartitem(cart_id, product_id);
			updateCartItem(cart_id, product_id,price, quantity+oldquantity);
			return 0;
		}else {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tblcartitem (cartitem_cartid,cartitem_productid,cartitem_price,cartitem_quantity,cartitem_creatAt) ");
		sql.append("VALUES (?,?,?,?,now())");
		sql.append(" ;");
		try {
			PreparedStatement pre=con.prepareStatement(sql.toString());
			pre.setInt(1, cart_id);
			pre.setInt(2, product_id);
			pre.setFloat(3, price*quantity);
			pre.setInt(4, quantity);
			
			if(add(pre)) {
				return 1;
			}
			return -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		}
		
		
	}

	// kiểm tra xem sản phẩm có trong giỏ không
	boolean isProductInCart(int cartid, int productid) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tblcartitem " +
                "WHERE cartitem_cartid = ").append(cartid).append(" ").append(" AND cartitem_productid = ").append(productid);
                
		try {
			ArrayList<ResultSet> rs = this.gets(sql.toString());
			if(rs!=null) {
				if(rs.get(0).next()) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//lấy thông tin giỏ hàng qua user_id
	public int getCartByUserId(int user_id)
	{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT cart_id FROM tblcart WHERE cart_userid = ").append(user_id);
		
		try {
			ArrayList<ResultSet> resultSets = this.gets(sql.toString());
			if(resultSets!=null) {
				if(resultSets.get(0).next())
				{	
					return resultSets.get(0).getInt("cart_id");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
			
		}
	
		return -1;
	}
	// lấy giá sản phẩm thông qua product id
	public float getPriceByProductId(int product_id) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT product_discount FROM tblproduct WHERE product_id = ?");
		try {
		
			ResultSet rs = this.get(sql.toString(), product_id);
			if(rs.next())
			{
				return rs.getFloat("product_discount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
		
	}
	boolean updateCartItem(int cart_id, int product_id,float price, int quantity)
	{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tblcartitem SET cartitem_price = ? , cartitem_quantity= ?");
		sql.append(" ");
		sql.append("WHERE cartitem_cartid = ? AND cartitem_productid  = ? ;");
		try {
			PreparedStatement pre = con.prepareStatement(sql.toString());
			pre.setFloat(1, price*quantity);
			pre.setInt(2, quantity);
			pre.setInt(3, cart_id);
			pre.setInt(4, product_id);
			return this.edit(pre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return false;
			
		}
	}
	int getQuantityInCartitem(int cartid,int productid) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT cartitem_quantity FROM tblcartitem WHERE cartitem_cartid = ").append(cartid) ;
		sql.append(" AND cartitem_productid = ").append(productid).append(" ;");
		
		try {
			ArrayList<ResultSet> rs = this.gets(sql.toString());
			
			if(rs!=null)
			{
				if(rs.get(0).next()) {
					return rs.get(0).getInt("cartitem_quantity");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}
	public static void main(String[] args) {
		CartDaoImpl cartDao = new CartDaoImpl("Hoàng em ");
		ResultSet rs = cartDao.getCart(3);
		try {Cart cart = new Cart();
			if(rs.next()) {
				
				cart.setCart_id(rs.getInt("cart_id"));
				cart.setCart_userid(rs.getInt("cart_userid"));
				cart.setCart_sum(rs.getInt("cart_sum"));
				cart.setCart_creatAt(rs.getDate("cart_creatAt"));
			}
			System.out.println(cart);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cartDao.releaseConnection();
		
	}
	@Override
	public boolean delCartItem(int cartid, int productid) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM tblcartitem WHERE cartitem_cartid = ").append(cartid);
		sql.append(" AND cartitem_productid = ").append(productid);
		try {
			if(con==null) {
				con = ConnectionPoolImpl.getInstance().getConnection("");
			}
			PreparedStatement pre = con.prepareStatement(sql.toString());
			return this.del(pre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return  false;
	}
	@Override
	public boolean updateCartitem(int cart_id, int product_id, int quantity) {
		float price = getPriceByProductId(product_id);
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tblcartitem SET cartitem_price = ? , cartitem_quantity= ?");
		sql.append(" ");
		sql.append("WHERE cartitem_cartid = ? AND cartitem_productid  = ? ;");
		try {
			if(con==null) {
				con = ConnectionPoolImpl.getInstance().getConnection("");
			}
			PreparedStatement pre = con.prepareStatement(sql.toString());
			pre.setFloat(1, price*quantity);
			pre.setInt(2, quantity);
			pre.setInt(3, cart_id);
			pre.setInt(4, product_id);
			return this.edit(pre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return false;
			
		}
	}
}
