package com.rocha.app.a.product.dto;

import java.io.Serializable;

import com.rocha.app.a.product.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductEvent implements Serializable{
	private static final long serialVersionUID = 2303630736817614195L;
	private String evenType;
	private Product product;

}
