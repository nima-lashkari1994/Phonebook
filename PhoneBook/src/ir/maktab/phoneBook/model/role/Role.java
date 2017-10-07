package ir.maktab.phoneBook.model.role;

import java.util.HashSet;
import java.util.Set;

import ir.maktab.phoneBook.model.feature.Feature;

public class Role {

	private String name;
	private Set<Feature> features;

	public Role(String name, Set<Feature> features) {
		super();
		this.name = name;
		this.features = features;
	}

	public Role() {
		super();
	}

	@Override
	public String toString() {
		return "Role [name=" + name + ", features=" + features + "]";
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((features == null) ? 0 : features.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (features == null) {
			if (other.features != null)
				return false;
		} else if (!features.equals(other.features))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
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
