package com.rocha.app.util;

import java.util.Date;

import com.rocha.app.dto.SaleRecordProductDto;
import com.rocha.app.entity.SaleRecordProduct;

public class SaleRecordMapperUtil {
	
	public static SaleRecordProduct mapper(SaleRecordProduct saleRecordProduct) {
		SaleRecordProduct saleRecordproduct = new SaleRecordProduct();
		saleRecordproduct.setDate(saleRecordProduct.getDate());
		saleRecordproduct.setId(saleRecordProduct.getId());
		saleRecordproduct.setProductId(saleRecordProduct.getProductId());
		saleRecordproduct.setQuantity(saleRecordProduct.getQuantity());
		return saleRecordproduct;
	}
	
	public static SaleRecordProduct mapper(SaleRecordProductDto saleRecordProductDto) {
		SaleRecordProduct saleRecordproduct = new SaleRecordProduct();
		saleRecordproduct.setDate(new Date());
		saleRecordproduct.setProductId(saleRecordProductDto.getProductId());
		saleRecordproduct.setQuantity(saleRecordProductDto.getQuantity());
		
		return saleRecordproduct;
	}

}
