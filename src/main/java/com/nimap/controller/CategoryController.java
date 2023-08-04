package com.nimap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nimap.model.CategoryModel;
import com.nimap.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService ctServices;

    @GetMapping("/{id}")
    public ResponseEntity<CategoryModel> getCat(@PathVariable Long id) {
        CategoryModel category = ctServices.getCategoryById(id);
        return ResponseEntity.ok(category);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryModel createCat(@RequestBody CategoryModel category) {
        return ctServices.createCategory(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryModel> updateCat(@PathVariable Long id, @RequestBody CategoryModel category) {
        CategoryModel existingCategory = ctServices.getCategoryById(id);
        if (existingCategory != null) {
            category.setId(id);
            return ResponseEntity.ok(ctServices.updateCategory(category));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCat(@PathVariable Long id) {
        if (ctServices.getCategoryById(id) != null) {
            ctServices.deleteCategory(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

     @GetMapping
    public List<CategoryModel> allCategories(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "2") int size) {
        return ctServices.getAllCategories(page, size);
    }
}
