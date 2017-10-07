package ir.maktab.phoneBook.model.user.logic;

import java.util.Set;


import ir.maktab.phoneBook.base.AbstractEntityManager;
import ir.maktab.phoneBook.model.user.User;
import ir.maktab.phoneBook.model.user.dao.UserDAO;

public class UserManager extends AbstractEntityManager<User> {
	private static UserManager userManagerInstance=new UserManager();
	
	public static UserManager getInstance(){
		return userManagerInstance;
	}
	
	private UserManager(){
		
	}

	public UserDAO getDao(){
		return UserDAO.getInstance();
	}
	
	@Override
	public boolean add(User e) {
		return this.getDao().add(e);
	}

	@Override
	public void update(User e) {
		this.getDao().update(e);
	}

	@Override
	public void delete(User e) {
		this.getDao().delete(e);
	}

	@Override
	public Set<User> list() {
		return this.getDao().getAll();
	}

	@Override
	public User getByUserName(String userName) {
		return this.getDao().getByUserName(userName);
	}

	@Override
	public User createNew() {
		// TODO Auto-generated method stub
		return null;
	}

}