package pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Membre entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "membre", catalog = "test")
public class Membre implements java.io.Serializable {

	// Fields

	private Integer idMembre;
	private Personne personne;
	private Adresse adresse;
	private Date dateNaissance;
	private String courriel;
	private String telephone;

	// Constructors

	/** default constructor */
	public Membre() {
	}

	/** minimal constructor */
	public Membre(Integer idMembre, Personne personne, Adresse adresse) {
		this.idMembre = idMembre;
		this.personne = personne;
		this.adresse = adresse;
	}

	/** full constructor */
	public Membre(Integer idMembre, Personne personne, Adresse adresse,
			Date dateNaissance, String courriel, String telephone) {
		this.idMembre = idMembre;
		this.personne = personne;
		this.adresse = adresse;
		this.dateNaissance = dateNaissance;
		this.courriel = courriel;
		this.telephone = telephone;
	}

	// Property accessors
	@Id
	@Column(name = "idMembre", unique = true, nullable = false)
	public Integer getIdMembre() {
		return this.idMembre;
	}

	public void setIdMembre(Integer idMembre) {
		this.idMembre = idMembre;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idMembre", unique = true, nullable = false, insertable = false, updatable = false)
	public Personne getPersonne() {
		return this.personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idAdresse", nullable = false)
	public Adresse getAdresse() {
		return this.adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dateNaissance", length = 10)
	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@Column(name = "courriel", length = 50)
	public String getCourriel() {
		return this.courriel;
	}

	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}

	@Column(name = "telephone", length = 20)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}