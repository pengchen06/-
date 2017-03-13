package exam.services;

import java.util.List;

import exam.dao.LoginDao;
import exam.entity.FilmEntity;
import exam.entity.LanguageEntity;

public class LoginService {
	LoginDao dao=new LoginDao();

	public boolean select(String username){
		return dao.select(username);
	}
	public List<FilmEntity> select(){
		return dao.select();
	}
}
