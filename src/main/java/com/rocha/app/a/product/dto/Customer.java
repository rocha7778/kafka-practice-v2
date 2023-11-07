package com.rocha.app.a.product.dto;

import java.io.Serializable;
import java.util.Random;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service
@Scope(value="prototype")
public class Customer implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer ramdomNumber;
	
	public Customer() {
		super();
		
		Random rand = new Random(); 
		ramdomNumber = rand.nextInt();
		
	}

	public Integer getRamdomNumber() {
		return ramdomNumber;
	}


}
