package com.te.pearsonassignement.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.te.pearsonassignement.dto.Store;
import com.te.pearsonassignement.model.ResponseModel;
import com.te.pearsonassignement.service.StoreServiceInterface;
//
//@ExtendWith(MockitoExtension.class)
//@SpringBootTest

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class StoreControllerTest {
	/*
	 * @MockBean private StoreServiceInterface service;
	 * 
	 * private MockMvc mockMvc;
	 * 
	 * @Autowired private WebApplicationContext context; private ObjectMapper mapper
	 * = new ObjectMapper();
	 * 
	 * @BeforeEach void setUp() throws Exception { mockMvc =
	 * MockMvcBuilders.webAppContextSetup(context).build(); }
	 * 
	 * @Test void testGetStoreById() throws UnsupportedEncodingException, Exception
	 * { Store store = new Store("str1", "p1", "bangalore", "karnataka", "14021");
	 * when(service.getStoreById(Mockito.anyString())).thenReturn(store);
	 * 
	 * String contentAsString =
	 * mockMvc.perform(get("/getStoreById/1")).andExpect(status().isOk()).andReturn(
	 * ) .getResponse().getContentAsString(); // System.out.println("result" +
	 * contentAsString); Store readValue = mapper.readValue(contentAsString,
	 * Store.class); assertEquals("str1", readValue.getStoreId());
	 * 
	 * }
	 * 
	 * // @Test // void testGetStoresByCity() { // fail("Not yet implemented"); // }
	 */

	@MockBean
	private StoreServiceInterface storeServiceInterface;

	private MockMvc mvc;

	@Autowired
	private	WebApplicationContext webApplicationContext;

	ObjectMapper mapper = new ObjectMapper(); 

	@BeforeEach
	public void setup() {
		mvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	void getStoreByIdTestApi1() throws Exception {
		Store store = new Store();
		Date d= new SimpleDateFormat("dd-mm-yyyy").parse("11-11-2000");
		store.setOpenedDate(d);
		store.setCity("Ambarsar");
		store.setStoreId("147");

		ResponseModel model = new ResponseModel(false, "Data Found", mapper.writeValueAsString(store));	

		when(storeServiceInterface.getStoreById(Mockito.anyString())).thenReturn(store);

		String contentasS=	mvc.perform(get("/getStoreById/147").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(mapper.writeValueAsString(store)))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		ResponseModel responseModel=mapper.readValue(contentasS , ResponseModel.class);

		assertEquals(model.getMessage(),responseModel.getMessage());
	}


	@Test
	void getStoresByCityTestApi2() throws JsonProcessingException, UnsupportedEncodingException, Exception {
		Store store = new Store();
		List<Store>list=new ArrayList<Store>();
		store.setCity("Amritsar");
		store.setStoreId("181");
		store.setPostCode("gfd252");
		list.add(store);
		
		ResponseModel model = new ResponseModel(false, "Data Found", list);	

		
		when(storeServiceInterface.getStores(Mockito.anyString())).thenReturn(list);

		String contentasS1=	mvc.perform(get("/getStores/city").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(mapper.writeValueAsString(store))).andExpect(status().isOk()).andReturn()
				.getResponse().getContentAsString();

		assertEquals(mapper.writeValueAsString(model), contentasS1);

	}


}
