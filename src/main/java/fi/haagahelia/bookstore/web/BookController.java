package fi.haagahelia.bookstore.web;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    // index page, aka landing page
    @GetMapping("/index")
    public String index(Model model) {
        
        return "index";
    }

    //goes to booklist, we load all the attributes 
    //called books from bookRepository interface

    @GetMapping("/booklist")
    public String booklist(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }

    //addbook page
    @GetMapping("/addbook")
    public String addBookForm() {
        return "addbook";
    }

    
    /*user makes post request to addbook with the specified params
    we create a new book based on Book class, and push to bookRepository
    which saves to database */

    //sidenote: gosh I hate this syntax, its so verbose to use @requestparam
    @PostMapping("/addbook")
    public String addBook(@RequestParam String title, @RequestParam String author, 
                          @RequestParam int publicationYear, @RequestParam String isbn, 
                          @RequestParam BigDecimal price) {
        Book book = new Book(title, author, publicationYear, isbn, price);
        bookRepository.save(book);
        return "redirect:/booklist";
    }

    /* We delete book based on its id, since JPA 
    automatically creates id incrementally without us needing
    to specify it while creating the rows */
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return "redirect:/booklist";
    }

    /* based on the id, we search db for the Book object row, put into thymeleaf template */
    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable Long id, Model model) {
        Book book = bookRepository.findById(id).orElseThrow();
        model.addAttribute("book", book);
        return "editbook";
    }

    /*send a post request to edit the book based on its id
    this means that if we click edit on 2nd row, change the submit button 
    to make post request to edit/1 and not edit/2, we replace the first row
    with row 2 contents*/
    
    @PostMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, @RequestParam String title, 
                           @RequestParam String author, @RequestParam int publicationYear, 
                           @RequestParam String isbn, @RequestParam BigDecimal price) {
        Book book = bookRepository.findById(id).orElseThrow();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublicationYear(publicationYear);
        book.setIsbn(isbn);
        book.setPrice(price);
        bookRepository.save(book);
        return "redirect:/booklist";
    }
}

