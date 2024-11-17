package basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public interface Basic {
	boolean add(PreparedStatement pre);

	boolean edit(PreparedStatement pre);

	boolean del(PreparedStatement pre);

	ResultSet get(String sql, int value);

	ResultSet get(String sql, String username, String userpass);

	ArrayList<ResultSet> gets(String multiselect);

	void releaseConnection(Connection con, String objectname);

}
