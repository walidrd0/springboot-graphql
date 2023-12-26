package com.example.controle.service;

import com.example.controle.dao.entities.Book;
import com.example.controle.dao.repositories.BookRepository;
import com.example.controle.service.dtos.BookDTO;
import com.example.controle.service.mappers.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookManagerAction implements BookManager{
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookMapper bookMapper;

    @Override
    public BookDTO saveBook(BookDTO bookDTO) {
        Book book = bookMapper.fromBookDTOToBook(bookDTO);
       if(!bookRepository.findBookByTitreAndPublisher(book.getTitre(),book.getPublisher()))
          return null;

        return bookMapper.fromBookToBookDTO(
                bookRepository.save(
                        bookMapper.fromBookDTOToBook(bookDTO)
                )
        );
    }

    @Override
    public List<BookDTO> getBookByTitle(String title) {
        return bookRepository.findBookByTitre(title).stream().map(bookMapper::fromBookToBookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> getBookByPublisherAndPrice(String publisher, Float price) {
        return bookRepository.findBookByPublisherAndPrice(publisher,price).stream().map(bookMapper::fromBookToBookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO deleteBook(Long id) {
        Book book = bookRepository.findById(id).get();
        if( book == null){
            new RuntimeException(String.format("Book with id %s not found",id));
        }
        bookRepository.deleteById(id);
        return new BookDTO();
    }
}
