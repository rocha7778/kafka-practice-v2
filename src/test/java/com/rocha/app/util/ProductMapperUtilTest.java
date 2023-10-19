package com.rocha.app.util;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.rocha.app.d.entity.Product;
import com.rocha.app.dto.ProductDto;

public class ProductMapperUtilTest {

	@DisplayName("Test util mapper")
	@Test
	void should_get_product_entity_from_product_dto() {

		ProductDto productDto = new ProductDto();
		productDto.setDescription("Computer");
		productDto.setId(1L);
		productDto.setName("Computer");
		productDto.setPrice(120.0);
		productDto.setQuantity(3.0);

		Product product = ProductMapperUtil.mapper(productDto);

		assertNotNull(product);

	}

	@Test
	void should_get_product_dto_from_product_entity() {

		Product product = new Product();
		product.setDescription("Computer");
		product.setId(1L);
		product.setName("Computer");
		product.setPrice(120.0);
		product.setQuantity(3.0);

		ProductDto productDto = ProductMapperUtil.mapper(product);

		assertNotNull(productDto);

	}

}
