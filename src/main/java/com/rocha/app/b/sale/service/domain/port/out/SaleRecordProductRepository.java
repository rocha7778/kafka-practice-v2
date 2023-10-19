package com.rocha.app.b.sale.service.domain.port.out;

import com.rocha.app.b.sale.application.domain.model.SaleRecordProduct;

public interface SaleRecordProductRepository {
	public SaleRecordProduct registerSale(SaleRecordProduct saleRecordProduct);

}
