package iducs.java.lombok;


public class NonLombokModel {
	 private String groupid;
	 private String artifactid;
	 private String version;

	 
	public NonLombokModel(String artifactid, String version, String groupid) {
		super();
		this.groupid = groupid;
		this.artifactid = artifactid;
		this.version = version;

	}
	
	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public String getArtifactid() {
		return artifactid;
	}

	public void setArtifactid(String artifactid) {
		this.artifactid = artifactid;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "NonLombokModel [ groupid=" + groupid + ", artifactid=" + artifactid + ", version=" + version + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groupid == null) ? 0 : groupid.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		result = prime * result + ((artifactid == null) ? 0 : artifactid.hashCode());
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
		NonLombokModel other = (NonLombokModel) obj;
		if (groupid == null) {
			if (other.groupid != null)
				return false;
		} else if (!groupid.equals(other.groupid))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		if (artifactid == null) {
			if (other.artifactid != null)
				return false;
		} else if (!artifactid.equals(other.artifactid))
			return false;
		return true;
	} 
}
