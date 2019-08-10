package com.learnselenium.ddf.util;

import java.util.Hashtable;

public class DataUtil {
	public static Object[][] getInstance(Xls_Reader xlsx, String testName){
		Xls_Reader xls=xlsx;
		int i=1;
		while(!(xls.getCellValue("Data", i, 0).equals(testName))){
			i++;			
		}
		int testCaseHeaderRow=i+1;
		int testCaseDataRow=i+2;
		System.out.println("Test data start rows "+testCaseDataRow);
		i=testCaseDataRow;
		int j=0;
		while(!(xls.getCellValue("Data", i, 0).equals(""))){
			j++;
			i++;
		}
		int totalCols=xls.colCount(0, testCaseHeaderRow);
		Object[][] data=new Object[j][1];
		Hashtable<String, String> table=null;
		int x=0;
		for(int a=testCaseDataRow;a<(testCaseDataRow+j);a++){
			table=new Hashtable<String, String>();
			for(int b=0;b<totalCols;b++){
				table.put(xls.getCellValue("Data", testCaseHeaderRow, b), xls.getCellValue("Data", a, b));				
			}
			data[x][0]=table;
			x++;
		}
		return data;
	}	
	
	public static boolean testMode(Xls_Reader xls,String testName){
		String mode=null;
		int rowcnt=xls.rowCount(1);
		for(int i=1;i<rowcnt;i++){
			if(xls.getCellValue("TestCases", i, 0).equals(testName)){
				mode=xls.getCellValue("TestCases", i, 1);
				break;
			}
		}
		if(mode.equals("Y"))
			return true;
		else
			return false;		
	}	
}

