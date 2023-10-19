package com.rocha.app.c.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rocha.app.d.entity.Product;

public interface ProductRepositoryJPA extends JpaRepository<Product, Long>{

}
