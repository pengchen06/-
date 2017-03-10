package userinfo.entity;

public class userinfoentity extends IdEntity {
	private String username;
	private String userpass;


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	@Override
	public String toString() {
		return "userinfoentity [username=" + username + ", userpass=" + userpass + ", getUserid()=" + getUserid() + "]";
	}


}
