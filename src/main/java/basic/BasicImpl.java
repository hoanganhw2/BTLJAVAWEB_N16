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
			
			if (con.getAutoCommit()) {
				
				con.setAutoCommit(false);
			}
			if (pre != null) {
				int result = pre.executeUpdate();
				if (result == 0) {
					this.con.rollback();
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
		}
		
		return null;
	}

	@Override
	public ResultSet get(String sql, String username, String userpass) {
		PreparedStatement pre =null;
		
		try {
			pre= con.prepareStatement(sql);
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
			try {
				pre.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
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
		}
		return null;
	}

	@Override
	public void releaseConnection() {
		try {
	        if(con != null) {
	        	this.cp.releaseConnection(con, objectname);
	        	if(!con.getAutoCommit()) {
	        		con.setAutoCommit(true);
	        	}
	        	con=null;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public ResultSet get(String sql, String name) {
				PreparedStatement pre =null;	
		try {
			pre= con.prepareStatement(sql);
			pre.setString(1, name);
		
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
			try {
				pre.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		return null;
	}

}
