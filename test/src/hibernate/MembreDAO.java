package hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pojo.Membre;

/**
 * A data access object (DAO) providing persistence and search support for
 * Membre entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see pojo.Membre
 * @author MyEclipse Persistence Tools
 */
public class MembreDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(MembreDAO.class);
	// property constants
	public static final String COURRIEL = "courriel";
	public static final String TELEPHONE = "telephone";

	public void save(Membre transientInstance) {
		log.debug("saving Membre instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Membre persistentInstance) {
		log.debug("deleting Membre instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Membre findById(java.lang.Integer id) {
		log.debug("getting Membre instance with id: " + id);
		try {
			Membre instance = (Membre) getSession().get("pojo.Membre", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Membre> findByExample(Membre instance) {
		log.debug("finding Membre instance by example");
		try {
			List<Membre> results = (List<Membre>) getSession()
					.createCriteria("pojo.Membre").add(create(instance))
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
		log.debug("finding Membre instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Membre as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Membre> findByCourriel(Object courriel) {
		return findByProperty(COURRIEL, courriel);
	}

	public List<Membre> findByTelephone(Object telephone) {
		return findByProperty(TELEPHONE, telephone);
	}

	public List findAll() {
		log.debug("finding all Membre instances");
		try {
			String queryString = "from Membre";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Membre merge(Membre detachedInstance) {
		log.debug("merging Membre instance");
		try {
			Membre result = (Membre) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Membre instance) {
		log.debug("attaching dirty Membre instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Membre instance) {
		log.debug("attaching clean Membre instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}