package com.rocha.app.a.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.rocha.app.a.product.entity.Product;

public interface ProductRepositoryJPA extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product>{
	
	public Product findProductByName(String name);

}
