package com.product.inventory.inventory.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.inventory.inventory.dao.InventoryRepo;
import com.product.inventory.inventory.dto.InventoryDTO;
import com.product.inventory.inventory.entity.InventoryEntity;
import com.product.inventory.inventory.exception.InventoryAlreadyPresentException;
import com.product.inventory.inventory.exception.ProductNotPresentException;

import lombok.Builder;

@Service
@Builder
public class InventoryService {

	@Autowired
	InventoryRepo inventoryRepo;

	public InventoryDTO getProductInventoryDetails(String productName) {
		InventoryEntity inventoryEntity = inventoryRepo.findInventoryByProductName(productName);
		if (null == inventoryEntity) {
			throw new ProductNotPresentException("Product Not Present In Inventory");
		} else {
			return convertEntityToDTO(inventoryEntity);
		}

	}

	public InventoryDTO saveInventoryDetails(InventoryDTO inventoryDetails) {
		InventoryEntity existingEntity = inventoryRepo.findInventoryByProductName(inventoryDetails.getProductName());
		if (existingEntity == null) {
			InventoryEntity entity = convertDtoTOEntity(inventoryDetails);

			InventoryEntity saveInventoryEntity = inventoryRepo.save(entity);

			return convertEntityToDTO(saveInventoryEntity);
		} else {
			throw new InventoryAlreadyPresentException("Product is already Present in inventory");
		}
	}

	public InventoryEntity convertDtoTOEntity(InventoryDTO inventoryDetails) {
		return new InventoryEntity().builder().productName(inventoryDetails.getProductName())
				.productId(inventoryDetails.getProductId()).quantity(inventoryDetails.getQuantity())
				.skuCode(inventoryDetails.getSkuCode()).fulfilledDate(inventoryDetails.getFulfilledDate())
				.isStockEmpty(inventoryDetails.isStockEmpty()).build();
	}

	public InventoryDTO convertEntityToDTO(InventoryEntity inventoryEntity) {
		return new InventoryDTO().builder().inventoryId(inventoryEntity.getInventoryId())
				.productId(inventoryEntity.getProductId()).productName(inventoryEntity.getProductName())
				.skuCode(inventoryEntity.getSkuCode()).quantity(inventoryEntity.getQuantity())
				.fulfilledDate(inventoryEntity.getFulfilledDate()).isStockEmpty(inventoryEntity.isStockEmpty()).build();
	}
}
