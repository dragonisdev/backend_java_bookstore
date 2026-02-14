package fi.haagahelia.bookstore.web;

import java.util.*;
import org.springframework.web.bind.annotation.RestController;

import fi.haagahelia.bookstore.domain.BookRepository;
import fi.haagahelia.bookstore.domain.Book;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
public class BookRestController {

    private BookRepository BookRepository; 

    // Constructor Injection 
	public BookRestController(BookRepository BookRepository) {
		this.BookRepository = BookRepository;
	}

    @RequestMapping(value="/books", method=RequestMethod.GET)
    public @ResponseBody List<Book> BookListRest() {
        return (List<Book>) BookRepository.findAll();
    }
    
     @RequestMapping(value="/books/{id}", method=RequestMethod.GET)
     public @ResponseBody Optional<Book> FindBookRest(@PathVariable("id") Long BookId) {
        return BookRepository.findById(BookId);
     }
    

}
