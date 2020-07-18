package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author j.h on 7/18/20
 */
@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author adam = new Author("Adam", "Huang");
        Book ddd = new Book("Domain Driven Test", "123456");
        Publisher tom = new Publisher("Tom", "1 Royal Dr", "Piscataway", "NJ", "08854");
        adam.getBooks().add(ddd);
        ddd.getAuthors().add(adam);

        authorRepository.save(adam);
        bookRepository.save(ddd);
        publisherRepository.save(tom);

        Author fiona = new Author("Fiona", "Sit");
        Book st = new Book("Spirit Tunes", "234321");
        fiona.getBooks().add(st);
        st.getAuthors().add(fiona);

        authorRepository.save(fiona);
        bookRepository.save(st);

        System.out.println("Started in BootStrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
    }
}
