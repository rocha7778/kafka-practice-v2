package com.rocha.app.c.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocha.app.d.entity.Product;

@Service
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	private ProductRepositoryJPA productRepository;

	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Long id, Product product) {
		Product existingProduct = findProducById(id);
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setQuantity(product.getQuantity());
		return productRepository.save(existingProduct);
	}

	@Override
	public Product findProducById(Long id) {
		return  productRepository.findById(id).get();
	}
}
