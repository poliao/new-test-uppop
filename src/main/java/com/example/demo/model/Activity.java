package com.example.demo.model;


import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_activity")
    private Long idActivity;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private LocalTime time;

    @Column(name = "location")
    private String location;

    @Column(name = "nameactivity")
    private String nameActivity;

    @Column(name = "category")
    private String category;

    @Column(name = "detail")
    private String detail;

    // getters and setters
}
