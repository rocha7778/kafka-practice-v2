package com.rocha.app.a.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;

import com.rocha.app.a.product.entity.Product;

public interface ProductRepository {
	public Product createProduct(Product product);
	public Product updateProduct(Long id, Product product) throws Exception;
	public void deleteProductById(Long id);
	public Optional<Product> findProductById(Long id) throws Exception;
	public Product findProductByName(String name);
	public List<Product> findAll();
	public List<Product> findall(Specification<Product> spec);
	
}
