package ir.maktab.phoneBook.model.user.logic;


import java.util.List;


import ir.maktab.phoneBook.base.AbstractEntityManager;
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
		return UserDAO.getInstance().add(e);
	}
	
	public User signIn(User e){
		return UserDAO.getInstance().signIn(e);
	}

	@Override
	public void update(User e) {
		if(e.getRole()==null){
			e.setRole(this.getByUserName(e.getUserName()).getRole());
		}
		UserDAO.getInstance().update(e);
	}

	@Override
	public void delete(User e) {
		UserDAO.getInstance().delete(e);
	}

	@Override
	public List<User> list() {
		return UserDAO.getInstance().getAll();
	}

	public User getByUserName(String userName) {
		return UserDAO.getInstance().getByUserName(userName);
	}


	@Override
	public List<User> list(String start, String len) {
		int startIndex=Integer.parseInt(start);
		int endIndex=Integer.parseInt(len);
		return UserDAO.getInstance().getAll().subList(startIndex, endIndex);
	}

}
