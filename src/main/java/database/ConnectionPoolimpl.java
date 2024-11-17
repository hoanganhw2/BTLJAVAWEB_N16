package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Stack;

import JDBCUtils.ConnectionPool;


public class ConnectionPoolimpl implements ConnectionPool {
	String driver ;
	String username;
	String password;
	String url;
	
	private Stack<Connection> pool;
	
	private static ConnectionPool cp=null;
	private ConnectionPoolimpl() {
		// xac dinh trinh dieu khien
		this.driver ="com.mysql.cj.jdbc.Driver";
		this.username="root";
		this.password="123456";
		this.url="jdbc:mysql://localhost:3306/shop_online";
		
		// nap trinh dieu khien
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// khoi tao bo nho luu tru ket noi
		
		this.pool= new Stack<Connection>();
		
		
	}
	@Override
	public Connection getConnection(String objectName)throws SQLException {
		// TODO Auto-generated method stub
		if(this.pool.isEmpty()) {
			// khoi tao ket noi moi
			
			System.out.println(objectName+"Dã tạo một kết nối mới");
			return DriverManager.getConnection(this.url,this.username,this.password);
			
				
			}else {
				// lấy kết nối đucọ lưu trữ
				System.out.println(objectName+"da lấy ra kết mới");
				return pool.pop();
			}

	}
	@Override
	public void releaseConnection(Connection con, String objectName) throws SQLException {
		// TODO Auto-generated method stub
		// Thu hồi lại kết nối
		System.out.println(objectName + "have pushed the Connection");
		this.pool.push(con);
	}
	public static ConnectionPool getInstance() {
		
		if(cp==null) {
			synchronized(ConnectionPoolimpl.class) {
				if(cp==null) {
					cp = new ConnectionPoolimpl();
				}
			}
		}
		
		return cp;
	}
//	@Override
//	public void releaseConnection(Connection con, String objectname) throws SQLException {
//		// TODO Auto-generated method stub
//		
//	}
	
	
	
	
			




}
