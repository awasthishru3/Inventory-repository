package com.product.inventory.inventory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.inventory.inventory.entity.InventoryEntity;

@Repository
public interface InventoryRepo extends JpaRepository<InventoryEntity, Integer>{

	InventoryEntity findInventoryByProductName(String productName);

}
