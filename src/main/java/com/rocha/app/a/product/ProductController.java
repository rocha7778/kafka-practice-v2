package com.rocha.app.a.product;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocha.app.a.product.entity.Product;
import com.rocha.app.a.product.service.IProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private IProductService productService;
	
	
	@PostMapping
	public Product createProduct(@RequestHeader(value = "User-Agent") String userAgent, @RequestBody Product product) {
		logger.info(userAgent);
		return productService.createProductInternal(product);
	}
	
	@PutMapping("/{id}")
	public Product updateProduc(@PathVariable long id, @RequestBody Product product) {
		return productService.updateProduct(id, product);
		
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) {
		return productService.findProductByIdTransactional(id);
	}
}
