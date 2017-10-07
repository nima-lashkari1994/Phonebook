package ir.maktab.phoneBook.model.role;


import java.util.HashSet;
import java.util.Set;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ir.maktab.phoneBook.model.feature.Feature;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Role {

	private String name;
	private Set<Feature> features;
	
	
	
	
	public Role() {
	}


	public Role(String name, Set<Feature> features) {
		this.name = name;
		this.features = features;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Set<Feature> getFeatures() {
		return features;
	}


	public void setFeatures(Set<Feature> features) {
		this.features = features;
	}


	public static Role getGuestRole() {

		Set<Feature> features = new HashSet<Feature>();
		features.add(new Feature("seeContacts"));

		return new Role("guest", features);
	}


	public static Role getSimpleUserRole() {

		Set<Feature> features = new HashSet<Feature>();
		
		features.add(new Feature("seeContacts"));
		features.add(new Feature("createContacts"));
		
		return new Role("simpleUser", features);
	}
	
	public static Role getHeadRole() {

		Set<Feature> features = new HashSet<Feature>();
		
		features.add(new Feature("seeContacts"));
		features.add(new Feature("createContacts"));
		features.add(new Feature("editContacts"));	
		features.add(new Feature("seeUserActivities"));
		
		return new Role("head", features);
	}
	
	
	public static Role getAdminRole() {

		Set<Feature> features = new HashSet<Feature>();
		
		features.add(new Feature("seeContacts"));
		features.add(new Feature("createContacts"));
		features.add(new Feature("editContacts"));	
		features.add(new Feature("seeUserActivities"));
		features.add(new Feature("editUsersInformation"));
		features.add(new Feature("editUsersRole"));
		
		return new Role("admin", features);
	}
	

}
