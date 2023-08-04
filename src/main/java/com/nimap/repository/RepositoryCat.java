package com.nimap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimap.model.CategoryModel;

public interface RepositoryCat extends JpaRepository<CategoryModel, Long> {
}
