package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Data
@Entity
public class Image {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_img")
    private Long id;

    @Lob
    private byte[] data;

    private String fileName; // ใช้เก็บชื่อไฟล์รูปภาพ

    // getters and setters
}

