package com.rocha.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="STOCK_PRODUCT")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StockProduct {
	
	@Id
	@GeneratedValue
	private Long id;
    private String name;
    private String description;
    private Long productId;
    private double quantity;

}
