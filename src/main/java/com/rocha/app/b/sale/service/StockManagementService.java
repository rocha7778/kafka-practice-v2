package com.rocha.app.b.sale.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocha.app.a.product.entity.Product;
import com.rocha.app.a.product.repository.ProductRepository;
import com.rocha.app.a.product.service.kafka.IKafkaService;
import com.rocha.app.b.sale.entity.SaleRecordProduct;
import com.rocha.app.b.sale.service.domain.StockManageMentDomain;

@Service
public class StockManagementService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private StockManageMentDomain StockManageMentDomain;

	@Autowired
	private IKafkaService kafkaService;

	public void updateInventory(SaleRecordProduct saleRecordProduct) throws Exception {
		Product currentProduct = productRepository.findProductById(saleRecordProduct.getProductId());
		Product productUdated = StockManageMentDomain.updateInventory(saleRecordProduct, currentProduct);
		
		currentProduct.setQuantity(productUdated.getQuantity());
		Product productUpdated = updateInventoryStock(currentProduct);
		registerProductUpdatedEvent(productUpdated);

	}

	public boolean isStockAvailable(Double quantityAvailable, Double quantityTosell) {
		if (quantityAvailable >= quantityTosell) {
			return true;
		}
		return false;
	}

	public Product updateInventoryStock(Product currentProduct) {
		return productRepository.updateProduct(currentProduct.getId(), currentProduct);
	}

	private void registerProductUpdatedEvent(Product productUpdated) {
		kafkaService.sendMessage(productUpdated, "UpdatedProduct");
	}

}
