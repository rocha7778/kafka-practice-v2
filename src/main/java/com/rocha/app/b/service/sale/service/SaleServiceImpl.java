package com.rocha.app.b.service.sale.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocha.app.c.repository.sale.repository.SaleRecordProductRepository;
import com.rocha.app.d.entity.SaleRecordProduct;

@Service
public class SaleServiceImpl implements SaleService {

	@Autowired
	private SaleRecordProductRepository saleServiceRepository;
	
	@Autowired
	private StockManagementService stockManagementService;
	

	@Override
	public SaleRecordProduct registerSale(SaleRecordProduct saleRecordProduct) throws Exception {
		stockManagementService.updateInventory(saleRecordProduct);
		return saleServiceRepository.registerSale(saleRecordProduct);
	}



	
}
