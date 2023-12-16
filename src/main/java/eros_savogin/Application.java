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

        Document d1 = new Document(LocalDate.parse("2013-02-20"), "Usa", "4615620", uDao.findById(66));
        //dDao.Save(d1);
        // in questo caso dopo aver messo l'attributo chiave esterna user in Document nullable = false non mi consentirà di salvare il documento
        // ed è un bene, perché sennò mi sarei ritrovato un document non collegato ad alcun user (con user_id = null)

        //dDao.findByIdAndDelete(17);
        System.out.println(dDao.findById(12));
        System.out.println(uDao.findById(4).getDocument()); // grazie al mappedBy ora posso accedere al document anche
                                                            // dallo user, tramite i getter e setter appositi
        //uDao.save(u1);
        //uDao.save(u2);
        //uDao.save(u3);

        //uDao.findByIdAndDelete(6);

        //System.out.println(daniele);
        System.out.println(dDao.findById(4));
    }
}
