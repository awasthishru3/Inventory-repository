package com.product.inventory.inventory.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorResponse {
	int statusCode;
	String errorMessage;
	public ErrorResponse(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}
	
}
