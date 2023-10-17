package com.rocha.app.controller.sale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocha.app.dto.ProductDto;
import com.rocha.app.dto.SaleRecordProductDto;
import com.rocha.app.service.sale.service.SaleService;
import com.rocha.app.util.SaleRecordMapperUtil;

@RestController
@RequestMapping("/products")
public class SaleCommandController {
	
	@Autowired
	private SaleService saleService;
	
	
	@PostMapping("/sell")
	public ProductDto sellProduct(@RequestBody SaleRecordProductDto saleRecordProduct) {
		saleService.registerSale(SaleRecordMapperUtil.mapper(saleRecordProduct));
		return null;
	}

}
