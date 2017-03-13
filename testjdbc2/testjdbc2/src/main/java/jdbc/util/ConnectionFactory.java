package jdbc.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
	private static String driver;
	private static String dburl;
	private static String user;
	private static String password;

	public static final ConnectionFactory factory=new ConnectionFactory();


	static{
		Properties pro=new Properties();
		try {
			InputStream in=ConnectionFactory.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			pro.load(in);
		} catch (Exception e) {
			System.out.println("===========读取配置文件出错==============");
		}
		driver=pro.getProperty("driver");
		dburl=pro.getProperty("dburl");
		user=pro.getProperty("user");
		password=pro.getProperty("password");

	}
	public ConnectionFactory(){

	}
	public ConnectionFactory getinstance(){
		return factory;
	}
	public Connection makefactory(){
		Connection conn=null;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(dburl, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
