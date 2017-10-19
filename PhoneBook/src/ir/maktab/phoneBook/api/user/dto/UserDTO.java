package ir.maktab.phoneBook.api.user.dto;

import ir.maktab.phoneBook.model.role.Role;

public class UserDTO {
	
	private String userName;
		
	private Role role;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserDTO [userName=" + userName + ", role=" + role + "]";
	}

	public UserDTO(String userName, Role role) {
		super();
		this.userName = userName;
		this.role = role;
	}

	public UserDTO() {
		super();
	}
	
	
	
}
