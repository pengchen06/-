package exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exam.entity.FilmEntity;
import exam.entity.LanguageEntity;
import exam.util.ConnectionFactory;

public class LoginDao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	boolean b=false;

	private Connection getconn(){
		ConnectionFactory factory=new ConnectionFactory();
		conn=factory.getinstance().makefactory();
		return conn;
	}

	public boolean select(String username){
		try {
			String sql="select * from customer where customer.first_name=?;";
			conn=getconn();
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			rs=ps.executeQuery();
			if(rs.next()){
				b=true;
			}
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
		return b;
	}

	public List<FilmEntity> select(){
		List<FilmEntity> list=new ArrayList<FilmEntity>();
		try {
			String sql="select * from film ,language  where 1=1 and film.language_id=language.language_id;";
			conn=getconn();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				FilmEntity entity=new FilmEntity();
				LanguageEntity en=new LanguageEntity();
				entity.setFilm_id(rs.getInt("film_id"));
				entity.setLanguage_id(rs.getInt("language_id"));
				entity.setOriginal_language_id(rs.getInt("original_language_id"));
				entity.setTitle(rs.getString("title"));
				entity.setDescription(rs.getString("description"));
				entity.setLast_update(rs.getDate("last_update"));
				entity.setLength(rs.getInt("length"));
				entity.setRating(rs.getString("rating"));
				entity.setRelease_year(rs.getDate("release_year"));
				entity.setRental_duration(rs.getInt("rental_duration"));
				entity.setRental_rate(rs.getDouble("rental_rate"));
				entity.setReplacement_cost(rs.getInt("replacement_cost"));
				entity.setSpecial_features(rs.getString("special_features"));
				en.setLanguage_id(rs.getInt("language_id"));
				en.setLast_update(rs.getDate("last_update"));
				en.setName(rs.getString("name"));
				entity.setEntity(en);
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

	//	public LanguageEntity select(int id){
	//		LanguageEntity entity=new LanguageEntity();
	//		try {
	//			String sql="select * from language where language_id=?;";
	//			conn=getconn();
	//			ps=conn.prepareStatement(sql);
	//			rs=ps.executeQuery();
	//			while(rs.next()){
	//				entity.setLanguage_id(rs.getInt("language_id"));
	//				entity.setName(rs.getString("name"));
	//				entity.setLast_update(rs.getDate("last_update"));
	//			}
	//		} catch (SQLException e) {
	//			e.printStackTrace();
	//		}finally{
	//			try {
	//				rs.close();
	//			} catch (SQLException e) {
	//				e.printStackTrace();
	//			}
	//			try {
	//				ps.close();
	//			} catch (SQLException e) {
	//				e.printStackTrace();
	//			}
	//			try {
	//				conn.close();
	//			} catch (SQLException e) {
	//				e.printStackTrace();
	//			}
	//			
	//		}
	//		return entity;
	//	}
}
