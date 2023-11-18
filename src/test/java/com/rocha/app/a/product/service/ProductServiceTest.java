package com.rocha.app.a.product.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rocha.app.a.product.entity.Product;
import com.rocha.app.a.product.repository.ProductRepository;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

	@InjectMocks
	ProductService customerService;

	@Mock
	ProductRepository productRepository;

	@Test
	public void getAllProducts() {

		Mockito.doReturn(getMockProducts(2)).when(productRepository).findAll();
		List<Product> list = customerService.findAll();
		assertEquals(2, list.size());
	}

	private List<Product> getMockProducts(int size) {

		List<Product> products = new ArrayList<>(size);
		for (int i = 0; i < size; i++) {
			products.add(Product.builder().id(1l).name("name" + i).description("descripction" + i).price(0.3 + i)
					.quantity(11 + i).build());
		}

		return products;
	}

}
