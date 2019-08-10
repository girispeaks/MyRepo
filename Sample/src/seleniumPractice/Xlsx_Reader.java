package seleniumPractice;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xlsx_Reader {
	XSSFWorkbook wb=null;
	XSSFSheet st=null;
	XSSFRow rw=null;
	XSSFCell col=null;
	public Xlsx_Reader(String path) throws Exception{
		File f=new File(path);
		FileInputStream ip=new FileInputStream(f);
		wb=new XSSFWorkbook(ip);
	}

	public int getRowCnt(String sheetName){
		st=wb.getSheet(sheetName);
		return st.getLastRowNum()+1;
		
	}
	
	public int getRowCnt(int index){
		st=wb.getSheetAt(index);
		return st.getLastRowNum()+1;
	}
	
	public int getCellCnt(String sheetName, int rowNum){
		st=wb.getSheet(sheetName);
		return st.getRow(rowNum-1).getLastCellNum();
	}
	
	public int getCellCnt(int index, int rowNum){
		st=wb.getSheetAt(index);
		return st.getRow(rowNum-1).getLastCellNum();
	}
	
	public String getCellValue(String sheetName, int rowNum, int cellNum){
		st=wb.getSheet(sheetName);
		if(rowNum<=0)
			return "Invalid row number";
		if(cellNum<0)
			return "Invalid col number";
		rw=st.getRow(rowNum-1);
		if(rw==null)
			return "";
		col=rw.getCell(cellNum);
		if(col==null)
			return "";
		
		if(col.getCellTypeEnum()==CellType.STRING)
			return col.getStringCellValue();
		else if(col.getCellTypeEnum()==CellType.BLANK)
			return "";
		else if(col.getCellTypeEnum()==CellType.NUMERIC)
			return Double.toString(col.getNumericCellValue());
		else
			return Boolean.toString(col.getBooleanCellValue());
	}
	
	public static void main(String[] args) throws Exception{
		Xlsx_Reader reader= new Xlsx_Reader("C:\\Users\\gramakrishn6\\Desktop\\Test.xlsx");
		System.out.println("Total rows "+reader.getRowCnt("Data"));
		System.out.println("Total cells "+reader.getCellCnt("Data",1));
		System.out.println("Cell value is "+reader.getCellValue("Data", 1, 1));
		for(int i=1;i<=reader.getRowCnt("Data");i++){
			for(int j=0;j<reader.getCellCnt("Data", 1);j++){
				System.out.print(reader.getCellValue("Data", i, j)+" ");
			}
		System.out.println();
		}
	}
}
