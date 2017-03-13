package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdbc.entity.Jdbc_addresEntity;
import jdbc.util.ConnectionFactory;

public class Jdbc_addresDao {
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
	 * 根据 address_id 查询所有数据,返回entity
	 * @param address_id
	 * @return
	 */
	public  Jdbc_addresEntity select(int address_id){
		Jdbc_addresEntity entity=new Jdbc_addresEntity();

		try {
			String sql="select * from jdbc_addres where address_id=?;";
			conn=getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, address_id);
			rs=ps.executeQuery();
			while(rs.next()){
				entity.setAddress_id(rs.getInt("address_id"));
				entity.setAddress_name(rs.getString("address_name"));
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
		return entity;
	}

}
