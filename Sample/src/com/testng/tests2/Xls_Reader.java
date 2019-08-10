package com.testng.tests2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xls_Reader {
	XSSFWorkbook wb;
	XSSFSheet st;
	XSSFRow rw;
	XSSFCell cl;
	File f;
	public Xls_Reader(String path) throws Exception{
		//f=new File(path);
		FileInputStream ip=new FileInputStream(path);
		wb=new XSSFWorkbook(ip);
	}
	
	public int getRowCnt(int index){
		st=wb.getSheetAt(index);
		return st.getLastRowNum()+1;
	}
	
	public int getRowCnt(String sheetName){
		st=wb.getSheet(sheetName);
		return st.getLastRowNum()+1;
	}
	
	public int getColCnt(int index, int rowNum){
		if(rowNum<=0)
			return -1;
		st=wb.getSheetAt(index);
		rw=st.getRow(rowNum-1);
		return rw.getLastCellNum();
	}
	
	public int getColCnt(String sheetName, int rowNum){
		if(rowNum<=0)
			return -1;
		st=wb.getSheet(sheetName);
		rw=st.getRow(rowNum-1);
		return rw.getLastCellNum();
	}
	
	public String getCellValue(int index, int rwNm, int clNm){
		st=wb.getSheetAt(index);
		if(rwNm<=0)
			return "";
		rw=st.getRow(rwNm-1);
		if(rw==null)
			return "";
		if(clNm<0)
			return "";
		cl=rw.getCell(clNm);
		if(cl==null)
			return "";
		if(cl.getCellTypeEnum()==CellType.BLANK)
			return "";
		else if(cl.getCellTypeEnum()==CellType.STRING)
			return cl.getStringCellValue();
		else if(cl.getCellTypeEnum()==CellType.BOOLEAN)
			return String.valueOf(cl.getBooleanCellValue());
		else if(cl.getCellTypeEnum()==CellType.NUMERIC)
			return String.valueOf(cl.getNumericCellValue());
		else 
			return "";		
	}
	
	public void writeCell(int index, int row, int cell) throws Exception{
		st=wb.getSheetAt(index);
		rw=st.getRow(row-1);
		cl=rw.createCell(cell);
		cl.setCellValue("Pass");
		FileOutputStream op=new FileOutputStream(f);
		wb.write(op);	
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Xls_Reader xls=new Xls_Reader("C:\\Users\\gramakrishn6\\Desktop\\Test1.xlsx");
		System.out.println("Total rows "+xls.getRowCnt(0));
		System.out.println("Total columns "+xls.getColCnt(0, 1));
		for(int i=1;i<=xls.getRowCnt(0);i++){
			for(int j=0;j<xls.getColCnt(0, 1);j++){
				System.out.print(xls.getCellValue(0, i, j)+" ");
			}
			System.out.println();
		}
		xls.writeCell(0, 2, 3);
	}
		

}
