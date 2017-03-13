package jdbc.dao.d_interface;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.entity.Jdbc_userEntity;

public interface JdbcDao {
	
	/**
	 * 入库方法
	 * @param conn
	 * @param jdbc_user
	 */
    public void  save(Connection conn,Jdbc_userEntity jdbc_user) throws SQLException;
    /**
     * 更新方法
     * @param conn
     * @param id
     * @param jdbc_user
     */
    public void update(Connection conn,long id,Jdbc_userEntity jdbc_user) throws SQLException;
    /**
     * 删除方法
     * @param conn
     * @param id
     * @throws SQLException
     */
    
    public void deltet(Connection conn,long id) throws SQLException;
}
