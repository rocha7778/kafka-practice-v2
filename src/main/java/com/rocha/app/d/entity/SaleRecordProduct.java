package com.rocha.app.d.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="SALE_RECORD_PRODUCT")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleRecordProduct {
	
	@Id
	@GeneratedValue
	private Long id;
	private Date date;
    private double quantity;
    private Long productId;

}
