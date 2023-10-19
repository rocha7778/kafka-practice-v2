package com.rocha.app.b.sale.apllication.port.out;

import com.rocha.app.b.sale.application.domain.model.SaleRecordProduct;

public interface SaleRecordProductRepository {
	public SaleRecordProduct registerSale(SaleRecordProduct saleRecordProduct);

}
