package com.rocha.app.a.product.service.kafka;

import org.springframework.stereotype.Service;

import com.rocha.app.a.product.entity.Product;

@Service
public class KafkaServiceMock implements IKafkaService {

	
	public KafkaServiceMock() {
		System.out.println("Cargando kafka mock");
	}

	@Override
	public void sendMessage(Product productCreated, String eventType) {
		System.out.println("llamando kafka mock");
	}
}








