package com.rocha.app.util;

import com.rocha.app.dto.ProductDto;
import com.rocha.app.entity.Product;

public class MapperUtil {
	
	
	public static  ProductDto mapper(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setDescription(product.getDescription());
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setPrice(product.getPrice());
		return productDto;
	}
	
	public static Product mapper(ProductDto product) {
		Product productDto = new Product();
		productDto.setDescription(product.getDescription());
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setPrice(product.getPrice());
		return productDto;
	}
	
	
	public static  ProductDto mapperDaoToDto(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setDescription(product.getDescription());
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setPrice(product.getPrice());
		return productDto;
	}
	
	public static Product mapperDtoToDao(ProductDto product) {
		Product productDto = new Product();
		productDto.setDescription(product.getDescription());
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setPrice(product.getPrice());
		return productDto;
	}


}
