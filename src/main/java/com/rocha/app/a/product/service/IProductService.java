package com.rocha.app.a.product.service;

import com.rocha.app.a.product.entity.Product;

public interface IProductService {
	 public Product createProduct(Product product);
	 public Product updateProduct(long id,Product product);

}