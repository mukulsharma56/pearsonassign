package com.te.pearsonassignement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.te.pearsonassignement.dto.Store;
import com.te.pearsonassignement.service.StoreServiceInterface;

@RestController
public class StoreController {
	
	@Autowired
	private StoreServiceInterface service;
	
	@GetMapping("/getStoreById/{storeId}")
	public ResponseEntity getStoreById(@PathVariable String storeId) {
		Store storeById = service.getStoreById(storeId);
		if(storeById!=null)
			return new ResponseEntity(storeById,HttpStatus.OK);
		else
			return new ResponseEntity("Data not found",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/getStores/{condition}")
	public ResponseEntity getStoresByCity(@PathVariable String condition) {
		List<Store> storesByCity = service.getStores(condition);
		if(storesByCity.size()>0) {
			return new ResponseEntity(storesByCity,HttpStatus.OK);
		}
		else {
			return new ResponseEntity("Based on City no stores is present",HttpStatus.NOT_FOUND);
		}
	}

}
