package eros_savogin.entities;

import javax.persistence.*;

@Entity
@Table(name = "Utenti")
public class User {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "nome")
    private String firstName;
    @Column(name = "cognome")
    private String lastName;
    @OneToOne(mappedBy = "user")   // non è obbligatorio il OneToOne qui, MA così facendo il collegamento sarà bidirezionale
    private Document document;     // attraverso il mappedBy, il cui valore sarà uguale all'attributo della chiave esterna dell'altra classe
                                   // questo vuol dire avrò accesso anche da qui al Document dello User
    //COSTRUTTORI                  ATTENZIONE : qui non si sta creando una nuova colonna ma solo il collegamento bidirezionale con mappedBy

    public User() {}

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //GETTER E SETTER


    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}


