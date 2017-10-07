package ir.maktab.phoneBook.model.feature;

import java.util.HashSet;
import java.util.Set;

import ir.maktab.phoneBook.model.role.Role;

public class Feature {
	
	private String feature;
	private Set<Role> roles;
	
	public Feature() {
		super();
	}
	
	public Feature(String feature){
		this.feature=feature;
	}

	public Feature(String feature, Set<Role> roles) {
		super();
		this.feature = feature;
		this.roles = roles;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Feature [feature=" + feature + ", roles=" + roles + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((feature == null) ? 0 : feature.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
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
		Feature other = (Feature) obj;
		if (feature == null) {
			if (other.feature != null)
				return false;
		} else if (!feature.equals(other.feature))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		return true;
	}

	
}
