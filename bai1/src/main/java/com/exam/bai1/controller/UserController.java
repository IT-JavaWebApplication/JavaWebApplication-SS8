package com.exam.bai1.controller;

import com.exam.bai1.dto.AddressDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class UserController {

    @GetMapping("/test")
    public String testServer() {
        return "Xin chào! Tomcat và Spring Boot của bạn đang chạy rất mượt mà!";
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(@Valid @RequestBody AddressDto dto) {
        return ResponseEntity.ok("Cập nhật thành công!");
    }
}