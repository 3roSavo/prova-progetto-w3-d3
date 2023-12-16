package eros_savogin.DAO;

import eros_savogin.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UsersDAO {
    private final EntityManager em;

    public UsersDAO(EntityManager em) {
        this.em = em;
    }

    public void save(User user) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(user);
        transaction.commit();
        System.out.println("utente " + user.getFirstName() + " aggiunto correttamente");
    }

    public User findById(long id) {
        return em.find(User.class, id);
    }

    public void findByIdAndDelete(long id) {
        User user = em.find(User.class, id);
        if (user != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(user);
            transaction.commit();
            System.out.println("utente " + user.getFirstName() + " eliminato correttamente");
        } else {
            System.out.println("elemento con id " + id + " non presente nel database");
        }
    }

}
