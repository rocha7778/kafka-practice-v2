package com.rocha.app.a.product.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
	
	@Id
	@GeneratedValue
	private Long id;
    private String name;
    private String description;
    private double price;
    private double quantity;
    
    @OneToMany
    private List<Vendor> verdors = new ArrayList<>();
    
    // internal use
    @JsonIgnore
    private String internalCode;

}
