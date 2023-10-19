package com.rocha.app.util;

import java.util.Date;

import org.modelmapper.ModelMapper;

import com.rocha.app.b.sale.application.domain.model.SaleRecordProduct;
import com.rocha.app.b.sale.application.domain.model.SaleRecordProductDto;

public class SaleRecordMapperUtil {
	
	public static SaleRecordProductDto mapper(SaleRecordProduct saleRecordProduct) {
		ModelMapper modelMapper = new ModelMapper();
		SaleRecordProductDto saleRecordproduct = modelMapper.map(saleRecordProduct, SaleRecordProductDto.class);
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
