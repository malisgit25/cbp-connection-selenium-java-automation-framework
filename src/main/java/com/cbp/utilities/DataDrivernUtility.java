package com.cbp.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataDrivernUtility {
	
	public static Workbook book;
	public static Sheet sheet;
	public static String TestData_Sheet_Path = "C:/Users/zaliv/eclipse-workspace/CbpConnection/src/test/resources/Test Data/Logindata.xlsx";
	
	//this method should return two dimensional object array instead of void
	
	public static Object[][] getdata(String logindata)//pass the sheet name here as parameter 
	
	{
		FileInputStream file = null; 
		
		try{
			file =new FileInputStream(TestData_Sheet_Path);			
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
		try{
			book = WorkbookFactory.create(file);
			} catch (InvalidFormatException e){
				e.printStackTrace();
				}
				catch (IOException e){
					e.printStackTrace();
				}
			sheet = book.getSheet(logindata);
			
			Object[][]data =  new Object [sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			//System.out.println(sheet.getLastRowNum()+ "-----------");
			//sheet.getRow(0).getLastRowNumber
			//Read the excel data
			for (int i =0; i<sheet.getLastRowNum();i++)
				
				{
				for (int k=0;k<sheet.getRow(0).getLastCellNum();k++){
					
					data[i][k]=sheet.getRow(i+1).getCell(k).toString();					
			 				
				}	
			}
	
			return data;
			
				
			 
	}
 

}
