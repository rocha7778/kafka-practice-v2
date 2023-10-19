package com.rocha.app.product.application.domain.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductEvent implements Serializable{
	private static final long serialVersionUID = 2303630736817614195L;
	private String evenType;
	private ProductDto product;

}