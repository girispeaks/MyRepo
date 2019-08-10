package package05052017;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLReader {
	static XSSFWorkbook wb;
	XSSFSheet st;
	String path;
	public XLReader(String path) throws Exception{
		this.path=path;
		File f=new File(path);
		FileInputStream rd=new FileInputStream(f);
		wb=new XSSFWorkbook(rd);
	}
	
	//get total number of rows based on sheet index number
	public int rowNumber(int stNum ){
		st=wb.getSheetAt(stNum);
		int rownum=st.getLastRowNum()+1; //rows starts from 0
		return rownum;
	}
	
	//get total number of columns based on sheet index number
	public int colNumber(int stNum){
		st=wb.getSheetAt(stNum);
		int colnum=st.getRow(0).getLastCellNum();// column starts from 1
		return colnum;
	}
	
	//get total number of rows based on sheet name
	public int rowNumber(String sheet){
		st=wb.getSheet(sheet);
		int rownum=st.getLastRowNum()+1;
		return rownum;
	}
	
	//get total number of columns based on sheet name
	public int colNumber(String sheet){
		st=wb.getSheet(sheet);
		int colnum=st.getRow(0).getLastCellNum();
		return colnum;
	}
	
	//get cell value based on sheet index number
	public String cellValue(int sheetnum, int row, int cell){
		st=wb.getSheetAt(sheetnum);
		String str=st.getRow(row).getCell(cell).getStringCellValue();
		return str;	
	}
	
	//get cell value based on sheet name
	public String cellValue(String sheetName, int row, int cell){
		st=wb.getSheet(sheetName);
		String str=st.getRow(row).getCell(cell).getStringCellValue();
		return str;	
	}
	
	public void writeCellValue(String sheetName,int row, int cell, String value) throws Exception{
		st.getRow(row).createCell(cell).setCellValue(value);
		FileOutputStream op=new FileOutputStream(path);
		wb.write(op);
	}
	
	public static void main(String[] args) throws Exception{
		XLReader xl=new XLReader("//Users//girishr//Documents//workspace//LearnSelenium//Temp//WeBuy.xlsx");
		System.out.println("Total rows are "+xl.rowNumber(0));
		System.out.println("Total columns are "+xl.colNumber(0));
		String s=xl.cellValue("Products", 1, 1);
		System.out.println("Cell value is "+s);

	}
}
