package ir.maktab.phoneBook.model.role.logic;

import java.util.Set;

import ir.maktab.phoneBook.base.AbstractEntityManager;
import ir.maktab.phoneBook.model.role.Role;

public class RoleManager extends AbstractEntityManager <Role> {
	
	private static RoleManager roleManagerInstance=new RoleManager();
	
	private RoleManager(){
		
	}
	
	public static RoleManager getInstance(){
		return roleManagerInstance;
	}

	@Override
	public boolean add(Role e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(Role e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Role e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<Role> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role getByUserName(String Name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role createNew() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
