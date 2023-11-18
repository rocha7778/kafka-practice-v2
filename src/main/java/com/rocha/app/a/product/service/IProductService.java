package com.rocha.app.a.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;

import com.rocha.app.a.product.entity.Product;

public interface IProductService {
	public Product createProduct(Product product);
 
	public void deleteProductById(long id);
	
	public Product updateProduct(long id, Product product) throws Exception;

	public Product createProductInternal(Product product);

	
	public Optional<Product> findProductById(Long id) throws Exception;

	public List<Product> findAll();
	
	List<Product> findallSpec(Specification<Product> spec);

}
