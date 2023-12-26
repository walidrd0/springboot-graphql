package com.example.controle.dao.repositories;

import com.example.controle.dao.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
     List<Book> findBookByTitre(String titre);
    List<Book> findBookByPublisherAndPrice(String titre,Float price);
    boolean findBookByTitreAndPublisher(String titre,String publisher);
}
