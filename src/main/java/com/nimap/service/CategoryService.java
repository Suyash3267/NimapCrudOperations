package com.nimap.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.nimap.model.CategoryModel;
import com.nimap.repository.RepositoryCat;

@Service
public class CategoryService {
    @Autowired
    private RepositoryCat category;

    public List<CategoryModel> getAllCategories() {
        return category.findAll();
    }

    public CategoryModel getCategoryById(Long id) {
        return category.findById(id).orElse(null);
    }

    public CategoryModel createCategory(CategoryModel cat) {
        return category.save(cat);
    }

    public CategoryModel updateCategory(CategoryModel cat) {
        return category.save(cat);
    }

    public void deleteCategory(Long id) {
    	category.deleteById(id);
    }
    public List<CategoryModel> getAllCategories(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<CategoryModel> categoryPage = category.findAll(pageable);
        return categoryPage.getContent();
    }
}


