package com.rocha.app.a.product.entity;

import java.util.Random;

public class NumberGenerator {

	Integer ramdon;

	/**
	 * 
	 */
	public NumberGenerator() {
		super();
		ramdon = new Random().nextInt();

	}

	public Integer getRamdonNumer() {
		return ramdon;
	}

}
