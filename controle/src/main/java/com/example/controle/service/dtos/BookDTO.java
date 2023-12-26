package com.example.controle.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {
    private String titre;
    private String publisher;
    private LocalDate datePublication;
    private Float price;
    private String resume;
}
