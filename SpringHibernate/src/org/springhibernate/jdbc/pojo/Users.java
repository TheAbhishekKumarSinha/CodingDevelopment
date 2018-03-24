package org.springhibernate.jdbc.pojo;

public class Users {

	
	private String userid;
	private String username;
	private String password;
	private int unsuccessfulLoginAttempts;
	private String userLocked;
	private String userLockedReason;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getUnsuccessfulLoginAttempts() {
		return unsuccessfulLoginAttempts;
	}
	public void setUnsuccessfulLoginAttempts(int unsuccessfulLoginAttempts) {
		this.unsuccessfulLoginAttempts = unsuccessfulLoginAttempts;
	}
	public String getUserLocked() {
		return userLocked;
	}
	public void setUserLocked(String userLocked) {
		this.userLocked = userLocked;
	}
	public String getUserLockedReason() {
		return userLockedReason;
	}
	public void setUserLockedReason(String userLockedReason) {
		this.userLockedReason = userLockedReason;
	}
		

}
