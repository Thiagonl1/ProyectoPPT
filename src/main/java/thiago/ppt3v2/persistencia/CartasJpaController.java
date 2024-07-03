
package thiago.ppt3v2.persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import thiago.ppt3v2.logica.Cartas;
import thiago.ppt3v2.persistencia.exceptions.NonexistentEntityException;


public class CartasJpaController implements Serializable {

    public CartasJpaController(){
        emf = Persistence.createEntityManagerFactory("dbPU");
    }
    
    public CartasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cartas cartas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cartas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cartas cartas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            cartas = em.merge(cartas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = cartas.getCartaId();
                if (findCartas(id) == null) {
                    throw new NonexistentEntityException("The cartas with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cartas cartas;
            try {
                cartas = em.getReference(Cartas.class, id);
                cartas.getCartaId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cartas with id " + id + " no longer exists.", enfe);
            }
            em.remove(cartas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cartas> findCartasEntities() {
        return findCartasEntities(true, -1, -1);
    }

    public List<Cartas> findCartasEntities(int maxResults, int firstResult) {
        return findCartasEntities(false, maxResults, firstResult);
    }

    private List<Cartas> findCartasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cartas.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Cartas findCartas(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cartas.class, id);
        } finally {
            em.close();
        }
    }

    public int getCartasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cartas> rt = cq.from(Cartas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
