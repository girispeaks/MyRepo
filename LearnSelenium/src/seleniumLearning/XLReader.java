package seleniumLearning;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLReader {
	XSSFWorkbook wb;
	XSSFSheet st;
	int rowcnt;
	int colcnt;
	String str;
	public XLReader(String path) throws IOException{
		//try{
		File f=new File(path);
		FileInputStream ip=new FileInputStream(f);
		wb=new XSSFWorkbook(ip);
		//}catch(Exception e){
		//	System.out.println("Error");
		//}
	}
	
	//get row length
	public Integer rowCount(int sheetIndex){
		st=wb.getSheetAt(sheetIndex);
		rowcnt=st.getLastRowNum()+1;
		return rowcnt;
	}
	
	//get column length
	public Integer colCount(int sheetIndex, int rownumber){
		colcnt=st.getRow(rownumber).getLastCellNum();
		return colcnt;
	}
	
	//get data from excel
	public String getData(int sheetIndex, int row, int col){
		str=st.getRow(row).getCell(col).getStringCellValue();
		return str;
	}
	//write data into excel
	public void writeExcel(String path,int row,String status) throws IOException{
		st.getRow(row).createCell(2).setCellValue(status);
		FileOutputStream op=new FileOutputStream(path);
		wb.write(op);
		//wb.close();
	}

}
