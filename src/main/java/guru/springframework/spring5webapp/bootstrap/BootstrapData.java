package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author j.h on 7/18/20
 */
@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author adam = new Author("Adam", "Huang");
        Book ddd = new Book("Domain Driven Test", "123456");
        adam.getBooks().add(ddd);
        ddd.getAuthors().add(adam);

        authorRepository.save(adam);
        bookRepository.save(ddd);

        Author fiona = new Author("Fiona", "Sit");
        Book st = new Book("Spirit Tunes", "234321");
        fiona.getBooks().add(st);
        st.getAuthors().add(fiona);

        authorRepository.save(fiona);
        bookRepository.save(st);

        System.out.println("Started in BootStrap");
        System.out.println("Number of Books: " + bookRepository.count());
    }
}
