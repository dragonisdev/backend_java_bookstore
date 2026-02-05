package fi.haagahelia.bookstore;

import java.math.BigDecimal;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;
import fi.haagahelia.bookstore.domain.Category;
import fi.haagahelia.bookstore.domain.CategoryRepository;



@SpringBootApplication


public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	//creates database entries into database
	@Bean
	public CommandLineRunner CommandLineShit(BookRepository bookRepository, CategoryRepository categoryRepository){
		return args -> {/*
            categoryRepository.save(new Category("Horror"));
            categoryRepository.save(new Category("Thriller"));
            categoryRepository.save(new Category("Scifi"));

            Category horrorCategory = categoryRepository.findByName("Thriller").get(0);
            bookRepository.save(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, "9780743273565", new BigDecimal("10.99"), horrorCategory));
            bookRepository.save(new Book("To Kill a Mockingbird", "Harper Lee", 1960, "9780061120084", new BigDecimal("7.99"), null));
            bookRepository.save(new Book("1984", "George Orwell", 1949, "9780451524935", new BigDecimal("9.99"), null));
        */}; 
		
	}
}
