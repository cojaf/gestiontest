package hibernate;

import java.util.List;
import java.util.Set;

import org.hibernate.LockOptions;
import org.hibernate.Query;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pojo.Personne;

/**
 * A data access object (DAO) providing persistence and search support for
 * Personne entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see pojo.Personne
 * @author MyEclipse Persistence Tools
 */
public class PersonneDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(PersonneDAO.class);
	// property constants
	public static final String NOM = "nom";
	public static final String PRENOM = "prenom";
	public static final String SEXE = "sexe";

	public void save(Personne transientInstance) {
		log.debug("saving Personne instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Personne persistentInstance) {
		log.debug("deleting Personne instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Personne findById(java.lang.Integer id) {
		log.debug("getting Personne instance with id: " + id);
		try {
			Personne instance = (Personne) getSession().get(
					"pojo.Personne", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Personne> findByExample(Personne instance) {
		log.debug("finding Personne instance by example");
		try {
			List<Personne> results = (List<Personne>) getSession()
					.createCriteria("pojo.Personne").add(create(instance))
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
		log.debug("finding Personne instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Personne as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Personne> findByNom(Object nom) {
		return findByProperty(NOM, nom);
	}

	public List<Personne> findByPrenom(Object prenom) {
		return findByProperty(PRENOM, prenom);
	}

	public List<Personne> findBySexe(Object sexe) {
		return findByProperty(SEXE, sexe);
	}

	public List findAll() {
		log.debug("finding all Personne instances");
		try {
			String queryString = "from Personne";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Personne merge(Personne detachedInstance) {
		log.debug("merging Personne instance");
		try {
			Personne result = (Personne) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Personne instance) {
		log.debug("attaching dirty Personne instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Personne instance) {
		log.debug("attaching clean Personne instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}