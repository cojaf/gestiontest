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
 * Pays entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pays", catalog = "test")
public class Pays implements java.io.Serializable {

	// Fields

	private Integer idPays;
	private String codePays;
	private String nomPays;
	private Set<Adresse> adresses = new HashSet<Adresse>(0);

	// Constructors

	/** default constructor */
	public Pays() {
	}

	/** minimal constructor */
	public Pays(String codePays, String nomPays) {
		this.codePays = codePays;
		this.nomPays = nomPays;
	}

	/** full constructor */
	public Pays(String codePays, String nomPays, Set<Adresse> adresses) {
		this.codePays = codePays;
		this.nomPays = nomPays;
		this.adresses = adresses;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idPays", unique = true, nullable = false)
	public Integer getIdPays() {
		return this.idPays;
	}

	public void setIdPays(Integer idPays) {
		this.idPays = idPays;
	}

	@Column(name = "codePays", nullable = false, length = 5)
	public String getCodePays() {
		return this.codePays;
	}

	public void setCodePays(String codePays) {
		this.codePays = codePays;
	}

	@Column(name = "nomPays", nullable = false, length = 50)
	public String getNomPays() {
		return this.nomPays;
	}

	public void setNomPays(String nomPays) {
		this.nomPays = nomPays;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pays")
	public Set<Adresse> getAdresses() {
		return this.adresses;
	}

	public void setAdresses(Set<Adresse> adresses) {
		this.adresses = adresses;
	}

}