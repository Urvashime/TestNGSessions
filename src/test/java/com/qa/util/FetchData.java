package com.qa.util;

//data collection from excel to java
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

	public class FetchData  {
		/**
		 * this will be a class that is doing similar task as XLs_Reader and reads excel files and gets data[][] thru its method
		 */
	  static Workbook book;
	  static Sheet sheet;
	  public static String TESTDATA_SHEETPATH="/Users/urvashimehta/eclipse-workspace/TestNGSessions/src/test/java/com/excelSheet/LoginDataUserPassword.xlsx";
	  
		public static Object[][] getTestData(String sheetnm) {
			FileInputStream file=null;
			try {
			file = new FileInputStream(TESTDATA_SHEETPATH);
			}catch(FileNotFoundException e)
			{e.printStackTrace();}
			
		    try {
		    	book = WorkbookFactory.create(file);
		    //}catch(InvalidFormatException i)
		    //{
		    //	i.printStackTrace();
		    }catch(IOException e)
			{e.printStackTrace();}
		    sheet = book.getSheet(sheetnm);
		    Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		    //System.out.println("Row:  "+sheet.getLastRowNum()+"  Columncount: "+sheet.getRow(0).getLastCellNum());
		   //sheet.getLastRowNum()
		    int gcount = 2;
		    System.out.println("Rowcount "+sheet.getLastRowNum());
		    System.out.println("columns "+sheet.getRow(0).getLastCellNum());
		    for(int i = 0,rowcount = 2; rowcount <= sheet.getLastRowNum();i++,rowcount++) //less than 9 
		    {
		    	
		    	if((sheet.getRow(rowcount).getCell(0).toString()).equals(""))//rowcount>sheet.getLastRowNum()||
		    		continue;
		    	for(int j = 0; j < sheet.getRow(2).getLastCellNum();j++) //sheet.getRow(0).getLastCellNum()
			    {
		    	  	
			      data[i][j]=sheet.getRow(rowcount).getCell(j).toString();
			      System.out.println("data "+i+" : "+data[i][j]);
			      
			    }
		    	
		    }
		    return data;
	}//getTestData

}//class
