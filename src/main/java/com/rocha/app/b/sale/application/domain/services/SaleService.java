package com.rocha.app.b.sale.application.domain.services;

import com.rocha.app.b.sale.application.domain.model.SaleRecordProduct;

public interface SaleService {
	
	public SaleRecordProduct registerSale(SaleRecordProduct saleRecordProduct) throws Exception;

}
