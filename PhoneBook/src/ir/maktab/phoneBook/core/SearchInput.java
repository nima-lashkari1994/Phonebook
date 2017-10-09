package ir.maktab.phoneBook.core;

import javax.ws.rs.QueryParam;

public class SearchInput {
	
	@QueryParam("fname")
	private String firstName;
	
	@QueryParam("lname")
	private String lastName;
	
	@QueryParam("mnumber")
	private String mobileNumber;
	
	@QueryParam("hnumber")
	private String homeNumber;
	
	@QueryParam("email")
	private String email;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getHomeNumber() {
		return homeNumber;
	}
	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "SearchInput [firstName=" + firstName + ", lastName=" + lastName + ", mobileNumber=" + mobileNumber
				+ ", homeNumber=" + homeNumber + ", email=" + email + "]";
	}
	
	
	
}
