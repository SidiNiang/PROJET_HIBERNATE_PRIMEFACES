package bdbeans;
// Generated 13 f�vr. 2025, 12:47:45 by Hibernate Tools 5.4.33.Final

/**
 * EnseignantId generated by hbm2java
 */
public class EnseignantId implements java.io.Serializable {

	private int idpers;
	private int idens;

	public EnseignantId() {
	}

	public EnseignantId(int idpers, int idens) {
		this.idpers = idpers;
		this.idens = idens;
	}

	public int getIdpers() {
		return this.idpers;
	}

	public void setIdpers(int idpers) {
		this.idpers = idpers;
	}

	public int getIdens() {
		return this.idens;
	}

	public void setIdens(int idens) {
		this.idens = idens;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EnseignantId))
			return false;
		EnseignantId castOther = (EnseignantId) other;

		return (this.getIdpers() == castOther.getIdpers()) && (this.getIdens() == castOther.getIdens());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdpers();
		result = 37 * result + this.getIdens();
		return result;
	}

}
