package com.rocha.app.product.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rocha.app.product.application.domain.model.Product;

public interface ProductRepositoryJPA extends JpaRepository<Product, Long>{

}
