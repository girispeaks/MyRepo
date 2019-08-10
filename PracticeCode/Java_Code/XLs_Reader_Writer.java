package com.qa.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLs_Reader_Writer {
	XSSFWorkbook wb;
	XSSFSheet st;
	XSSFRow rw;
	XSSFCell cl;
	File f;
	public XLs_Reader_Writer() throws Exception{
		f=new File("C:\\Users\\gramakrishn6\\Desktop\\File.xlsx");
		FileInputStream ip=new FileInputStream(f);
		wb=new XSSFWorkbook(ip);
	}
	
	public int getRowCnt(int SheetIndex){
		st=wb.getSheetAt(SheetIndex);
		return st.getLastRowNum()+1;
	}
	
	public int getCellCnt(int SheetIndex, int rowNum){
		st=wb.getSheetAt(SheetIndex);
		rw=st.getRow(rowNum-1);
		return rw.getLastCellNum();
	}
	
	public String getCellValue(int SheetIndex, int rowNum, int cellNum){
		st=wb.getSheetAt(SheetIndex);
		if(rowNum<=0)
			return "";
		rw=st.getRow(rowNum-1);
		if(rw==null)
			return "";
		if(cellNum<0)
			return "";
		cl=rw.getCell(cellNum);
		if(cl==null)
			return "";
		if(cl.getCellTypeEnum()==CellType.BOOLEAN)
			return String.valueOf(cl.getBooleanCellValue());
		else if(cl.getCellTypeEnum()==CellType.NUMERIC)
			return String.valueOf(cl.getNumericCellValue());
		else if(cl.getCellTypeEnum()==CellType.STRING)
			return cl.getStringCellValue();
		else 
			return "";
	}
	
	public String getCellValue(int sheetIndex,int rowNum, String cellName){
		st=wb.getSheetAt(sheetIndex);
		rw=st.getRow(0);
		int clnt=rw.getLastCellNum();
		int cellNum=0;
		for(int i=0;i<clnt;i++){
			if(rw.getCell(i).getStringCellValue().equals(cellName)){
				cellNum=i;
				System.out.println("column num is "+i);
				break;
			} 
		}
		if(rowNum<=0)
			return "";
		rw=st.getRow(rowNum-1);
		if(rw==null)
			return "";
		cl=rw.getCell(cellNum);
		if(cl==null)
			return "";
		if(cl.getCellTypeEnum()==CellType.BLANK)
			return "";
		else if(cl.getCellTypeEnum()==CellType.BOOLEAN)
			return String.valueOf(cl.getBooleanCellValue());
		else if(cl.getCellTypeEnum()==CellType.NUMERIC)
			return String.valueOf(cl.getNumericCellValue());
		else if(cl.getCellTypeEnum()==CellType.STRING)
			return cl.getStringCellValue();
		else 
			return "";
	}
	
	public void writeCellValue(int sheetIndex, int rowNum, int colNum) throws Exception{
		st=wb.getSheetAt(sheetIndex);
		st.getRow(rowNum-1).createCell(colNum).setCellValue("True");
		FileOutputStream op=new FileOutputStream(f);
		wb.write(op);
	}
	
	public static void main(String[] args) throws Exception{
		XLs_Reader_Writer xls=new XLs_Reader_Writer();
		System.out.println("Total rows "+xls.getRowCnt(0));
		System.out.println("Total cells "+xls.getCellCnt(0, 1));
		System.out.println("Cell value is "+xls.getCellValue(0, 1, 0));
		System.out.println("Cell value with cell name is "+xls.getCellValue(0, 3, "Sheet2"));
		for(int i=1;i<=xls.getRowCnt(0);i++){
			for(int j=0;j<xls.getCellCnt(0, 1);j++){
				System.out.print(xls.getCellValue(0, i, j)+" ");
			}
			System.out.println();
		}
	}
}
