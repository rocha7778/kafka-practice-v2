package com.rocha.app.a.product.service.kafka;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.rocha.app.a.product.entity.Product;

@Service
@ConditionalOnProperty(name="service.mock", havingValue="true")
public class KafkaServiceMock implements IKafkaService {

	
	public KafkaServiceMock() {
		System.out.println("Cargando kafka mock");
	}

	@Override
	public void sendMessage(Product productCreated, String eventType) {
		System.out.println("llamando kafka mock");
	}
}








