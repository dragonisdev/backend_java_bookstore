package fi.haagahelia.bookstore.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

//interface to interact with database
//inherits CrudRepository

public interface BookRepository extends CrudRepository<Book, Long> {
    //this is syntax for SELECT * FROM Book WHERE author = ?
    List<Book> findByAuthor(String author);
    
    // Eagerly fetch categories when loading all books for the list view
    @Query("SELECT b FROM Book b LEFT JOIN FETCH b.category")
    List<Book> findAllWithCategories();
}
