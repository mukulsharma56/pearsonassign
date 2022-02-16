package com.te.pearsonassignement.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.te.pearsonassignement.dto.Store;
import com.te.pearsonassignement.exception.CustomException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StoreImplService implements StoreServiceInterface {

	
//	final String filepath="C:\\Users\\Sachin\\Documents\\workspace-sts-3.9.12.RELEASE\\PearsonAssignement\\src\\main\\resources\\stores.csv";

	public Store getStoreById(String storeId) {
		int count = 0;
		Store store = new Store();
		List<String> list = new ArrayList<>();
		try (CSVReader csvReader = new CSVReader(new FileReader("src/main/resources/stores.csv"));) {
			String[] values = null;
			while ((values = csvReader.readNext()) != null) {
				list = Arrays.asList(values);
				if ((Arrays.asList(values).get(0)).equals(storeId)) {
					log.info("-----------get method-----------");
					Date date = new SimpleDateFormat("dd/MM/yyyy").parse(list.get(4));
					store.setStoreId(list.get(0));
					store.setPostCode(list.get(1));
					store.setCity(list.get(2));
					store.setAddress(list.get(3));
					store.setOpenedDate(date);
					count++;	
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (count > 0)
			return store;
		else
			throw new CustomException("Please provide proper Store Id!!");

	}
	@Override
	public List<Store> getStores(String field) {
		List<Store> list = new ArrayList<>();
		List<String> list1 = new ArrayList<>();
		try (CSVReader csvReader = new CSVReader(new FileReader("src/main/resources/stores.csv"));) {
			String[] values = null;
			while ((values = csvReader.readNext()) != null) {
				list1 = Arrays.asList(values);
				Store store = new Store();
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(list1.get(4));
					store.setStoreId(list1.get(0));
					store.setPostCode(list1.get(1));
					store.setCity(list1.get(2));
					store.setAddress(list1.get(3));
					store.setOpenedDate(date);
					list.add(store);
			}
		
			Comparator<Store>sort=null;
			if (field.equalsIgnoreCase("city")) {
				sort=(a , b)->{
					return a.getCity().compareTo(b.getCity());
				};
				
			}else if (field.equalsIgnoreCase("date")) {
				sort=(a ,b) ->{
					return a.getOpenedDate().compareTo(b.getOpenedDate());
				};
			}
			Collections.sort(list, sort);
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new CustomException("Provide proper City!!!");

	}
	
}
