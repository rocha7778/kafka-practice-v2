package com.rocha.app.a.product.service;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.rocha.app.a.product.entity.Product;

public interface IProductService {
	public Product createProduct(Product product);

	public Product updateProduct(long id, Product product);

	public Product createProductInternal(Product product);

	public Product findProductByIdTransactional(Long id);
	
	public Product findProductById(Long id);

	public List<Product> findAll();
	
	List<Product> findallSpec(Specification<Product> spec);

}
