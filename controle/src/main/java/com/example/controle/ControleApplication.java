package com.example.controle;

import com.example.controle.dao.entities.Book;
import com.example.controle.dao.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class ControleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleApplication.class, args);
	}

	@Bean
	CommandLineRunner book(BookRepository bookRepository){
		return args -> {
			List<Book> bookList = List.of(
				Book.builder().titre("book1").publisher("walid").datePublication(LocalDate.now()).price(Float.valueOf(50)).build(),
					Book.builder().titre("book2").publisher("walid").datePublication(LocalDate.now()).price(Float.valueOf(40)).build(),
					Book.builder().titre("book3").publisher("walid").datePublication(LocalDate.now()).price(Float.valueOf(20)).build(),
					Book.builder().titre("book4").publisher("walid").datePublication(LocalDate.now()).price(Float.valueOf(30)).build()

			);

			bookRepository.saveAll(bookList);
		};
	}

}
