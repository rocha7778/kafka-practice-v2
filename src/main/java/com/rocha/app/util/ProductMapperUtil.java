package com.rocha.app.util;

import com.rocha.app.dto.ProductDto;
import com.rocha.app.entity.Product;

public class ProductMapperUtil {
	
	
	public static  ProductDto mapper(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setDescription(product.getDescription());
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setPrice(product.getPrice());
		productDto.setQuantity(product.getQuantity());
		return productDto;
	}
	
	public static Product mapper(ProductDto productDto) {
		Product product = new Product();
		product.setDescription(productDto.getDescription());
		product.setId(productDto.getId());
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		product.setQuantity(productDto.getQuantity());
		return product;
	}

}
