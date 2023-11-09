package com.rocha.app.a.product.entity;

import java.util.Random;

public class NumberGeneratorSingleton {

	Integer ramdon;

	/**
	 * 
	 */
	public NumberGeneratorSingleton() {
		super();
		ramdon = new Random().nextInt();

	}

	public Integer getRamdonNumer() {
		return ramdon;
	}

}
