package com.example.practice;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Spending {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;     // これが重要！ HTMLの th:field="*{type}" と紐付きます
    private String title;
    private Integer amount;
    private String category;
}