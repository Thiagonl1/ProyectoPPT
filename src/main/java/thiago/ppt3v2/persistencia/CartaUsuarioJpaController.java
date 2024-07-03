/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import thiago.ppt3v2.logica.CartaUsuario;
import thiago.ppt3v2.logica.Cartas;
import thiago.ppt3v2.logica.Usuario;
import thiago.ppt3v2.persistencia.exceptions.NonexistentEntityException;
import thiago.ppt3v2.persistencia.exceptions.PreexistingEntityException;

public class CartaUsuarioJpaController implements Serializable {

    public CartaUsuarioJpaController(){
        emf = Persistence.createEntityManagerFactory("dbPU");
    }
    
    public CartaUsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CartaUsuario cartaUsuario) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cartas cartaId = cartaUsuario.getCartaId();
            if (cartaId != null) {
                cartaId = em.getReference(cartaId.getClass(), cartaId.getCartaId());
                cartaUsuario.setCartaId(cartaId);
            }
            Usuario usuarioId = cartaUsuario.getUsuarioId();
            if (usuarioId != null) {
                usuarioId = em.getReference(usuarioId.getClass(), usuarioId.getUsuarioId());
                cartaUsuario.setUsuarioId(usuarioId);
            }
            em.persist(cartaUsuario);
            if (cartaId != null) {
                cartaId.getCartaUsuarioCollection().add(cartaUsuario);
                cartaId = em.merge(cartaId);
            }
            if (usuarioId != null) {
                usuarioId.getCartaUsuarioCollection().add(cartaUsuario);
                usuarioId = em.merge(usuarioId);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCartaUsuario(cartaUsuario.getCartaUsuarioId()) != null) {
                throw new PreexistingEntityException("CartaUsuario " + cartaUsuario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CartaUsuario cartaUsuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CartaUsuario persistentCartaUsuario = em.find(CartaUsuario.class, cartaUsuario.getCartaUsuarioId());
            Cartas cartaIdOld = persistentCartaUsuario.getCartaId();
            Cartas cartaIdNew = cartaUsuario.getCartaId();
            Usuario usuarioIdOld = persistentCartaUsuario.getUsuarioId();
            Usuario usuarioIdNew = cartaUsuario.getUsuarioId();
            if (cartaIdNew != null) {
                cartaIdNew = em.getReference(cartaIdNew.getClass(), cartaIdNew.getCartaId());
                cartaUsuario.setCartaId(cartaIdNew);
            }
            if (usuarioIdNew != null) {
                usuarioIdNew = em.getReference(usuarioIdNew.getClass(), usuarioIdNew.getUsuarioId());
                cartaUsuario.setUsuarioId(usuarioIdNew);
            }
            cartaUsuario = em.merge(cartaUsuario);
            if (cartaIdOld != null && !cartaIdOld.equals(cartaIdNew)) {
                cartaIdOld.getCartaUsuarioCollection().remove(cartaUsuario);
                cartaIdOld = em.merge(cartaIdOld);
            }
            if (cartaIdNew != null && !cartaIdNew.equals(cartaIdOld)) {
                cartaIdNew.getCartaUsuarioCollection().add(cartaUsuario);
                cartaIdNew = em.merge(cartaIdNew);
            }
            if (usuarioIdOld != null && !usuarioIdOld.equals(usuarioIdNew)) {
                usuarioIdOld.getCartaUsuarioCollection().remove(cartaUsuario);
                usuarioIdOld = em.merge(usuarioIdOld);
            }
            if (usuarioIdNew != null && !usuarioIdNew.equals(usuarioIdOld)) {
                usuarioIdNew.getCartaUsuarioCollection().add(cartaUsuario);
                usuarioIdNew = em.merge(usuarioIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cartaUsuario.getCartaUsuarioId();
                if (findCartaUsuario(id) == null) {
                    throw new NonexistentEntityException("The cartaUsuario with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CartaUsuario cartaUsuario;
            try {
                cartaUsuario = em.getReference(CartaUsuario.class, id);
                cartaUsuario.getCartaUsuarioId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cartaUsuario with id " + id + " no longer exists.", enfe);
            }
            Cartas cartaId = cartaUsuario.getCartaId();
            if (cartaId != null) {
                cartaId.getCartaUsuarioCollection().remove(cartaUsuario);
                cartaId = em.merge(cartaId);
            }
            Usuario usuarioId = cartaUsuario.getUsuarioId();
            if (usuarioId != null) {
                usuarioId.getCartaUsuarioCollection().remove(cartaUsuario);
                usuarioId = em.merge(usuarioId);
            }
            em.remove(cartaUsuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CartaUsuario> findCartaUsuarioEntities() {
        return findCartaUsuarioEntities(true, -1, -1);
    }

    public List<CartaUsuario> findCartaUsuarioEntities(int maxResults, int firstResult) {
        return findCartaUsuarioEntities(false, maxResults, firstResult);
    }

    private List<CartaUsuario> findCartaUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CartaUsuario.class));
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

    public CartaUsuario findCartaUsuario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CartaUsuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getCartaUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CartaUsuario> rt = cq.from(CartaUsuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
