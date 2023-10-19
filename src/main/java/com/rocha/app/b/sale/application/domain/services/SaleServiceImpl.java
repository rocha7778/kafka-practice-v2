package com.rocha.app.b.sale.application.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocha.app.b.sale.apllication.port.in.SaleServiceUseCase;
import com.rocha.app.b.sale.apllication.port.out.SaleRecordProductRepository;
import com.rocha.app.b.sale.application.domain.model.SaleRecordProduct;

@Service
public class SaleServiceImpl implements SaleServiceUseCase {

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
