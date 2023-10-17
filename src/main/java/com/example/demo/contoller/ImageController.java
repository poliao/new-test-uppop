package com.example.demo.contoller;


import com.example.demo.model.Image;
import com.example.demo.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.Pageable;
import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping("/api/images")
@CrossOrigin(origins = "http://localhost:8081")
public class ImageController {

    @Autowired
    private ImageRepository imageRepository;

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        try {
            // อ่านข้อมูลจากไฟล์
            byte[] imageData = file.getBytes();

            // สร้าง Entity Image
            Image image = new Image();
            image.setData(imageData);
            image.setFileName(file.getOriginalFilename());

            // บันทึกรูปลงในฐานข้อมูล
            final Image savedImage = imageRepository.save(image);

            return ResponseEntity.ok("File uploaded successfully! Image ID: " + savedImage.getId());
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error uploading file.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        // ดึงข้อมูลรูปจากฐานข้อมูล
        return imageRepository.findById(id)
                .map(image -> ResponseEntity.ok().body(image.getData()))
                .orElse(ResponseEntity.notFound().build());
    }

}
