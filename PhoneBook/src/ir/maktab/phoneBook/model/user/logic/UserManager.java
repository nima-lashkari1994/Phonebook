package ir.maktab.phoneBook.model.user.logic;


import java.util.List;


import ir.maktab.phoneBook.base.AbstractEntityManager;
import ir.maktab.phoneBook.core.ContactSearchInput;
import ir.maktab.phoneBook.core.UserSearchInput;
import ir.maktab.phoneBook.model.contact.Contact;
import ir.maktab.phoneBook.model.contact.dao.ContactDAO;
import ir.maktab.phoneBook.model.role.Role;
import ir.maktab.phoneBook.model.user.User;
import ir.maktab.phoneBook.model.user.dao.UserDAO;

public class UserManager extends AbstractEntityManager<User> {
	private static UserManager userManagerInstance=new UserManager();
	
	public static UserManager getInstance(){
		return userManagerInstance;
	}
	
	private UserManager(){
		
	}

	@Override
	public boolean add(User e) {
		
		e.setRole(Role.getSimpleUserRole());
		if (e.getUserName().equals("guest") || e.getUserName().equals("Guest")) {
			return false;
		}

		if (e.getUserName().equals("admin") || e.getUserName().equals("Admin")) {
			return false;
		}
		return UserDAO.getInstance().add(e);
	}
	
	public User signIn(User e){
		return UserDAO.getInstance().signIn(e);
	}

	@Override
	public boolean update(User e) {
		
		if (e.getRole().equals(Role.getAdminRole()) && !e.getUserName().equals("admin")) {
			return false;
		}
		if (e.getRole().equals(Role.getGuestRole()) && !e.getUserName().equals("guest")) {
			return false;
		}
		if (!e.getRole().equals(Role.getGuestRole()) && e.getUserName().equals("guest")) {
			return false;
		}
		if (!e.getRole().equals(Role.getAdminRole()) && e.getUserName().equals("admin")) {
			return false;
		}
		
		if(e.getRole()==null){
			e.setRole(this.getByUserName(e.getUserName()).getRole());
		}
		if(UserDAO.getInstance().update(e)){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean delete(User e) {
		return UserDAO.getInstance().delete(e);
	}

	@Override
	public List<User> list() {
		return UserDAO.getInstance().getAll();
	}

	public User getByUserName(String userName) {
		return UserDAO.getInstance().getByUserName(userName);
	}
	
	
	public List<User> search(UserSearchInput input){
		if(input.getUserName()==null){
			input.setUserName("");
		}
		if(input.getRoleName()==null){
			input.setRoleName("");
		}
		
	
		return UserDAO.getInstance().search(input);
	}



}
