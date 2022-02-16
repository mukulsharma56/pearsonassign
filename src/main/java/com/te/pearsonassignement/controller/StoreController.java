package com.te.pearsonassignement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.te.pearsonassignement.dto.Store;
import com.te.pearsonassignement.model.ResponseModel;
import com.te.pearsonassignement.service.StoreServiceInterface;

@RestController
public class StoreController {
	
	@Autowired
	private StoreServiceInterface service;
	
	@GetMapping("/getStoreById/{storeId}")
	public ResponseEntity<ResponseModel> getStoreById(@PathVariable String storeId) {
		Store store = service.getStoreById(storeId);
		if(store!=null)
			return new ResponseEntity<>(new ResponseModel(false, "Data Found", store),HttpStatus.OK);
		else
			return new ResponseEntity<>(new ResponseModel(true, "Data not found", null),HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/getStores/{condition}")
	public ResponseEntity<ResponseModel> getStoresByCity(@PathVariable String condition) {
		List<Store> storesByCity = service.getStores(condition);
		if(storesByCity.size()>0) {
			return new ResponseEntity<>(new ResponseModel(false, "Data Found", storesByCity),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(new  ResponseModel(true, "Data not found", null),HttpStatus.NOT_FOUND);
		}
	}

}
