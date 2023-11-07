package com.rocha.app.a.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocha.app.a.product.entity.Product;
import com.rocha.app.a.product.repository.ProductRepository;
import com.rocha.app.a.product.service.kafka.IKafkaService;


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
	public Product createProductInternal(Product product) {
		return this.createProduct(product);
	}

	@Override
	public Product updateProduct(long id, Product product) {
		Product productCreated = productRepository.updateProduct(id, product);
		kafkaService.sendMessage(productCreated, "UpdatedProduct");
		return productCreated;
	}

	@Override
	public Product findProductByIdTransactional(Long id) {
		return productRepository.findProductByIdTransactional(id);
	}
}










