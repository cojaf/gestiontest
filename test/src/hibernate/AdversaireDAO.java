package hibernate;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pojo.Adversaire;

/**
 * A data access object (DAO) providing persistence and search support for
 * Adversaire entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see pojo.Adversaire
 * @author MyEclipse Persistence Tools
 */
public class AdversaireDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AdversaireDAO.class);
	// property constants
	public static final String NUMERO_LIGUE = "numeroLigue";

	public void save(Adversaire transientInstance) {
		log.debug("saving Adversaire instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Adversaire persistentInstance) {
		log.debug("deleting Adversaire instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Adversaire findById(java.lang.Integer id) {
		log.debug("getting Adversaire instance with id: " + id);
		try {
			Adversaire instance = (Adversaire) getSession().get(
					"pojo.Adversaire", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Adversaire> findByExample(Adversaire instance) {
		log.debug("finding Adversaire instance by example");
		try {
			List<Adversaire> results = (List<Adversaire>) getSession()
					.createCriteria("pojo.Adversaire")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Adversaire instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Adversaire as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Adversaire> findByNumeroLigue(Object numeroLigue) {
		return findByProperty(NUMERO_LIGUE, numeroLigue);
	}

	public List findAll() {
		log.debug("finding all Adversaire instances");
		try {
			String queryString = "from Adversaire";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Adversaire merge(Adversaire detachedInstance) {
		log.debug("merging Adversaire instance");
		try {
			Adversaire result = (Adversaire) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Adversaire instance) {
		log.debug("attaching dirty Adversaire instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Adversaire instance) {
		log.debug("attaching clean Adversaire instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}