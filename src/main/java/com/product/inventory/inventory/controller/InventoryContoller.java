package com.product.inventory.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.inventory.inventory.dto.InventoryDTO;
import com.product.inventory.inventory.service.InventoryService;


@RestController
@RequestMapping("/inventory")
public class InventoryContoller {
	@Autowired
	InventoryService inventoryService;
	
	@Autowired
	Environment environment;
	
	@GetMapping("/getInventoryDetails/{productName}")
	public ResponseEntity<InventoryDTO> getProductInventoryDetails(@PathVariable String productName) {
		InventoryDTO inventoryDTO = inventoryService.getProductInventoryDetails(productName);
		String port = environment.getProperty("local.server.port");
		inventoryDTO.setEnvironment(port);
		return new ResponseEntity<InventoryDTO>(inventoryDTO, HttpStatus.OK);
	}
	
	@PostMapping("/save/inventory/details")
	public ResponseEntity<InventoryDTO> saveInventoryDetails(@RequestBody InventoryDTO inventoryDetails) {
		InventoryDTO inventoryDTO = inventoryService.saveInventoryDetails(inventoryDetails);
		return new ResponseEntity<InventoryDTO>(inventoryDTO, HttpStatus.CREATED);
	}
}
