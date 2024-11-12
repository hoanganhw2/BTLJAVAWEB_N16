package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {
	private Connection connection ;
	private String url="jdbc:mysql://localhost:3306/demoweb";
	private String user="root";
	private String pasword="root";
	private String Driver="com.mysql.cj.jdbc.Driver";
	public Connection getConnection() {
		
		try {
			Class.forName(Driver);
			connection=DriverManager.getConnection(url,user,pasword);
			System.out.println("Kết nối thành công");
			return connection;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return connection;
	}
	public static void main(String[] args) {
		new JDBCUtils().getConnection();
	}
}
