package bdbeans;
// Generated 13 f�vr. 2025, 12:47:45 by Hibernate Tools 5.4.33.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.LockMode;
import org.hibernate.criterion.Example;
import hiberutile.SessionFactoryProvider;

public class PersonneHome {

    private static final Logger logger = Logger.getLogger(PersonneHome.class.getName());
    private static final SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public void persist(Personne transientInstance) {
        logger.log(Level.INFO, "Persisting Personne instance");
        Transaction tx = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            tx = session.beginTransaction();
            session.persist(transientInstance);
            tx.commit();
            logger.log(Level.INFO, "Persist successful");
        } catch (RuntimeException re) {
            if (tx != null) tx.rollback();
            logger.log(Level.SEVERE, "Persist failed", re);
            throw re;
        }
    }

    public void attachDirty(Personne instance) {
        logger.log(Level.INFO, "Attaching dirty Personne instance");
        Transaction tx = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            tx = session.beginTransaction();
            session.saveOrUpdate(instance);
            tx.commit();
            logger.log(Level.INFO, "Attach successful");
        } catch (RuntimeException re) {
            if (tx != null) tx.rollback();
            logger.log(Level.SEVERE, "Attach failed", re);
            throw re;
        }
    }

    public void delete(Personne persistentInstance) {
        logger.log(Level.INFO, "Deleting Personne instance");
        Transaction tx = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            tx = session.beginTransaction();
            session.delete(persistentInstance);
            tx.commit();
            logger.log(Level.INFO, "Delete successful");
        } catch (RuntimeException re) {
            if (tx != null) tx.rollback();
            logger.log(Level.SEVERE, "Delete failed", re);
            throw re;
        }
    }

    public Personne merge(Personne detachedInstance) {
        logger.log(Level.INFO, "Merging Personne instance");
        Transaction tx = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            tx = session.beginTransaction();
            Personne result = (Personne) session.merge(detachedInstance);
            tx.commit();
            logger.log(Level.INFO, "Merge successful");
            return result;
        } catch (RuntimeException re) {
            if (tx != null) tx.rollback();
            logger.log(Level.SEVERE, "Merge failed", re);
            throw re;
        }
    }

    public Personne findById(int id) {
        logger.log(Level.INFO, "Getting Personne instance with id: " + id);
        try (Session session = sessionFactory.getCurrentSession()) {
            return session.get(Personne.class, id);
        } catch (RuntimeException re) {
            logger.log(Level.SEVERE, "Get failed", re);
            throw re;
        }
    }

    public List<Personne> findByExample(Personne instance) {
        logger.log(Level.INFO, "Finding Personne instance by example");
        try (Session session = sessionFactory.getCurrentSession()) {
            return session.createCriteria(Personne.class)
                    .add(Example.create(instance))
                    .list();
        } catch (RuntimeException re) {
            logger.log(Level.SEVERE, "Find by example failed", re);
            throw re;
        }
    }

    public Personne connexion(String login) {
        logger.log(Level.INFO, "Getting Personne instance with login: " + login);
        try (Session session = sessionFactory.getCurrentSession()) {
            return session.createQuery("FROM Personne WHERE login = :login", Personne.class)
                    .setParameter("login", login)
                    .uniqueResult();
        } catch (RuntimeException re) {
            logger.log(Level.SEVERE, "Connexion failed", re);
            throw re;
        }
    }

    public static List<Personne> listUsers() {
        try (Session session = sessionFactory.getCurrentSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Personne> query = builder.createQuery(Personne.class);
            Root<Personne> root = query.from(Personne.class);
            query.select(root);
            return session.createQuery(query).getResultList();
        } catch (RuntimeException re) {
            logger.log(Level.SEVERE, "List users failed", re);
            throw re;
        }
    }

    public static List<String> listPrenoms() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<String> query = builder.createQuery(String.class);
            Root<Personne> root = query.from(Personne.class);
            query.select(root.get("prenom"));
            return session.createQuery(query).getResultList();
        } catch (RuntimeException re) {
            logger.log(Level.SEVERE, "List prenoms failed", re);
            throw re;
        }
    }

    public static Personne findByLogin(String login) {
        logger.info("Recherche de Personne avec login: " + login);
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Personne> cq = cb.createQuery(Personne.class);
            Root<Personne> root = cq.from(Personne.class);
            cq.select(root).where(cb.equal(root.get("login"), login));
            return session.createQuery(cq).uniqueResult();
        } catch (RuntimeException re) {
            logger.log(Level.SEVERE, "Erreur lors de la recherche", re);
            throw re;
        }
    }
}
