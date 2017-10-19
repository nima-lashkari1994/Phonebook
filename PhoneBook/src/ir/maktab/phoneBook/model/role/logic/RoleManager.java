package ir.maktab.phoneBook.model.role.logic;

import java.util.List;

import ir.maktab.phoneBook.base.AbstractEntityManager;
import ir.maktab.phoneBook.model.role.Role;
import ir.maktab.phoneBook.model.role.dao.RoleDAO;

public class RoleManager extends AbstractEntityManager<Role> {
	
	private static RoleManager roleManagerInstance = new RoleManager();
	
	private RoleManager(){
		
	}
	
	public static RoleManager getInstance(){
		return roleManagerInstance;
	}

	@Override
	public boolean add(Role e) {
		return RoleDAO.getInstance().add(e);
	}

	@Override
	public boolean update(Role e) {
		return RoleDAO.getInstance().update(e);
	}

	@Override
	public boolean delete(Role e) {
		return RoleDAO.getInstance().delete(e);
	}

	@Override
	public List<Role> list() {
		return RoleDAO.getInstance().getAll();
	}
	
	public Role getByName(String name){
		return RoleDAO.getInstance().getByName(name);
		
	}

}
