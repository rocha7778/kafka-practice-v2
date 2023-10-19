package com.rocha.app.b.service.kafka;

import com.rocha.app.d.entity.Product;

public interface IKafkaService {
	
	public void sendMessage(Product producCreated, String eventType);

}
