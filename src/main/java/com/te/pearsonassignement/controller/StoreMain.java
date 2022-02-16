package com.te.pearsonassignement.controller;

import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;

import com.opencsv.CSVReader;

public class StoreMain {
	
	final static String filepath="C:\\Users\\Sachin\\Documents\\workspace-sts-3.9.12.RELEASE\\PearsonAssignement\\src\\main\\resources\\stores.csv";

	public static void readDataLineByLine(String file)
	{

		try {
			FileReader filereader = new FileReader(file);
			CSVReader csvReader = new CSVReader(filereader);
			String[] nextRecord;
			while ((nextRecord = csvReader.readNext()) != null) {
				for (String cell : nextRecord) {
					System.out.print(cell + "\t");
				}
				System.out.println();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		readDataLineByLine(filepath);
	}

}
