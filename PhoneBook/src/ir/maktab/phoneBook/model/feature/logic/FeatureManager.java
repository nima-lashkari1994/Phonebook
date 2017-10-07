package ir.maktab.phoneBook.model.feature.logic;


import java.util.Set;

import ir.maktab.phoneBook.base.AbstractEntityManager;
import ir.maktab.phoneBook.model.feature.Feature;

public class FeatureManager extends AbstractEntityManager<Feature> {
	
	private static FeatureManager featureManagerInstance=new FeatureManager();
	
	private FeatureManager(){
		
	}
	
	public static FeatureManager getInstance(){
		return featureManagerInstance;
	}

	@Override
	public boolean add(Feature e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(Feature e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Feature e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<Feature> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Feature getByUserName(String Name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Feature createNew() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
