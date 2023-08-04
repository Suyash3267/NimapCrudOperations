package com.nimap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimap.model.ProductModel;

public interface RepoPoduct extends JpaRepository<ProductModel, Long> {
}
