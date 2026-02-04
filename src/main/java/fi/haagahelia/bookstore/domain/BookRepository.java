package fi.haagahelia.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//interface to interact with database
//inherits CrudRepository

public interface BookRepository extends CrudRepository<Book, Long> {
    //this is syntax for SELECT * FROM Book WHERE author = ?
    List<Book> findByAuthor(String author);

}
