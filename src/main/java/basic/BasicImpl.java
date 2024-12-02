package basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import JDBCUtils.ConnectionPool;
import JDBCUtils.ConnectionPoolImpl;

public class BasicImpl implements Basic {
	protected String objectname;
	// chia se ket noi
	private  ConnectionPool cp = ConnectionPoolImpl.getInstance();
	// su dung kêt noi
	protected Connection con;

	public BasicImpl(String objectname) {
		this.objectname = objectname;

		try {
			con = cp.getConnection(this.objectname);
			if (con.getAutoCommit()) {
				con.setAutoCommit(false);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean exe(PreparedStatement pre) {
		try {
			if (pre != null) {
				int result = pre.executeUpdate();
				if (result == 0) {
					this.con.rollback();
					return false;
				}
				this.con.commit();
				
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				this.con.rollback();
				return false;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try {
				if(pre !=null) {
					pre.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			releaseConnection(con, "hoang anh ");
		}
		return false;
	}

	@Override
	public boolean add(PreparedStatement pre) {
		// TODO Auto-generated method stub
		return this.exe(pre);
	}

	@Override
	public boolean edit(PreparedStatement pre) {
		// TODO Auto-generated method stub
		return this.exe(pre);
	}

	@Override
	public boolean del(PreparedStatement pre) {
		// TODO Auto-generated method stub
		return this.exe(pre);
	}

	@Override
	public ResultSet get(String sql, int value) {
		// TODO Auto-generated method stub
		
		try {
			PreparedStatement pre = con.prepareStatement(sql);
			if (value > 0) {
				pre.setInt(1, value);
			}
			return pre.executeQuery();
		} catch (SQLException e) {
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			releaseConnection(con, "hoang anh rs");
		}

		return null;
	}

	@Override
	public ResultSet get(String sql, String username, String userpass) {
		try {
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, username);
			pre.setString(2, userpass);
			return pre.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			releaseConnection(con, "hanh rs2");
		}
		return null;
	}

	@Override
	public ArrayList<ResultSet> gets(String multiselect) {
		ArrayList<ResultSet> rs = new ArrayList<ResultSet>();

		try {
			PreparedStatement pre = con.prepareStatement(multiselect);
			boolean result = pre.execute();
			do {
				if (result) {
					rs.add(pre.getResultSet());
				}
				result = pre.getMoreResults(PreparedStatement.KEEP_CURRENT_RESULT);
			} while (result);
			return rs;
		} catch (SQLException e) {
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			releaseConnection(con, "hanh rs3");
		}
		return null;
	}

	@Override
	public void releaseConnection(Connection con, String objectname) {
		try {
			this.cp.releaseConnection(con, objectname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
