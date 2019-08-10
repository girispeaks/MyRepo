package test12092017;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTest {
	File f=null;
	XSSFWorkbook wb=null;
	XSSFSheet st=null;
	XSSFRow row=null;
	XSSFCell cell=null;
	public ExcelTest(String path){
		try{
		f=new File(path);
		FileInputStream ip=new FileInputStream(f);
		wb=new XSSFWorkbook(ip);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public int getRowCount(String sheetName){
	try{
	st=wb.getSheet(sheetName);
	int rowCnt=st.getLastRowNum()+1;
	return rowCnt;
	}catch(Exception e){
		e.printStackTrace();
		return -1;
		}
	}

	public int getRowCount(int sheetNum){
		try{
		st=wb.getSheetAt(sheetNum);
		int rowCnt=st.getLastRowNum()+1;
		return rowCnt;
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
	
	public int getColCount(String sheetName){
		try{
		st=wb.getSheet(sheetName);
		row=st.getRow(0);
		int colCnt=row.getLastCellNum();
		return colCnt;
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
	
	public int getColCount(int sheetNum){
		try{
		st=wb.getSheetAt(sheetNum);
		row=st.getRow(0);
		int colCnt=row.getLastCellNum();
		return colCnt;
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
	
	public String getCellValue(String sheetName, int rowNum, int colNum){
		try{
		st=wb.getSheet(sheetName);
		if(rowNum<=0||colNum<0)
			return "";
		if(rowNum>getRowCount(sheetName)||colNum>getColCount(sheetName))
			return "";
		row=st.getRow(rowNum-1);
		cell=row.getCell(colNum);
		if(cell.getCellTypeEnum()==CellType.BLANK)
			return "";
		else if(cell.getCellTypeEnum()==CellType.NUMERIC)
			return Double.toString(cell.getNumericCellValue());
		else if(cell.getCachedFormulaResultTypeEnum()==CellType.BOOLEAN)
			return Boolean.toString(cell.getBooleanCellValue());
		else if(cell.getCellTypeEnum()==CellType.STRING)
			return cell.getStringCellValue();
		else
			return "";
		}catch(Exception e){
			e.printStackTrace();
			return "Incorrect input data";
		}
	}
	
	public String getCellValue(int sheetIndex, int rowNum, int colNum){
		try{
		st=wb.getSheetAt(sheetIndex);
		if(rowNum<=0||colNum<0)
			return "";
		if(rowNum>getRowCount(sheetIndex)||colNum>getColCount(sheetIndex))
			return "";
		row=st.getRow(rowNum-1);
		cell=row.getCell(colNum);
		if(cell.getCellTypeEnum()==CellType.BLANK)
			return "";
		else if(cell.getCellTypeEnum()==CellType.NUMERIC)
			return Double.toString(cell.getNumericCellValue());
		else if(cell.getCellTypeEnum()==CellType.BOOLEAN)
			return Boolean.toString(cell.getBooleanCellValue());
		else if(cell.getCellTypeEnum()==CellType.STRING)
			return cell.getStringCellValue();
		else
			return "";
		}catch(Exception e){
			e.printStackTrace();
			return "Incorrect input data";
		}
	}
	
	public String getCellValue(String sheetName, int rowNum, String colName){
		try{
		st=wb.getSheet(sheetName);
		row=st.getRow(0);
		int cellNum=row.getLastCellNum();
		int i=0;
		for(i=0;i<cellNum;i++){
			if(row.getCell(i).getStringCellValue().trim().equals(colName))
				break;
		}
		int colNum=i;
		row=st.getRow(rowNum-1);
		cell=row.getCell(colNum);
		if(cell.getCellTypeEnum()==CellType.BLANK)
			return "";
		else if(cell.getCellTypeEnum()==CellType.NUMERIC)
			return Double.toString(cell.getNumericCellValue());
		else if(cell.getCachedFormulaResultTypeEnum()==CellType.BOOLEAN)
			return Boolean.toString(cell.getBooleanCellValue());
		else if(cell.getCellTypeEnum()==CellType.STRING)
			return cell.getStringCellValue();
		else
			return "";
		}catch(Exception e){
			e.printStackTrace();
			return "Incorrect input data";
		}
	}
	
	public void writeData(int sheetNum, int rowNum, int colNum){
		try{		
		st=wb.getSheetAt(sheetNum);
		row=st.getRow(rowNum-1);
		cell=row.createCell(colNum);
		cell.setCellValue("true");
		FileOutputStream op=new FileOutputStream(f);
		wb.write(op);		
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("File not found");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelTest xl=new ExcelTest("C:\\Users\\gramakrishn6\\Desktop\\Voice MDS V1.2.xlsx");
		/*System.out.println(xl.getRowCount(0));
		System.out.println(xl.getColCount(0));*/
		//System.out.println(xl.getCellValue(0, 1, 0));
		for(int i=1;i<=xl.getRowCount(1);i++){
			for(int j=0;j<xl.getColCount(1);j++){
				System.out.print(xl.getCellValue(0, i, j)+" ");
			}
			System.out.println();
		}
	//	xl.writeData(0, 1, 2);
	}
}
