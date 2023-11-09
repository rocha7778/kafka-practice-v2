package com.rocha.app.configuration.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import com.rocha.app.a.product.entity.NumberGenerator;
import com.rocha.app.a.product.entity.NumberGeneratorSingleton;
import com.rocha.app.b.sale.service.domain.StockManageMentDomainImpl;

@Configuration
public class ConfigurationBeans {
	
	@Bean
	public StockManageMentDomainImpl getStockManageMentDomain() {
		return new StockManageMentDomainImpl();
	}
	
	
	@Bean
	@RequestScope
	public NumberGenerator getNumberGenerator() {
		return new NumberGenerator();
	}
	
	
	
	@Bean
	public NumberGeneratorSingleton getNumberGeneratorSingleton() {
		return new NumberGeneratorSingleton();
	}
	

}
