package com.rocha.app.repository;

import java.util.List;

import com.rocha.app.dto.ProductDto;
import com.rocha.app.entity.Product;

public interface ProductRepository {
	public Product createProduct(Product product);
	public Product updateProduct(Long id, Product product);

	
	public List<Product> getProducts();
	public Product findById(Long id);
	public Product createProduct(ProductDto product);
	public Product updateProduct(ProductDto product);
}
