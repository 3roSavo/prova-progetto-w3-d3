package eros_savogin.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "documenti")
public class Document {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "data_Di_Emissione")
    private LocalDate issueDate;
    @Column(name = "località")
    private String country;
    @Column(name = "codice_Postale")
    private String code;
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false) // JoinColumn specifica il NOME della colonna altrimenti il suo valore di default
    private User user;            // sarà il nome dell'attributo + "_id". Quindi adesso ho creato la chiave esterna
                                  // collegata alla classe User. questa FK si collegherà alla chiave primaria di User
    //Costruttori
    public Document() {}

    public Document(LocalDate issueDate, String country, String code, User user) {
        this.issueDate = issueDate;
        this.country = country;
        this.code = code;
        this.user = user;
    }

    //GETTER E SETTER

    public long getId() {
        return id;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) { // ha senso dare la possibilità di settare una chiave secondaria o è pericoloso?
        this.user = user;
    } // ha senso poter modificare lo user associato a un documento?

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", issueDate=" + issueDate +
                ", country='" + country + '\'' +
                ", code='" + code + '\'' +
                ", user=" + user +
                '}';
    }
}
