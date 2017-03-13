package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.entity.Jdbc_userEntity;
import jdbc.util.ConnectionFactory;

public class Jdbc_userDao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;

	/**
	 * 获取数据库连接
	 * @return
	 */
	private Connection getConnection(){
		ConnectionFactory factory=new ConnectionFactory();
		conn=factory.getinstance().makefactory();
		return conn;
	}
	/**
	 * 根据address_id查询数据,返回list
	 * @param address_id
	 * @return
	 */
	public  List<Jdbc_userEntity> select( int address_id){
		List<Jdbc_userEntity> list=new ArrayList<Jdbc_userEntity>();
		/*Jdbc_userEntity entity=new Jdbc_userEntity();*/
		try {
			String sql="select * from jdbc_user where jdbc_user.address_id=?;";
			conn=getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, address_id);
			rs=ps.executeQuery();
			while(rs.next()){
				Jdbc_userEntity entity=new Jdbc_userEntity();
				entity.setUser_id(rs.getInt("user_id"));
				entity.setName(rs.getString("name"));
				entity.setHobby(rs.getString("hobby"));
				entity.setAddress_id(rs.getInt("address_id"));
				list.add(entity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
		return list;

	}
}
