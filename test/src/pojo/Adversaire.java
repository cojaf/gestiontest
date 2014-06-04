package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Adversaire entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "adversaire", catalog = "test")
public class Adversaire implements java.io.Serializable {

	// Fields

	private Integer idAdversaire;
	private Personne personne;
	private String numeroLigue;

	// Constructors

	/** default constructor */
	public Adversaire() {
	}

	/** full constructor */
	public Adversaire(Integer idAdversaire, Personne personne,
			String numeroLigue) {
		this.personne = personne;
		this.idAdversaire = personne.getIdPersonne();
		this.numeroLigue = numeroLigue;
	}

	// Property accessors
	@Id
	@Column(name = "idAdversaire", unique = true, nullable = false)
	public Integer getIdAdversaire() {
		return this.idAdversaire;
	}

	public void setIdAdversaire(Integer idAdversaire) {
		this.idAdversaire = idAdversaire;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idAdversaire", unique = true, nullable = false, insertable = false, updatable = false)
	public Personne getPersonne() {
		return this.personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@Column(name = "numeroLigue", nullable = false, length = 9)
	public String getNumeroLigue() {
		return this.numeroLigue;
	}

	public void setNumeroLigue(String numeroLigue) {
		this.numeroLigue = numeroLigue;
	}

}