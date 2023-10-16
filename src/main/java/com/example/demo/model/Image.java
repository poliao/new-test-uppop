package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private byte[] data;

    private String fileName; // ใช้เก็บชื่อไฟล์รูปภาพ

    // getters and setters
}

