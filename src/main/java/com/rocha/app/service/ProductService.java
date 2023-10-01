package com.rocha.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocha.app.entity.Product;
import com.rocha.app.repository.ProductRepository;

@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product createProduct(Product product) {
		Product producCreated = productRepository.createProduct(product);
		return producCreated;
	}

	@Override
	public Product updateProduct(long id, Product product) {
		Product productCreated = productRepository.updateProduct(id, product);
		return productCreated;
	}
}










