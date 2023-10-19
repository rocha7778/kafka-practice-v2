package com.rocha.app.b.sale.apllication.port.in;

import com.rocha.app.b.sale.application.domain.model.SaleRecordProduct;

public interface SaleServiceUseCase {
	
	public SaleRecordProduct registerSale(SaleRecordProduct saleRecordProduct) throws Exception;

}
