package com.example.controle.service;

import com.example.controle.service.dtos.BookDTO;

import java.util.List;

public interface BookManager {
    BookDTO saveBook(BookDTO bookDTO);
    List<BookDTO> getBookByTitle(String title);
    List<BookDTO> getBookByPublisherAndPrice(String publisher,Float price);
    BookDTO  deleteBook(Long id);
}
