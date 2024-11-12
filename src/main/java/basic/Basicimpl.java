package basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.ConnectionPool;
import database.ConnectionPoolimpl;

public class Basicimpl implements Basic {
	// doi tuong lam viec voi Basic
	private String objectName;
	//Bo quan ly ket noi duoc chia se
	private ConnectionPool cp = ConnectionPoolimpl.getInstance();
	
	// ket noi rien cua Basic su dung
	protected Connection con;
	public Basicimpl(String objectname) {
			this.objectName=objectname;
			//xin ket noi 
			try {
				this.con=this.cp.getConnection(this.objectName);
				// kiem tra che do thuc thi cua ket noi
				if(this.con.getAutoCommit()) {
					this.con.setAutoCommit(false);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	private boolean exe(PreparedStatement pre) {
		if(pre!=null) {
			// thực hiện lấy về kết quả
			try {
				int results = pre.executeUpdate();
				if(results==0) {
					this.con.rollback();
					return false ;
				}
				// xac dinh thực thi sau cùng
				this.con.commit();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// Trở lại trạng thái an toàn của kết nối
				try {
					this.con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
		}
		// TODO Auto-generated method stub
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
	public boolean delete(PreparedStatement pre) {
		// TODO Auto-generated method stub
		return this.exe(pre);
	}

	@Override
	public ArrayList<ResultSet> gets(String multiSelect) {
		ArrayList<ResultSet> res= new ArrayList<ResultSet>();
		try {
			PreparedStatement prestmt = this.con.prepareStatement(multiSelect);
			
			boolean results =prestmt.execute();
			do {
				if(results) {
					res.add(prestmt.getResultSet());
					
				}
				results=prestmt.getMoreResults(PreparedStatement.KEEP_CURRENT_RESULT);
				// giữ Result hiện tại đẻ làm
			}while(results);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return null;
	}


	@Override
	public ResultSet get(String sql,String name, String pass) {
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setString(1, name);
			pre.setString(2, pass);
			
			
			return pre.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return null;
	}

	@Override
	public void releaseConnection() {
		// TODO Auto-generated method stub
		try {
			this.cp.relaseConnection(con, this.objectName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	public ResultSet get(String sql, int value) {
		//Biên dịch câu lệnh
				try {
					PreparedStatement pre=this.con.prepareStatement(sql);
					if(value >0) {
						pre.setInt(1, value);
					}
					return pre.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		return null;
	}

}
