package eros_savogin;

import eros_savogin.DAO.DocumentsDAO;
import eros_savogin.DAO.UsersDAO;
import eros_savogin.entities.Document;
import eros_savogin.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {

    private static  final EntityManagerFactory emf = Persistence.createEntityManagerFactory("progetto_prova_d3");
    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        UsersDAO uDao = new UsersDAO(em);
        DocumentsDAO dDao = new DocumentsDAO(em);

        User u1 = new User("Piero", "Trevisan");
        User u2 = new User("Fabrizio", "Corona");
        User u3 = new User("Donatello", "Crosetto");

        //Document d1 = new Document(LocalDate.parse("2012-07-30"), "Denmark", "763096", uDao.findById(6));
        //dDao.Save(d1);
        // in questo caso dopo aver messo l'attributo chiave esterna user in Document nullable = false non mi consentirà di salvare il documento
        // ed è un bene, perchè sennò mi sarei ritrovato un document non collegato ad alcun user (con user_id = null)

        System.out.println("ciaooooo");

        //dDao.findByIdAndDelete(17);

        //uDao.save(u1);
        //uDao.save(u2);
        //uDao.save(u3);

        //uDao.findByIdAndDelete(6);

        //System.out.println(daniele);
        System.out.println(dDao.findById(4));
    }
}
