package com.rocha.app.product.application.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.rocha.app.product.application.domain.model.Product;
import com.rocha.app.product.application.domain.model.ProductEvent;
import com.rocha.app.util.ProductMapperUtil;

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
		ProductEvent event = new ProductEvent(eventType, ProductMapperUtil.mapper(productCreated));
		kafkaTemplate.send("product-event-topic", event);
	}
}








