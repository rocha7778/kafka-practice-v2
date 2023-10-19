package com.rocha.app.b.service;

import com.rocha.app.d.entity.Product;

public interface IProductService {
	 public Product createProduct(Product product);
	 public Product updateProduct(long id,Product product);

}
