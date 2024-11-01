package com.product.inventory.inventory.exception;

public class ProductNotPresentException extends RuntimeException {
	private String message;


	public ProductNotPresentException(String message) {
		super();
		this.message = message;
	}

	public ProductNotPresentException() {
		super();
	}

	public String getMessage() {
		return message;
	}

	
}
