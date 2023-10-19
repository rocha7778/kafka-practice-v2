package com.rocha.app.b.sale.application.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocha.app.b.sale.application.domain.model.SaleRecordProduct;
import com.rocha.app.b.sale.service.domain.port.out.SaleRecordProductRepository;

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
