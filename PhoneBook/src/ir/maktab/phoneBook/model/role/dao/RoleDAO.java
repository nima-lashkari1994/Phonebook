package ir.maktab.phoneBook.model.role.dao;

import java.util.Set;


import ir.maktab.phoneBook.base.AbstractEntityDAO;
import ir.maktab.phoneBook.model.role.Role;

public class RoleDAO extends AbstractEntityDAO<Role> {

	private static RoleDAO roleDAOInstance = new RoleDAO();

	private RoleDAO() {

	}

	public static RoleDAO getInstance() {
		return roleDAOInstance;
	}

	@Override
	public boolean add(Role e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void delete(Role e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Role e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Role getByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Role> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
