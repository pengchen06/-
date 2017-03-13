package jdbc.entity;

public class Jdbc_userEntity extends IdEntity {
	private int user_id;
    public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	private String name;
    private String hobby;
    private int address_id;
    
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	@Override
	public String toString() {
		return "Jdbc_userEntity [user_id=" + user_id + ", name=" + name + ", hobby=" + hobby + ", address_id="
				+ address_id + "]";
	}
	
}
