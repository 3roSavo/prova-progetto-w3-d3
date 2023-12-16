package eros_savogin.DAO;

import eros_savogin.entities.Document;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DocumentsDAO {

    private final EntityManager em;

    public DocumentsDAO(EntityManager em) {
        this.em = em;
    }

    public void Save(Document document) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(document);
        transaction.commit();
    }

    public Document findById(long id) {
        return em.find(Document.class, id);
    }

}
