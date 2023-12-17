package eros_savogin.entities;

import javax.persistence.*;

@Entity
@Table(name = "blogs")
public class BlogPost {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)                // ho messo nullable = false perché ogni blogpost
    private User user;    // <---- FOREIGN KEY, verso User         // devo essere sicuro che sia collegato ad uno User,
                                                                   // facendo così non c'è rischio che io crei un
                                                                   // blogpost non associato a un utente
    //COSTRUTTORI

    public BlogPost() {}

    public BlogPost(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

    //GETTER E SETTER

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "BlogPost{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", user=" + user +
                '}';
    }
}


