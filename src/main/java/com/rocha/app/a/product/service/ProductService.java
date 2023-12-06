package com.rocha.app.a.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.rocha.app.a.aspect.Loggable;
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
	@Loggable
	public Product createProductInternal(Product product) {
		return this.createProduct(product);
	}

	@Override
	@Loggable
	public Product updateProduct(long id, Product product) throws Exception {
		Product productUpdated = productRepository.updateProduct(id, product);
		kafkaService.sendMessage(productUpdated, "UpdatedProduct");
		return productUpdated;
	}

	
	@Override
	public List<Product> findallSpec(Specification<Product> spec) {
		return productRepository.findall(spec);
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	

	@Override
	public Optional<Product> findProductById(Long id) throws Exception {
		return productRepository.findProductById(id);
	}

	@Override
	public void deleteProductById(long id) {
		productRepository.deleteProductById(id);
	}

	
}










