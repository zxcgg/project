package cn.cwx521.model;

public class User {
	private int uid;
	private String user;
	private String pass;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int uid, String user, String pass) {
		super();
		this.uid = uid;
		this.user = user;
		this.pass = pass;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", user=" + user + ", pass=" + pass + "]";
	}

}
