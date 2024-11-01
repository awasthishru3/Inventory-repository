package com.product.inventory.inventory.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="product_inventory")
public class InventoryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer inventoryId;
	private Integer productId;
	private String productName;
	private String skuCode;
	private Long quantity;
	private boolean isStockEmpty;
	private Date fulfilledDate;
}
