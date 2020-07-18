package guru.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.Set;

/**
 * @author j.h on 7/18/20
 */
@Entity // 1. telling Java Persistence API that this class is an entity
public class Book {

    @Id // 2. telling JPA this is the id, and we need to tell hibernate how it is getting generated
    @GeneratedValue(strategy = GenerationType.AUTO) // 3. telling the underlying database to provide generation of this
    private Long id;

    private String title;
    private String isbn;

    @ManyToMany // 4. setting the many to many relationship
    // we have an author table, a book table and a author_book join table here
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors;

    public Book() {
    }

    public Book(String title, String isbn, Set<Author> authors) {
        this.title = title;
        this.isbn = isbn;
        this.authors = authors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
