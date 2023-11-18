package com.rocha.app.a.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rocha.app.a.product.entity.Product;


@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	private ProductRepositoryJPA productRepository;

	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	

	@Override
	public Product updateProduct(Long id, Product product) throws Exception {
		Product existingProduct = findProductById(id).get();
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setQuantity(product.getQuantity());
		return productRepository.save(existingProduct);
	}


	
	@Transactional(readOnly = true)
	public Optional<Product> findProductById(Long id) throws Exception {
		return  productRepository.findById(id);
	}

	@Override
	public Product findProductByName(String name) {
		return productRepository.findProductByName(name);
	}


	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	@Override
	public List<Product> findall(Specification<Product> spec){
		return productRepository.findAll(spec);
	}


	@Override
	public void deleteProductById(Long id) {
		productRepository.deleteById(id);
	}

	
}
