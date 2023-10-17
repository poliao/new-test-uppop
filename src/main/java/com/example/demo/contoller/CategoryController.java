package com.example.demo.contoller;

import com.example.demo.model.category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public List<category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<category> getCategoryById(@PathVariable Long id) {
        Optional<category> optionalCategory = categoryRepository.findById(id);
        return optionalCategory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<category> createCategory(@RequestBody category category) {
        category savedCategory = categoryRepository.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<category> updateCategory(@PathVariable Long id, @RequestBody category updatedCategory) {
        Optional<category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            category existingCategory = optionalCategory.get();
            existingCategory.setCategory(updatedCategory.getCategory());
            categoryRepository.save(existingCategory);
            return ResponseEntity.ok(existingCategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
