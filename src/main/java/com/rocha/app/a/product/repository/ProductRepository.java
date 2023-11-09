package com.rocha.app.a.product.repository;

import java.util.List;

import com.rocha.app.a.product.entity.Product;

public interface ProductRepository {
	public Product createProduct(Product product);
	public Product updateProduct(Long id, Product product);
	public Product findProductById(Long id);
	public Product findProductByName(String name);
	public Product findProductByIdTransactional(Long id);
	public List<Product> findAll();
}
