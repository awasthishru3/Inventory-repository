package com.product.inventory.inventory.exception;

public class InventoryAlreadyPresentException extends RuntimeException{
	String message;
	public InventoryAlreadyPresentException(String message) {
		super();
		this.message = message;
	}

	public InventoryAlreadyPresentException() {
		super();
	}

	public String getMessage() {
		return message;
	}
}
