package com.product.inventory.inventory.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryDTO {
	private Integer inventoryId;
	private Integer productId;
	private String productName;
	private String skuCode;
	private Long quantity;
	private boolean isStockEmpty;
	private Date fulfilledDate;
	private String port ;
	public void setEnvironment(String port) {
		// TODO Auto-generated method stub
		this.port = port;
	}
}
