package fi.haagahelia.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import fi.haagahelia.bookstore.domain.AppUser;
import fi.haagahelia.bookstore.domain.AppUserRepository;
import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;
import fi.haagahelia.bookstore.domain.Category;
import fi.haagahelia.bookstore.domain.CategoryRepository;


//@DataJpaTest //if you are using in-memory database, like H2
// OR
@SpringBootTest(classes = BookstoreApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional

public class BookRepositoryTests {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AppUserRepository userRepository;

    @Test
    public void findByAuthorShouldReturnBooks() {
        Category category = categoryRepository.save(new Category("Fiction"));
        bookRepository.save(new Book("Clean Code", "Robert Martin Test", 2008, "978-0132350884", new BigDecimal("35.99"), category));

        List<Book> books = bookRepository.findByAuthor("Robert Martin Test");

        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("Clean Code");
    }

    @Test
    public void saveBookShouldPersist() {
        Category category = categoryRepository.save(new Category("Science"));
        Book book = new Book("A Brief History of Time", "Stephen Hawking", 1988, "978-0553380163", new BigDecimal("12.99"), category);
        bookRepository.save(book);

        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteBookShouldRemoveIt() {
        Category category = categoryRepository.save(new Category("History"));
        Book book = bookRepository.save(new Book("Sapiens", "Yuval Noah Harari", 2011, "978-0062316110", new BigDecimal("18.99"), category));
        Long id = book.getId();

        bookRepository.delete(book);

        assertThat(bookRepository.findById(id)).isEmpty();
    }

    @Test
    public void findAdmin() {
        userRepository.save(new AppUser("tadmin_test", "hashedpassword", "admin@example.com", "ADMIN"));
       
        AppUser found = userRepository.findByUsername("tadmin_test");

        assertThat(found).isNotNull();
     
    }
}


   