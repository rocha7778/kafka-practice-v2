package com.rocha.app.product.application.domain.service;

import com.rocha.app.product.application.domain.model.Product;

public interface IProductService {
	 public Product createProduct(Product product);
	 public Product updateProduct(long id,Product product);

}
