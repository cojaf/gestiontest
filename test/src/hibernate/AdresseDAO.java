package hibernate;

import java.util.List;
import java.util.Set;

import org.hibernate.LockOptions;
import org.hibernate.Query;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pojo.Adresse;

/**
 * A data access object (DAO) providing persistence and search support for
 * Adresse entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see pojo.Adresse
 * @author MyEclipse Persistence Tools
 */
public class AdresseDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(AdresseDAO.class);
	// property constants
	public static final String RUE = "rue";
	public static final String NUMERO = "numero";
	public static final String BOITE = "boite";
	public static final String VILLE = "ville";
	public static final String CODE_POSTAL = "codePostal";

	public void save(Adresse transientInstance) {
		log.debug("saving Adresse instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Adresse persistentInstance) {
		log.debug("deleting Adresse instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Adresse findById(java.lang.Integer id) {
		log.debug("getting Adresse instance with id: " + id);
		try {
			Adresse instance = (Adresse) getSession().get("pojo.Adresse",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Adresse> findByExample(Adresse instance) {
		log.debug("finding Adresse instance by example");
		try {
			List<Adresse> results = (List<Adresse>) getSession()
					.createCriteria("pojo.Adresse").add(create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Adresse instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Adresse as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Adresse> findByRue(Object rue) {
		return findByProperty(RUE, rue);
	}

	public List<Adresse> findByNumero(Object numero) {
		return findByProperty(NUMERO, numero);
	}

	public List<Adresse> findByBoite(Object boite) {
		return findByProperty(BOITE, boite);
	}

	public List<Adresse> findByVille(Object ville) {
		return findByProperty(VILLE, ville);
	}

	public List<Adresse> findByCodePostal(Object codePostal) {
		return findByProperty(CODE_POSTAL, codePostal);
	}

	public List findAll() {
		log.debug("finding all Adresse instances");
		try {
			String queryString = "from Adresse";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Adresse merge(Adresse detachedInstance) {
		log.debug("merging Adresse instance");
		try {
			Adresse result = (Adresse) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Adresse instance) {
		log.debug("attaching dirty Adresse instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Adresse instance) {
		log.debug("attaching clean Adresse instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}