package com.rocha.app.product.adapter.out.persistence;

import com.rocha.app.product.application.domain.model.Product;

public interface ProductRepository {
	public Product createProduct(Product product);
	public Product updateProduct(Long id, Product product);
	public Product findProducById(Long id);
}
