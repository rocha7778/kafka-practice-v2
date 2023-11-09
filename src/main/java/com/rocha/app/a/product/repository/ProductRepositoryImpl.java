package com.rocha.app.a.product.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Product updateProduct(Long id, Product product) {
		Product existingProduct = findProductById(id);
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setQuantity(product.getQuantity());
		return productRepository.save(existingProduct);
	}

	@Override
	
	public Product findProductByIdTransactional(Long id) {
		Product p =  findProductById(id);
		p.setDescription("Rocha");
		p = productRepository.save(p);
		productRepository.delete(p);
		
		
		return p;
		
	}
	
	@Transactional(readOnly = true)
	public Product findProductById(Long id) {
		return  productRepository.findById(id).get();
	}

	@Override
	public Product findProductByName(String name) {
		return productRepository.findProductByName(name);
	}


	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	
}
