package com.example.demo.repository;

import com.example.demo.model.category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<category, Long> {
    // คุณสามารถเพิ่มเมธอดเพิ่มเติมตามต้องการ
}
