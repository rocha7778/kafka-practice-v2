package com.rocha.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rocha.app.entity.Product;

@Repository
public interface ProductRepositoryJPA extends JpaRepository<Product, Long>{

}
