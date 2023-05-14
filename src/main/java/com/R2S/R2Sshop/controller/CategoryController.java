package com.R2S.R2Sshop.controller;

import com.R2S.R2Sshop.data.dto.CategoryDTO;
import com.R2S.R2Sshop.service.CategoryService;
import com.R2S.R2Sshop.util.constant.ApiURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiURL.CATEGORIES)
@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(categoryService.findAll());
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody CategoryDTO categoryDTO){
        return ResponseEntity.ok(categoryService.create(categoryDTO));
    }
}
