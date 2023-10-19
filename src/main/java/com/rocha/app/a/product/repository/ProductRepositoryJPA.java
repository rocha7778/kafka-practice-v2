package com.rocha.app.a.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rocha.app.a.product.entity.Product;

public interface ProductRepositoryJPA extends JpaRepository<Product, Long>{

}
