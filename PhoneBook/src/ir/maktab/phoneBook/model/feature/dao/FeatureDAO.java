package ir.maktab.phoneBook.model.feature.dao;


import java.util.List;


import ir.maktab.phoneBook.base.AbstractEntityDAO;
import ir.maktab.phoneBook.model.feature.Feature;

public class FeatureDAO extends AbstractEntityDAO<Feature> {
	
	private static FeatureDAO featureDAOInstance=new FeatureDAO();
	
	private FeatureDAO(){
		
	}
	
	public static FeatureDAO getInstance(){
		return featureDAOInstance;
	}

	@Override
	public boolean add(Feature e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void delete(Feature e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Feature e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Feature getByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Feature> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
