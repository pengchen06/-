package userinfo.services;

import userinfo.dao.userinfoDao;

public class userinfoServices {
	userinfoDao dao=new userinfoDao();

	public boolean select(String username,String userpass){
		return dao.select(username, userpass);
	}
}
