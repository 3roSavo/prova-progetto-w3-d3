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
                                   // questo vuol dire avrò accesso anche da qui al Document dello User (una volta costruiti gli appositi getter/setter)
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

    public Document getDocument() {            // GETTER per il document, ora ho un metodo per ottenere document
        return document;                       // ecco quindi che posso utilizzare la bidirezionalità creata con mappedBy
    }

    public void setDocument(Document document) {   // SETTER per il document, ora ho un metodo per settare il document
        this.document = document;                  // sempre grazie alla bidirezionalità data da mappedBy
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +      // ATTENZIONE, con la relazione bidirezionale se hai nel toString
                '}';                                    // un riferimento a document esso causerà un loop infinito (stackoverflow error)
    }                                                   // perché lo user del toString  nel document richiamerà
}                                                       // il document del toString nello user e avanti così all'infinito


