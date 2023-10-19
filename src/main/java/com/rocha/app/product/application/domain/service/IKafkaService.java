package com.rocha.app.product.application.domain.service;

import com.rocha.app.product.application.domain.model.Product;

public interface IKafkaService {
	
	public void sendMessage(Product producCreated, String eventType);

}
