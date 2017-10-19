package ir.maktab.phoneBook.core;

import javax.ws.rs.QueryParam;

public class UserSearchInput {
	
	@QueryParam("uName")
	private String userName;
	@QueryParam("roleName")
	private String roleName;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
