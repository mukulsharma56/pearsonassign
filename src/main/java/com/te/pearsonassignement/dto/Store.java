package com.te.pearsonassignement.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store implements Serializable {
	
	private String storeId;
	private String postCode;
	private String city;
	private String address;
	private Date openedDate;

	
	
}
