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
        //System.out.println("creato con successo documento con il seguente id : " + document.getId() + ", collegato a  " + document.getUser().getFirstName() + " (id:" + document.getUser().getId() + ")" );

    }

    public Document findById(long id) {
        return em.find(Document.class, id);
    }

    public void findByIdAndDelete(long id) {

        Document document = em.find(Document.class, id);

        if (document != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(document);
            transaction.commit();
            System.out.println("documento con id " + document.getId() + " di " + document.getUser().getFirstName() + " è stato eliminato correttamente");
        } else {
            System.out.println("il documento con id " + id + " non esiste nel database");
        }
    }

}
