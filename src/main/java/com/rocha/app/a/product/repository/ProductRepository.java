package com.rocha.app.a.product.repository;

import com.rocha.app.a.product.entity.Product;

public interface ProductRepository {
	public Product createProduct(Product product);
	public Product updateProduct(Long id, Product product);
	public Product findProducById(Long id);
}
