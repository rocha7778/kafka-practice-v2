package com.rocha.app.service.kafka;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rocha.app.entity.Product;

@Service
@Qualifier("kafkaServiceMock")
public class KafkaServiceMock implements IKafkaService {

	
	public KafkaServiceMock() {
		System.out.println("Cargando kafka mock");
	}

	@Override
	public void sendMessage(Product productCreated, String eventType) {
		System.out.println("llamando kafka mock");
	}
}








