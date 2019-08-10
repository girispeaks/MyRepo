package com.qa.dec01;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLS_Reader {
	XSSFWorkbook wb;
	XSSFSheet st;
	Row rw;
	Cell cl;
	public XLS_Reader(String path) throws Exception{
		File f=new File(path);
		FileInputStream ip=new FileInputStream(f);
		wb=new XSSFWorkbook(ip);
	}
	
	public int getRowCnt(int stIndex){
		st=wb.getSheetAt(stIndex);
		int totRows=st.getLastRowNum();
		return totRows+1;
	}
	
	public int getRowCnt(String stName){
		st=wb.getSheet(stName);
		int totRows=st.getLastRowNum()+1;
				return totRows;
	}
	
	public int getCellCnt(int stIndex, int rowNum) throws IncorrectRowException{
		if(rowNum<=0)
			throw new IncorrectRowException();
		st=wb.getSheetAt(stIndex);
		rw=st.getRow(rowNum-1);
		int totCells=rw.getLastCellNum();
		return totCells;
	}
	
	public int getCellCnt(String stName, int rowNum) throws IncorrectRowException{
		if(rowNum<=0)
			throw new IncorrectRowException();
		st=wb.getSheet(stName);
		rw=st.getRow(rowNum-1);
		int totCells=rw.getLastCellNum();
		return totCells;
	}
	
	public String getCellVal(int stIndex, int rwNum, int clNum){
		try{
		st=wb.getSheetAt(stIndex);
		if(rwNum<=0)
			throw new IncorrectRowException();
		if(clNum<0)
			throw new IncorrectCellException();
		rw=st.getRow(rwNum-1);
		if(rw==null)
			return "";
		cl=rw.getCell(clNum);
		if(cl==null)
			return "";
		if(cl.getCellTypeEnum()==CellType.BLANK)
		return "";
		else if(cl.getCellTypeEnum()==CellType.STRING)
			return cl.getStringCellValue();
		else if(cl.getCellTypeEnum()==CellType.NUMERIC)
			return String.valueOf(cl.getNumericCellValue());
		else if(cl.getCellTypeEnum()==CellType.BOOLEAN)
			return String.valueOf(cl.getBooleanCellValue());
		else return "";
		}catch(IncorrectRowException row){
			row.printStackTrace();
			return "Incorrect Row number";
		}catch(IncorrectCellException cell){
			cell.printStackTrace();
			return "Incorrect Row number";
		}
		catch(Exception e){
			e.printStackTrace();
			return "ERROR ENCOUNTERED";
		}		
	}
	
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		XLS_Reader xls=new XLS_Reader("C:\\Users\\gramakrishn6\\Desktop\\Test.xlsx");
		System.out.println(xls.getRowCnt(0));
		System.out.println(xls.getCellCnt(0, 1));
		System.out.println(xls.getCellVal(0, 1, 0));
	}

}

class IncorrectRowException extends Exception{
	public IncorrectRowException(){
		super();
	}
}

class IncorrectCellException extends Exception{
	public IncorrectCellException(){
		super();
	}
}
