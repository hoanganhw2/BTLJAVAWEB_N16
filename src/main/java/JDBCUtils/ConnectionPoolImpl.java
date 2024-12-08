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
	private static ConnectionPool cp;
	
	public ConnectionPoolImpl() {
		this.driver = "com.mysql.cj.jdbc.Driver";
		this.user = "root";
		this.password = "123456";
		this.url = "jdbc:mysql://localhost:3306/shop_online?allowMultiQueries=true";
		// nạp trình điều khiển
		try {
			Class.forName(driver);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		this.pool = new Stack<Connection>();
	}

	@Override
	public Connection getConnection(String objectname) throws SQLException {
		if (pool.isEmpty()) {
			System.out.println(objectname + "Đã mở 1 kết nối");
			return DriverManager.getConnection(url, user, password);
		}
		return pool.pop();
	}

	@Override
	public void releaseConnection(Connection con, String objectname) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println(objectname + "Đã đóng kết nối");
		pool.push(con);
	}
	
	public static ConnectionPool getInstance() {
		if (cp == null) {
			cp = new ConnectionPoolImpl();
		}
		return cp;
	}
	

}
