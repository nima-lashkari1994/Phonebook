package ir.maktab.phoneBook.model.feature;







public class Feature {
	
	
	private String feature;

	
	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public Feature(String feature) {
		this.feature = feature;
	}

	public Feature() {
	}

	@Override
	public String toString() {
		return "Feature [feature=" + feature + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((feature == null) ? 0 : feature.hashCode());
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
		return true;
	}
	
	
	

	
	
}
