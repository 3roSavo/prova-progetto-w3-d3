package eros_savogin.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Categorie")
public class Category {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @ManyToMany
    @JoinTable(name = "blogs_categories",
            joinColumns = @JoinColumn(name = "category_id"),          // qui stiamo definendo la junction table
            inverseJoinColumns = @JoinColumn(name = "blogPost_id"))   // visivamente non sarà una tabella, ma fungerà da congiunzione tra le due.
    private List<BlogPost> blogPostList;                              // da entrambe le parti devo impostare la joinColumns e la inverseJoinColumns
                                                                      // ATTENZIONE, la join columns deve riferirsi alla classe corrente e la inverse all'altra
    //COSTRUTTORI

    public Category() {}

    public Category(String name) {
        this.name = name;
    }

    //GETTER E SETTER


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
