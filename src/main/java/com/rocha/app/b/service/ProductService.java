package com.rocha.app.b.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocha.app.b.service.kafka.IKafkaService;
import com.rocha.app.c.repository.ProductRepository;
import com.rocha.app.d.entity.Product;

@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private IKafkaService kafkaService;

	@Override
	public Product createProduct(Product product) {
		Product producCreated = productRepository.createProduct(product);
		kafkaService.sendMessage(producCreated, "CreatedProduct");
		return producCreated;
	}

	@Override
	public Product updateProduct(long id, Product product) {
		Product productCreated = productRepository.updateProduct(id, product);
		kafkaService.sendMessage(productCreated, "UpdatedProduct");
		return productCreated;
	}
}










