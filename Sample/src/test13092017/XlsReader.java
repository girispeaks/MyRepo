package test13092017;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsReader {
	XSSFWorkbook wb=null;
	XSSFSheet st=null;
	XSSFRow rw=null;
	XSSFCell cell=null;
	public XlsReader() throws IOException{
		File f=new File("C:\\Users\\gramakrishn6\\Desktop\\Book1.xlsx");
		FileInputStream ip=new FileInputStream(f);
		wb=new XSSFWorkbook(ip);		
	}
	
	public int getRowCnt(String sheetName){
		st=wb.getSheet(sheetName);
		return st.getLastRowNum()+1;		
	}
	
	public int getRowCnt(int sheetIndex){
		st=wb.getSheetAt(sheetIndex);
		return st.getLastRowNum()+1;
	}
	
	public int getColCnt(String sheetName){
		st=wb.getSheet(sheetName);
		rw=st.getRow(0);
		return rw.getLastCellNum();
	}
	
	public int getColCnt(int sheetIndex){
		st=wb.getSheetAt(sheetIndex);
		rw=st.getRow(0);
		return rw.getLastCellNum();
	}
	
	public String getCellValue(String sheetName, int row, int col){
		try{
		st=wb.getSheet(sheetName);
		if(row<=0)
			return "Invalid row number";
		if(col<0)
			return "Invalid column number";
		rw=st.getRow(row-1);
		cell=rw.getCell(col);
		if(cell.getCellTypeEnum()==CellType.BLANK)
			return "";
		else if(cell.getCellTypeEnum()==CellType.NUMERIC)
			return String.valueOf(cell.getNumericCellValue());
		else if(cell.getCellTypeEnum()==CellType.BOOLEAN)
			return String.valueOf(cell.getBooleanCellValue());
		else {
			return cell.getStringCellValue();
		}
		}catch(Exception e){
			return e.getMessage();
		}
	}
	
	public String getCellValue(int SheetIndex, int row, int col){
		try{
		st=wb.getSheetAt(SheetIndex);
		if(row<=0)
			return "Invalid row number";
		if(col<0)
			return "Invalid column number";
		rw=st.getRow(row-1);
		cell=rw.getCell(col);
		if(cell.getCellTypeEnum()==CellType.BLANK)
			return "";
		else if(cell.getCellTypeEnum()==CellType.NUMERIC)
			return String.valueOf(cell.getNumericCellValue());
		else if(cell.getCellTypeEnum()==CellType.BOOLEAN)
			return String.valueOf(cell.getBooleanCellValue());
		else if(cell.getCellTypeEnum()==CellType.STRING){
			return cell.getStringCellValue();
		} else
			return "";
		}catch(Exception e){
			e.printStackTrace();
			return e.getMessage();
		}		
	}
	
	public String getCellValue(String sheetName, int row, String col){
		try{
		st=wb.getSheet(sheetName);
		rw=st.getRow(0);
		int colnum=0;
		for(int i=0;i<rw.getLastCellNum();i++){
			if(rw.getCell(i).getStringCellValue().equals(col)){
				colnum=i;
				break;
			}			
		}
		if(row<=0)
			return "Invalid row number";
		rw=st.getRow(row-1);
		cell=rw.getCell(colnum);
		if(cell.getCellTypeEnum()==CellType.BLANK)
			return "";
		else if(cell==null)
			return "";
		else if(cell.getCellTypeEnum()==CellType.NUMERIC)
			return String.valueOf(cell.getNumericCellValue());
		else if(cell.getCellTypeEnum()==CellType.BOOLEAN)
			return String.valueOf(cell.getBooleanCellValue());
		else {
			return cell.getStringCellValue();
		}
		}catch(Exception e){
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	public static void main(String[] args) throws Exception{
		XlsReader xls=new XlsReader();
/*		System.out.println("Row Count by sheet index "+xls.getRowCnt(1));
		System.out.println("Row Count by sheet name "+xls.getRowCnt("Two"));
		System.out.println("Column Count by sheet index "+xls.getColCnt(1));
		System.out.println("Column Count by sheet name "+xls.getColCnt("Two"));
		System.out.println(xls.getCellValue("Two", 2, 1));
		System.out.println(xls.getCellValue(1, 2, 1));*/
		System.out.println(xls.getRowCnt(1));
		for(int i=1;i<=xls.getRowCnt(0);i++){
			for(int j=0;j<xls.getColCnt(0);j++){
				System.out.print(xls.getCellValue(1, i, j)+" ");
			}
			System.out.println();
		}
	}
}
