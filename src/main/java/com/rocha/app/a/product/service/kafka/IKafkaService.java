package com.rocha.app.a.product.service.kafka;

import com.rocha.app.a.product.entity.Product;

public interface IKafkaService {
	
	public void sendMessage(Product producCreated, String eventType);

}
