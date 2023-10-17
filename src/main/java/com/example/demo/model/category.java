package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "category")
public class category {

    @Id
    @Column(name = "id_category")
    private Long ID_category;

    @Column(name = "category")
    private String category;

    // getters and setters
}
