package com.rocha.app.service.sale.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocha.app.entity.SaleRecordProduct;
import com.rocha.app.repository.sale.repository.SaleRecordProductRepository;

@Service
public class SaleSaleServiceImpl implements SaleService {
	
	@Autowired
	private SaleRecordProductRepository saleServiceRepository;
	

	@Override
	public SaleRecordProduct registerSale(SaleRecordProduct saleRecordProduct) {
		return saleServiceRepository.registerSale(saleRecordProduct);
	}
}










