package com.rocha.app.a.product.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;



@SpringBootTest
public class ProductRepositoryImplTest {
	
	@Autowired
	private ProductRepositoryJPA productRepository;
	
	@Test
	@DirtiesContext
	public void deleteById_basic() {
		productRepository.deleteById(1l);
		assertTrue(productRepository.findById(1l).isEmpty());
	}

}
