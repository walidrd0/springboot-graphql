package com.example.controle.service.mappers;

import com.example.controle.dao.entities.Book;
import com.example.controle.service.dtos.BookDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public BookDTO fromBookToBookDTO(Book book){
        return this.modelMapper.map(book,BookDTO.class);
    }
    public Book fromBookDTOToBook(BookDTO bookDTO){
        return this.modelMapper.map(bookDTO,Book.class);
    }


}
