package com.rocha.app.util;

import org.modelmapper.ModelMapper;

import com.rocha.app.dto.ProductDto;
import com.rocha.app.entity.Product;

public class MapperUtil {
	
	public static  ProductDto mapper(Product product) {
		ModelMapper modelMapper = new ModelMapper();
		ProductDto productDto = modelMapper.map(product, ProductDto.class);
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
