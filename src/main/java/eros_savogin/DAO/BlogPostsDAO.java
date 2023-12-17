package eros_savogin.DAO;

import eros_savogin.entities.BlogPost;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class BlogPostsDAO {
    private EntityManager em;


    //COSTRUTTORE

    public BlogPostsDAO(EntityManager em) {
        this.em = em;
    }

    public void Save(BlogPost blogPost) {
        /*EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(blogPost);
        transaction.commit();*/
        em.getTransaction().begin();
        em.persist(blogPost);
        em.getTransaction().commit();
        System.out.println("blogPost con id " + blogPost.getId() + " di " + blogPost.getUser().getFirstName() + " " + blogPost.getUser().getLastName() + " aggiunto con successo al database");
    }

    public BlogPost findById(long id) {
        return em.find(BlogPost.class, id);
    }

    public void findByIdAndDelete(long id) {
        BlogPost blogPost = em.find(BlogPost.class, id);

        if (blogPost != null) {
            em.getTransaction().begin();
            em.remove(blogPost);
            em.getTransaction().commit();
            System.out.println("blogPost con id " + id + " con titolo: " + blogPost.getTitle() + " di " + blogPost.getUser().getFirstName() + " " + blogPost.getUser().getLastName() + " è stato eliminato!");
        } else {
            System.out.println("blogPost con id " + id + " non presente nel database");
        }
    }


}
