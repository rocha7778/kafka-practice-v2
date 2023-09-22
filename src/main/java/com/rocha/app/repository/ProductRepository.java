package com.rocha.app.repository;

import com.rocha.app.entity.Product;

public interface ProductRepository {
	public Product createProduct(Product product);
	public Product updateProduct(Long id, Product product);

}
