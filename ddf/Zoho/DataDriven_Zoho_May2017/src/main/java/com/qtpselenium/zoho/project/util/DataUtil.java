package com.qtpselenium.zoho.project.util;

import java.util.Hashtable;

public class DataUtil {
	
	
	public static Object[][] getTestData(XLsReader xls, String testName) throws Exception{
		//xls=new XLsReader("//Users//girishr//Documents//workspace//ddf//data.xlsx");
		int testStartRowNum=1;
		while(!xls.getCellData("Data", testStartRowNum, 0).trim().equals(testName.trim())){
			testStartRowNum++;
		}
		System.out.println("Test row starts from "+testStartRowNum);
		int colStartRowNum=testStartRowNum+1;
		int dataStartRowNum=testStartRowNum+2;
		//calculate the number of rows 
		int rows=0;
		while(!xls.getCellData("Data", dataStartRowNum+rows, 0).equals("")){
			rows++;		
		}
		System.out.println("The total number of rows are "+rows);
		//calculate the number of columns
		int cols=xls.getColumnCount("Data", colStartRowNum);
		System.out.println("Total columns are "+cols);
		Object[][] data=new Object[rows][1];
		Hashtable<String, String> table=null;
		//Reading the data
		int datarow=0;
		for(int i=dataStartRowNum;i<dataStartRowNum+rows;i++){
			table=new Hashtable<String, String>();
			for(int j=0;j<cols;j++){
				String col=xls.getCellData("Data", colStartRowNum, j);
				String val = xls.getCellData("Data", i, j);
				//System.out.print(data[datarow][j]+" ");
				table.put(col, val);
			}
			System.out.println();
			data[datarow][0]=table;
			datarow++;
		}	
		return data;	
	}
	
	public static boolean isRunnable(XLsReader xls, String testName){
		int rows=xls.getRowCnt("TestCases");
		for(int i=2;i<=rows;i++){
			String cellData=xls.getCellData("TestCases", i, 0);
			if(cellData.equals(testName)){
				String runMode=xls.getCellData("TestCases", i, 1);	
				if(runMode.equals("Y"))
					return true;
				else
					return false;
			}
		}
		return false;// Incase my test case name is invalie
	}
}

