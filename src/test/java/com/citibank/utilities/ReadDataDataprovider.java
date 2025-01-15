package com.citibank.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class ReadDataDataprovider {

	String filepath="./TestData/Guru99LoginData.xlsx";
	
	@DataProvider
	public String[][] TC001_TestData() throws IOException {
		String[][] data=ReadDataFromExcel.getData(filepath, "TC001");
		return data;
	}
	
	@DataProvider
	public String[][] TC002_TestData() throws IOException {
		String[][] data=ReadDataFromExcel.getData(filepath, "TC002");
		return data;
	}
	
	@DataProvider
	public String[][] TC003_TestData() throws IOException {
		String[][] data=ReadDataFromExcel.getData(filepath, "TC003");
		return data;
	}
	
	@DataProvider
	public String[][] TC005_TestData() throws IOException {
		String[][] data=ReadDataFromExcel.getData(filepath, "TC005");
		return data;
	}
	
	@DataProvider
	public String[][] TC006_TestData() throws IOException {
		String[][] data=ReadDataFromExcel.getData(filepath, "TC001");
		return data;
	}
	

}
