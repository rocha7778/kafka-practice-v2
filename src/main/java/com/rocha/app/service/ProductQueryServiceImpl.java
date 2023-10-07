package com.rocha.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocha.app.entity.Product;
import com.rocha.app.repository.ProductRepository;

@Service
public class ProductQueryServiceImpl implements ProductQueryService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getProducts() {
		return productRepository.getProducts();
	}

}
