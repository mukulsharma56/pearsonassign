package com.te.pearsonassignement.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.opencsv.CSVReader;
import com.te.pearsonassignement.dto.Store;

@ExtendWith(MockitoExtension.class)
class StoreImplServiceTest {
	CSVReader reader;

	public StoreImplServiceTest() {
		reader=	mock(CSVReader.class);
	}

	@InjectMocks
	private StoreImplService service;

	@Test
	void testGetStoreById() throws Exception{
		Store store=new Store();
		store.setAddress("sultanwind");
		store.setCity("amritsar");
		store.setPostCode("852dfg");
		store.setStoreId("15773203-9ce4-4ee1-9373-543b940fa293");
		assertEquals("15773203-9ce4-4ee1-9373-543b940fa293", service.getStoreById(store.getStoreId()).getStoreId());

	}

	@Test 
	void testGetStoresByCity(){ 
		Store store=new Store();
//		Date d= new SimpleDateFormat("dd-mm-yyyy").parse("11-11-2000");			
		store.setAddress("sultanwind");
		store.setCity("amritsar");
		store.setPostCode("852dfg");
		store.setStoreId("15773203-9ce4-4ee1-9373-543b940fa293");
//		store.setOpenedDate(d);
		List<Store>list=new ArrayList<>();
		list.add(store);
		assertEquals("15773203-9ce4-4ee1-9373-543b940fa293", service.getStores("city").get(0).getStoreId());
	}


}
