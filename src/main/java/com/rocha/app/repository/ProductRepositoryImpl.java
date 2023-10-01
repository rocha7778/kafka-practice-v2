package com.rocha.app.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocha.app.dto.ProductDto;
import com.rocha.app.entity.Product;

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
		Product existingProduct = productRepository.findById(id).get();
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setDescription(product.getDescription());
		return productRepository.save(existingProduct);
	}
	
	@Override
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product findById(Long id) {
		return productRepository.findById(id).get();
	}

	@Override
	public Product createProduct(ProductDto product) {
		return productRepository.save(mapper(product));
	}
	
	private Product mapper(ProductDto product) {
		Product productDto = new Product();
		productDto.setDescription(product.getDescription());
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setPrice(product.getPrice());
		return productDto;
	}

	@Override
	public Product updateProduct(ProductDto product) {
		Product existingProduct = findById(product.getId());
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setDescription(product.getDescription());
		return productRepository.save(existingProduct);
	}

}
