package com.rocha.app.b.sale.service.domain;

import com.rocha.app.a.product.entity.Product;
import com.rocha.app.b.sale.entity.SaleRecordProduct;


public class StockManageMentDomain {
	

	public Product updateInventory(SaleRecordProduct saleRecordProduct , Product currentProduct) throws Exception {
		
		Double quantityAvailable = currentProduct.getQuantity();
		Double quantityTosell = saleRecordProduct.getQuantity();
		Double newStock = quantityAvailable - quantityTosell;

		if (isStockAvailable(quantityAvailable, quantityTosell)) {
			currentProduct.setQuantity(newStock);
			return currentProduct;
		}else {
			throw new Exception("Sctock no available");
		}
	}

	public boolean isStockAvailable(Double quantityAvailable, Double quantityTosell) {
		if (quantityAvailable >= quantityTosell) {
			return true;
		}
		return false;
	}
}

