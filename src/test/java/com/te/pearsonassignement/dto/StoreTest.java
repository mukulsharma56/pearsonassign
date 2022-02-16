package com.te.pearsonassignement.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class StoreTest {
	/*
	 * String json=
	 * "{\"storeId\":\"str1\",\"postCode\":\"p1\",\"city\":\"bangalore\",\"address\":\"karnataka\",\"openedDate\":\"14021\"}";
	 * private ObjectMapper mapper=new ObjectMapper();
	 * 
	 * @Test void serializeTest() throws JsonProcessingException { // Store
	 * store=new Store("str1", "p1", "bangalore", "karnataka", "14021"); //
	 * System.out.println(mapper.writeValueAsString(store)); Store store =
	 * mapper.readValue(json, Store.class); String writeValueAsString =
	 * mapper.writeValueAsString(store); assertEquals(json, writeValueAsString); }
	 * 
	 * @Test void deSerializeTest() throws JsonMappingException,
	 * JsonProcessingException { Store store = mapper.readValue(json, Store.class);
	 * assertEquals("str1", store.getStoreId()); }
	 */
	String json="{\"storeId\":\"11\",\"postCode\":null,\"city\":null,\"address\":\"Amritsar\",\"openedDate\":null}";
	ObjectMapper mapper = new ObjectMapper();

	@Test
	void serializationTest() throws JsonProcessingException ,ParseException {
		Store store = new Store();
		store.setStoreId("11");
		store.setAddress("Amritsar");
		System.out.println(mapper.writeValueAsString(store));

		Store readValue=mapper.readValue(json, Store.class);
		assertEquals(json, mapper.writeValueAsString(readValue));
	}
	@Test
	void deserializationTest() throws JsonMappingException, JsonProcessingException {
		Store readvalue=mapper.readValue(json, Store.class);
		assertEquals(json, mapper.writeValueAsString(readvalue));
	}























}
