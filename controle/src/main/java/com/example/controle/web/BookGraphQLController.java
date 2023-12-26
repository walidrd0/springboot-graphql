package com.example.controle.web;

import com.example.controle.service.BookManager;
import com.example.controle.service.dtos.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookGraphQLController {
    @Autowired
    private BookManager bookManager;

    @MutationMapping
    BookDTO saveBook(@Argument BookDTO book){
        return bookManager.saveBook(book);
    }
    @QueryMapping
    List<BookDTO> getBookByTitle(@Argument String title){
        return bookManager.getBookByTitle(title);
    }
    @QueryMapping
    List<BookDTO> getBookByPublisherAndPrice(@Argument String publisher,@Argument Float price){
        return bookManager.getBookByPublisherAndPrice(publisher, price);
    }
    @MutationMapping
    BookDTO  deleteBook(@Argument Long id){
        return bookManager.deleteBook(id);
    }
}
