package com.rocha.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rocha.app.entity.Product;

public interface ProductRepositoryJPA extends JpaRepository<Product, Long>{

}
