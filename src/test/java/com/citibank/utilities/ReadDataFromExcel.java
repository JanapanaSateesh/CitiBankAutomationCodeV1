package com.citibank.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

public static String[][] getData(String filepath, String sheetname) throws IOException {
		
		File file=new File(filepath);
		FileInputStream fi=new FileInputStream(file);
		
		XSSFWorkbook workbook=new XSSFWorkbook(fi);
		XSSFSheet sheet=workbook.getSheet(sheetname);
		int rows=sheet.getPhysicalNumberOfRows(); //2
		int cols=sheet.getRow(0).getLastCellNum(); //2
		
		System.out.println(rows);
		System.out.println(cols);
		
		String[][] data=new String[rows-1][cols]; //[3][5]
		
		for(int i=0;i<rows-1;i++) //0<1
		{
			for(int j=0;j<cols;j++) //0<2
			{
				DataFormatter df=new DataFormatter();
				data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
				//System.out.println(data[i][j]);
			}
		}
		return data;
		
		
		
	}
}
