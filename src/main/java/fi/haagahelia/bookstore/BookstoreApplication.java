package fi.haagahelia.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		// Memory-optimized Spring Boot application
		SpringApplication app = new SpringApplication(BookstoreApplication.class);
		
		// Disable unnecessary features for memory saving
		app.setAdditionalProfiles("prod");
		app.setHeadless(true);
		
		// Set web application type explicitly (saves memory)
		app.setWebApplicationType(org.springframework.boot.WebApplicationType.SERVLET);
		
		// Disable banner to save memory
		app.setBannerMode(org.springframework.boot.Banner.Mode.OFF);
		
		// Set lazy initialization globally
		System.setProperty("spring.main.lazy-initialization", "true");
		
		// Run with optimizations
		app.run(args);
	}
}
