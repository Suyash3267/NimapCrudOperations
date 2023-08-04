package com.nimap.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimap.model.ProductModel;
import com.nimap.repository.RepoPoduct;

@Service
public class ProductService {
    @Autowired
    private RepoPoduct product;

    public List<ProductModel> getAllProducts() {
        return product.findAll();
    }

    public ProductModel getProductById(Long id) {
        return product.findById(id).orElse(null);
    }

    public ProductModel createProduct(ProductModel prod) {
        return product.save(prod);
    }

    public ProductModel updateProduct(ProductModel prod) {
        return product.save(prod);
    }

    public void deleteProduct(Long id) {
    	product.deleteById(id);
    }
    public List<ProductModel> getAllProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductModel> productPage = product.findAll(pageable);
        return productPage.getContent();
    }

}

