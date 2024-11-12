package database;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionPool {
	Connection getConnection(String objectName) throws SQLException;
	void relaseConnection(Connection con,String objectName);
}
