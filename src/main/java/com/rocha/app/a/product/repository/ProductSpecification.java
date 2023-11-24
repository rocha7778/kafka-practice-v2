package com.rocha.app.a.product.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.rocha.app.a.product.entity.Product;

@Service
public class ProductSpecification {
	
	public static Specification<Product> priceLessThan(Double price) {
		return (root, query, cb) -> cb.lessThan(root.get("price").as(Double.class) , price);
	}
	
	public static Specification<Product> quantityLessThan(Double quantity) {
		return (root, query, cb) -> cb.lessThan(root.get("quantity").as(Double.class) , quantity);
	}
	
	public static Specification<Product> priceGreaterThan(Double price) {
		return (root, query, cb) -> cb.greaterThan(root.get("price").as(Double.class) , price);
	}

}
