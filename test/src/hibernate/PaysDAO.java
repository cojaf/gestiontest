package hibernate;

import java.util.List;
import java.util.Set;

import org.hibernate.LockOptions;
import org.hibernate.Query;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pojo.Pays;

/**
 * A data access object (DAO) providing persistence and search support for Pays
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see pojo.Pays
 * @author MyEclipse Persistence Tools
 */
public class PaysDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(PaysDAO.class);
	// property constants
	public static final String CODE_PAYS = "codePays";
	public static final String NOM_PAYS = "nomPays";

	public void save(Pays transientInstance) {
		log.debug("saving Pays instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Pays persistentInstance) {
		log.debug("deleting Pays instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Pays findById(java.lang.Integer id) {
		log.debug("getting Pays instance with id: " + id);
		try {
			Pays instance = (Pays) getSession().get("pojo.Pays", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Pays> findByExample(Pays instance) {
		log.debug("finding Pays instance by example");
		try {
			List<Pays> results = (List<Pays>) getSession()
					.createCriteria("pojo.Pays").add(create(instance))
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
		log.debug("finding Pays instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Pays as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Pays> findByCodePays(Object codePays) {
		return findByProperty(CODE_PAYS, codePays);
	}

	public List<Pays> findByNomPays(Object nomPays) {
		return findByProperty(NOM_PAYS, nomPays);
	}

	public List findAll() {
		log.debug("finding all Pays instances");
		try {
			String queryString = "from Pays";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Pays merge(Pays detachedInstance) {
		log.debug("merging Pays instance");
		try {
			Pays result = (Pays) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Pays instance) {
		log.debug("attaching dirty Pays instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Pays instance) {
		log.debug("attaching clean Pays instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}