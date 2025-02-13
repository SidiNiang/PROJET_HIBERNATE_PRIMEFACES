package bdbeans;
// Generated 13 f�vr. 2025, 12:47:45 by Hibernate Tools 5.4.33.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Etudiant generated by hbm2java
 */
public class Etudiant implements java.io.Serializable {

	private EtudiantId id;
	private Personne personne;
	private String numerocarte;
	private Set courses = new HashSet(0);

	public Etudiant() {
	}

	public Etudiant(EtudiantId id, Personne personne) {
		this.id = id;
		this.personne = personne;
	}

	public Etudiant(EtudiantId id, Personne personne, String numerocarte, Set courses) {
		this.id = id;
		this.personne = personne;
		this.numerocarte = numerocarte;
		this.courses = courses;
	}

	public EtudiantId getId() {
		return this.id;
	}

	public void setId(EtudiantId id) {
		this.id = id;
	}

	public Personne getPersonne() {
		return this.personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public String getNumerocarte() {
		return this.numerocarte;
	}

	public void setNumerocarte(String numerocarte) {
		this.numerocarte = numerocarte;
	}

	public Set getCourses() {
		return this.courses;
	}

	public void setCourses(Set courses) {
		this.courses = courses;
	}

}
