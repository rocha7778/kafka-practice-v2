package com.rocha.app.b.service.domain;

import com.rocha.app.dto.ProductDto;
import com.rocha.app.dto.SaleRecordProductDto;


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

