package eros_savogin;

import eros_savogin.DAO.DocumentsDAO;
import eros_savogin.DAO.UsersDAO;
import eros_savogin.entities.Document;
import eros_savogin.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {

    private static  final EntityManagerFactory emf = Persistence.createEntityManagerFactory("progetto_prova_d3");
    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        UsersDAO uDao = new UsersDAO(em);
        DocumentsDAO dDao = new DocumentsDAO(em);

        User u1 = new User("Tommaso", "Della Francesca");
        User u2 = new User("Carlo", "Caregon");
        User u3 = new User("Guglielmo", "La Storta");

        //uDao.save(u1);
        //uDao.save(u2);
        //uDao.save(u3);

        uDao.findByIdAndDelete(6);

        //System.out.println(daniele);
        System.out.println(uDao.findById(6));
    }
}
