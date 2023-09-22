package com.rocha.app.service;

import com.rocha.app.entity.Product;

public interface IProductCommandService {
	 public Product createProduct(Product product);
	 public Product updateProduct(long id,Product product);

}
