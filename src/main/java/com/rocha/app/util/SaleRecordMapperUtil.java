package com.rocha.app.util;

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
		saleRecordproduct.setDate(saleRecordProductDto.getDate());
		saleRecordproduct.setId(saleRecordProductDto.getId());
		saleRecordproduct.setProductId(saleRecordProductDto.getProductId());
		saleRecordproduct.setQuantity(saleRecordProductDto.getQuantity());
		return saleRecordproduct;
	}

}
