package com.rocha.app.b.sale.application.domain.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleRecordProductDto {
	
	private Long id;
	private Date date;
    private double quantity;
    private Long productId;

}
