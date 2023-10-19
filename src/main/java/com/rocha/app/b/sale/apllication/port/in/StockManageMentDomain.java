package com.rocha.app.b.sale.apllication.port.in;

import com.rocha.app.b.sale.application.domain.model.SaleRecordProductDto;
import com.rocha.app.product.application.domain.model.ProductDto;


public class StockManageMentDomain {
	

	public ProductDto updateInventory(SaleRecordProductDto saleRecordProduct , ProductDto currentProduct) throws Exception {
		
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

