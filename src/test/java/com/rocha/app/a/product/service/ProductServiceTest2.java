package com.rocha.app.a.product.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rocha.app.a.product.entity.Product;

@SpringBootTest
public class ProductServiceTest2 {

	@Autowired
	ProductService customerService;

	@Test
	public void getAllProducts() {
		Product p = Product.builder().id(1l).name("name").description("descripction").price(0.3).quantity(11).build();

		customerService.createProduct(p);
		List<Product> list = customerService.findAll();
		assertEquals(1, list.size());
	}

}
