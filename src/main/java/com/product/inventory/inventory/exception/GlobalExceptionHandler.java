package com.product.inventory.inventory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = ProductNotPresentException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorResponse productNotPresentException(ProductNotPresentException ex){
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}
	
	@ExceptionHandler(value = InventoryAlreadyPresentException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public @ResponseBody ErrorResponse handleInventoryAlreadyPresentException(InventoryAlreadyPresentException ex) {
		return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
	}
}
