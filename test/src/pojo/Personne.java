package pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Personne entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "personne", catalog = "test")
public class Personne implements java.io.Serializable {

	// Fields

	private Integer idPersonne;
	private String nom;
	private String prenom;
	private Boolean sexe;
	private Set<Membre> membres = new HashSet<Membre>(0);

	// Constructors

	/** default constructor */
	public Personne() {
	}

	/** minimal constructor */
	public Personne(String nom, String prenom, Boolean sexe) {
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
	}

	/** full constructor */
	public Personne(String nom, String prenom, Boolean sexe, Set<Membre> membres) {
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.membres = membres;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idPersonne", unique = true, nullable = false)
	public Integer getIdPersonne() {
		return this.idPersonne;
	}

	public void setIdPersonne(Integer idPersonne) {
		this.idPersonne = idPersonne;
	}

	@Column(name = "nom", nullable = false, length = 50)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "prenom", nullable = false, length = 50)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "sexe", nullable = false)
	public Boolean getSexe() {
		return this.sexe;
	}

	public void setSexe(Boolean sexe) {
		this.sexe = sexe;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "personne")
	public Set<Membre> getMembres() {
		return this.membres;
	}

	public void setMembres(Set<Membre> membres) {
		this.membres = membres;
	}

}