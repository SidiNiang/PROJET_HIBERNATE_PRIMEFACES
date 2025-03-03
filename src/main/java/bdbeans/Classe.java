package bdbeans;
// Generated 13 f�vr. 2025, 12:47:45 by Hibernate Tools 5.4.33.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Classe generated by hbm2java
 */
public class Classe implements java.io.Serializable {

	private int idclasse;
	private String code;
	private String nom;
	private String niveau;
	private Set courses = new HashSet(0);

	public Classe() {
	}

	public Classe(int idclasse) {
		this.idclasse = idclasse;
	}

	public Classe(int idclasse, String code, String nom, String niveau, Set courses) {
		this.idclasse = idclasse;
		this.code = code;
		this.nom = nom;
		this.niveau = niveau;
		this.courses = courses;
	}

	public int getIdclasse() {
		return this.idclasse;
	}

	public void setIdclasse(int idclasse) {
		this.idclasse = idclasse;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNiveau() {
		return this.niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public Set getCourses() {
		return this.courses;
	}

	public void setCourses(Set courses) {
		this.courses = courses;
	}

}
