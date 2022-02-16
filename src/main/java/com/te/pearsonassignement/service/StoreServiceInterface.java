package com.te.pearsonassignement.service;

import java.util.List;

import com.te.pearsonassignement.dto.Store;

public interface StoreServiceInterface {

	public Store getStoreById(String id);
	public List<Store> getStores(String condition);
	
}
