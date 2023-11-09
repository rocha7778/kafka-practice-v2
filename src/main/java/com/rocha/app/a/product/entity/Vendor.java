package com.rocha.app.a.product.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vendor {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	
	@OneToMany(targetEntity = Product.class, cascade= CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name="vendor_id", referencedColumnName = "id")
	private List<Product> products;
}
