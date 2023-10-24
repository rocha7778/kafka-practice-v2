package com.rocha.app.util;

import org.modelmapper.ModelMapper;

import com.rocha.app.a.product.dto.ProductDto;
import com.rocha.app.a.product.entity.Product;

public class ProductMapperUtil {
	
	// use in the web layer
	public static  ProductDto mapper(Product product) {
		ModelMapper modelMapper = new ModelMapper();
		ProductDto productDto = modelMapper.map(product, ProductDto.class);
		return productDto;
	}
	
	// in the entity layer
	public static Product mapper(ProductDto productDto) {
		ModelMapper modelMapper = new ModelMapper();
		Product product = modelMapper.map(productDto, Product.class);
		return product;
	}

}
