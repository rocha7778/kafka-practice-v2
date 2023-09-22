package com.rocha.app.service.kafka;

import com.rocha.app.entity.Product;

public interface IKafkaService {
	
	public void sendMessage(Product producCreated, String eventType);

}
