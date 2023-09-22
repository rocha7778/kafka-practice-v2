package com.rocha.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocha.app.dto.ProductDto;
import com.rocha.app.entity.Product;
import com.rocha.app.service.IProductCommandService;
import com.rocha.app.util.MapperUtil;

@RestController
@RequestMapping("/products")
public class ProductCommandController {
	
	@Autowired
	private IProductCommandService productService;
	
	@PostMapping
	public ProductDto createProduct(@RequestBody ProductDto product) {
		Product productResponse =  productService.createProduct(MapperUtil.mapper(product));
		return MapperUtil.mapper(productResponse);
	}
	
	
	@PutMapping("/{id}")
	public ProductDto updateProduc(@PathVariable long id, @RequestBody ProductDto product) {
		Product productResponse =  productService.updateProduct(id, MapperUtil.mapper(product));
		return MapperUtil.mapper(productResponse);
	}

}
