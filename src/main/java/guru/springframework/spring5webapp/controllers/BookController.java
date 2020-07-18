package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author j.h on 7/18/20
 */
@Controller
public class BookController {

    private final BookRepository bookRepository;

    /*
        And now because I have a constructor on that, this is a Spring managed component.
        Because it is controller, when Spring instantiate this, it will inject an instance of that book repository into our controller.
     */
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {

        /*
        Now this model is going to get return back to our view layer and it's going to have an attribute books
        and a list of books on that and then we'll be able to utilize that value inside of our view layer
        to apply the necessary view that we're going to be returning back to the client.
         */
        model.addAttribute("books", bookRepository.findAll());

        /*
        It's going to tell the viewers over to look for a template under the directory books called list
         */
        return "books/list";
    }
}
