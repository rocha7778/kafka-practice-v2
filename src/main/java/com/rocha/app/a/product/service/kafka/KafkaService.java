package com.rocha.app.a.product.service.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.rocha.app.a.product.dto.ProductEvent;
import com.rocha.app.a.product.entity.Product;

@Service
@ConditionalOnProperty(name="service.mock", havingValue="false")
public class KafkaService implements IKafkaService {

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	
	public KafkaService() {
		System.out.println("Cargando kafka real");
	}

	@Override
	public void sendMessage(Product productCreated, String eventType) {
		ProductEvent event = new ProductEvent(eventType, productCreated);
		kafkaTemplate.send("product-event-topic", event);
	}
}








