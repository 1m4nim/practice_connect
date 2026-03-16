package com.example.practice;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType; 

@Entity
@Data
public class Spending {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer amount;

    private String category;

    private LocalDate date;

}
