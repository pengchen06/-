package userinfo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import userinfo.entity.userinfoentity;
import userinfo.util.ConnectionFactory;

public class userinfoDao {
	Connection conn=null;
	PreparedStatement ps=null;
	boolean b=false;
	int a=0;

	private  Connection  getConnection(){
		ConnectionFactory factory=new ConnectionFactory();
		conn=factory.getinstance().makefactory();
		return conn;
	}
	public boolean select(String username,String userpass){
		try {
			String sql="select * from userinfo where username=? and userpass=?;";
			conn=getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, userpass);
			b=ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return  b;
	}




}