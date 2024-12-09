package JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionPool {
	Connection getConnection(String objectname) throws SQLException; // 

	void releaseConnection(Connection con, String objectname) throws SQLException;
}
