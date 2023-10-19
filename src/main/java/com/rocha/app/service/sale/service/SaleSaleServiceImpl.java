package com.rocha.app.service.sale.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocha.app.entity.Product;
import com.rocha.app.entity.SaleRecordProduct;
import com.rocha.app.repository.ProductRepository;
import com.rocha.app.repository.sale.repository.SaleRecordProductRepository;
import com.rocha.app.service.kafka.IKafkaService;

@Service
public class SaleSaleServiceImpl implements SaleService {

	@Autowired
	private SaleRecordProductRepository saleServiceRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private IKafkaService kafkaService;

	@Override
	public SaleRecordProduct registerSale(SaleRecordProduct saleRecordProduct) {
		decreaseStock(saleRecordProduct);

		return saleServiceRepository.registerSale(saleRecordProduct);

	}

	private void decreaseStock(SaleRecordProduct saleRecordProduct) {

		Product product = productRepository.findProducById(saleRecordProduct.getProductId());
		Double quantityAvailable = product.getQuantity();
		Double quantityTosell = saleRecordProduct.getQuantity();
		Double newStock = quantityAvailable - quantityTosell;

		if (quantityAvailable >= quantityTosell) {
			product.setQuantity(newStock);
			Product productUpdated = productRepository.updateProduct(saleRecordProduct.getProductId(), product);
			kafkaService.sendMessage(productUpdated, "UpdatedProduct");
		}

	}
}
