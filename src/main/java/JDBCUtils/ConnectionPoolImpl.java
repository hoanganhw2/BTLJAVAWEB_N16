package JDBCUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Stack;

public class ConnectionPoolImpl implements ConnectionPool {
	private String driver;
	private String user;
	private String password;
	private String url;
	private Stack<Connection> pool;
	private static ConnectionPool cp=null;

	public ConnectionPoolImpl() {
		this.driver = "com.mysql.cj.jdbc.Driver";
		this.user = "hoanganh_data";
		this.password = "@12#$%65";
		this.url = "jdbc:mysql://localhost:3306/phoneshop_data?allowMultiQueries=true";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.pool = new Stack<Connection>();
	}

	public  static ConnectionPool getInstance() {
		if (cp == null) {
			synchronized(ConnectionPoolImpl.class){
				if(cp==null) {
					cp= new ConnectionPoolImpl();
				}
			}
		}
		return cp;
	}

	@Override
	public  Connection getConnection(String objectname) throws SQLException {
		
		if (pool.isEmpty()) {
	        System.out.println(objectname + " đã tạo kết nối mới");
	        
	        return DriverManager.getConnection(url, user, password);
	    }
	   return pool.pop();
	}

	
	@Override
	public  void  releaseConnection(Connection con, String objectname) throws SQLException {
		  	System.out.println(objectname+" trả kết nối về pool");
		  	
		  	if(con!=null) {
		  		this.pool.push(con); 
		  		System.out.println("Tổng số kết nối có: " + pool.size());
		  		pool.forEach(x -> {
		  			System.out.println(x);
		  		});
		  	}
		    

	}
	public static void main(String[] args) {
		try {
			
		Connection con =	ConnectionPoolImpl.getInstance().getConnection("Hoang anh");
		
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
