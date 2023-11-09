package com.rocha.app.a.product.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShoppingCar {
	
	@Id
	private Long id;
	
	@OneToMany
	private List<Product> products;
	
	@OneToOne
	private Customer customer;

}
