package com.learnselenium.ddf.util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xls_Reader {
	XSSFWorkbook wb=null;
	XSSFSheet st=null;
	XSSFRow row=null;
	XSSFCell cell=null;
	int totalrows=0;
	int totalcols=0;
	public Xls_Reader(String path){
		try{
		File f=new File(path);
		FileInputStream ip=new FileInputStream(f);
		wb=new XSSFWorkbook(ip);
		}catch(Exception e){
			System.out.println("Incorrect path");
		}
	}
	public int rowCount(int sheetIndex){
		st=wb.getSheetAt(sheetIndex);
		totalrows=st.getLastRowNum()+1;
		return totalrows;
	}
	public int rowCount(String sheetName){
		st=wb.getSheet(sheetName);
		totalrows=st.getLastRowNum()+1;
		return totalrows;
	}
	public int colCount(int sheetIndex, int rownum){
		if(rownum<=0)
			return -1;
		st=wb.getSheetAt(sheetIndex);
		row=st.getRow(rownum-1);
		totalcols=row.getLastCellNum();
		return totalcols;
	}
	public int colCount(String sheetName, int rownum){
		if(rownum<=0)
			return -1;
		st=wb.getSheet(sheetName);
		row=st.getRow(rownum-1);
		totalcols=row.getLastCellNum();
		return totalcols;
	}
	
	public String getCellValue(String sheetName, int rownum, String colName){
		try{
		int cellnum=0;
		st=wb.getSheet(sheetName);
		if(rownum<=0)
			return "";
		row=st.getRow(0);
		int colCnt=colCount(0, 1);
		System.out.println(colCnt);

		for(int i=0;i<colCnt;i++){

			if(row.getCell(i).getStringCellValue().equals(colName))
				cellnum=i;		
		}

		System.out.println("Cellnum is  "+row.getCell(1).getStringCellValue());
		row=st.getRow(rownum-1);
		if(row==null)
			return "";
		cell=row.getCell(cellnum);
		if(cell==null)
			return "";
		if(cell.getCellType()==Cell.CELL_TYPE_STRING)
			return cell.getStringCellValue();
		if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
			return "";
		if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC)
			return String.valueOf(cell.getNumericCellValue());
		if(cell.getCellType()==Cell.CELL_TYPE_BOOLEAN)
			return String.valueOf(cell.getBooleanCellValue());
		
		return "";
		}catch(Exception e){
			return "Value does not exists";
		}
		
	}
	
	public String getCellValue(String sheetName, int rowNum, int colNum){
		try{
		st=wb.getSheet(sheetName);
		if(rowNum<=0)
			return "";
		row=st.getRow(rowNum-1);
		if(row==null)
			return "";
		cell=row.getCell(colNum);
		if(cell==null)
			return "";
		if(cell.getCellType()==Cell.CELL_TYPE_STRING)
			return cell.getStringCellValue();
		if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
			return "";
		if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC)
			return String.valueOf(cell.getNumericCellValue());
		if(cell.getCellType()==Cell.CELL_TYPE_BOOLEAN)
			return String.valueOf(cell.getBooleanCellValue());
		
		return "";
		}catch(Exception e){
			return "Value does not exists";
		}
	}
}
