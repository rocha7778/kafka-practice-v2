package com.rocha.app.b.sale.service.domain;

import com.rocha.app.a.product.entity.Product;
import com.rocha.app.b.sale.entity.SaleRecordProduct;

public interface IStockManageMentDomain {
	
	public Product updateInventory(SaleRecordProduct saleRecordProduct , Product currentProduct) throws Exception;

}
