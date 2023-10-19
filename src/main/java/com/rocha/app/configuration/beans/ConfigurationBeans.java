package com.rocha.app.configuration.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rocha.app.b.sale.service.domain.StockManageMentDomain;

@Configuration
public class ConfigurationBeans {
	
	@Bean
	public StockManageMentDomain getStockManageMentDomain() {
		return new StockManageMentDomain();
	}

}
