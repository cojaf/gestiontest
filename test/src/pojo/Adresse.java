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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Adresse entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "adresse", catalog = "test")
public class Adresse implements java.io.Serializable {

	// Fields

	private Integer idAdresse;
	private Pays pays;
	private String rue;
	private String numero;
	private String boite;
	private String ville;
	private String codePostal;
	private Set<Membre> membres = new HashSet<Membre>(0);

	// Constructors

	/** default constructor */
	public Adresse() {
	}

	/** minimal constructor */
	public Adresse(Pays pays, String rue, String ville, String codePostal) {
		this.pays = pays;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
	}

	/** full constructor */
	public Adresse(Pays pays, String rue, String numero, String boite,
			String ville, String codePostal, Set<Membre> membres) {
		this.pays = pays;
		this.rue = rue;
		this.numero = numero;
		this.boite = boite;
		this.ville = ville;
		this.codePostal = codePostal;
		this.membres = membres;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idAdresse", unique = true, nullable = false)
	public Integer getIdAdresse() {
		return this.idAdresse;
	}

	public void setIdAdresse(Integer idAdresse) {
		this.idAdresse = idAdresse;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPays", nullable = false)
	public Pays getPays() {
		return this.pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

	@Column(name = "rue", nullable = false, length = 50)
	public String getRue() {
		return this.rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	@Column(name = "numero", length = 6)
	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Column(name = "boite", length = 6)
	public String getBoite() {
		return this.boite;
	}

	public void setBoite(String boite) {
		this.boite = boite;
	}

	@Column(name = "ville", nullable = false, length = 50)
	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Column(name = "codePostal", nullable = false, length = 10)
	public String getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "adresse")
	public Set<Membre> getMembres() {
		return this.membres;
	}

	public void setMembres(Set<Membre> membres) {
		this.membres = membres;
	}

}