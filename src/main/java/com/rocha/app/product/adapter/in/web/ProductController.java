package com.rocha.app.product.adapter.in.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocha.app.product.application.domain.model.Product;
import com.rocha.app.product.application.domain.model.ProductDto;
import com.rocha.app.product.application.domain.service.IProductService;
import com.rocha.app.util.ProductMapperUtil;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@PostMapping
	public ProductDto createProduct(@RequestBody ProductDto product) {
		Product productResponse =  productService.createProduct(ProductMapperUtil.mapper(product));
		return ProductMapperUtil.mapper(productResponse);
	}
	
	@PutMapping("/{id}")
	public ProductDto updateProduc(@PathVariable long id, @RequestBody ProductDto product) {
		Product productResponse =  productService.updateProduct(id, ProductMapperUtil.mapper(product));
		return ProductMapperUtil.mapper(productResponse);
	}
}
