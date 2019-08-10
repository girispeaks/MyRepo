package test12092017;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xls_Reader {
	XSSFWorkbook wb = null;
	XSSFSheet st = null;
	XSSFRow rw = null;
	XSSFCell cl = null;
	File f = null;

	public Xls_Reader(String path) {
		try {
			f = new File(path);
			FileInputStream ip = new FileInputStream(f);
			wb = new XSSFWorkbook(ip);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int getrowNum(String sheetName) {
		st = wb.getSheet(sheetName);
		int rnum = st.getLastRowNum();
		return rnum + 1;
	}

	public int getrowNum(int sheetIndex) {
		st = wb.getSheetAt(sheetIndex);
		int rnum = st.getLastRowNum();
		return rnum + 1;
	}

	public int getcolNum(String sheetName, int rNumber) {
		if (rNumber <= 0)
			return -1;
		st = wb.getSheet(sheetName);
		int cnum = st.getRow(rNumber - 1).getLastCellNum();
		return cnum;
	}

	public int getcolNum(int sheetIndex, int rNumber) {
		if (rNumber <= 0)
			return -1;
		st = wb.getSheetAt(sheetIndex);
		int cnum = st.getRow(rNumber-1).getLastCellNum();
		return cnum;
	}

	public String getCellData(String sheetName, String colName, int rNumber) {
		try {
			if (rNumber <= 0)
				return "";
			int cNumber = 0;
			st = wb.getSheet(sheetName);
			rw = st.getRow(0);
			int totalCols = rw.getLastCellNum();
			for (int i = 0; i < totalCols; i++) {
				if (rw.getCell(i).getStringCellValue().equals(colName))
					cNumber = i;
			}

			rw = st.getRow(rNumber - 1);
			if (rw == null)
				return "";
			cl = rw.getCell(cNumber);
			if (cl == null)
				return "";
			if (cl.getCellTypeEnum() == CellType.BLANK)
				return "";
			else if (cl.getCellTypeEnum() == CellType.STRING)
				return cl.getStringCellValue();
			else if (cl.getCellTypeEnum() == CellType.NUMERIC)
				return String.valueOf(cl.getNumericCellValue());
			else
				return String.valueOf(cl.getBooleanCellValue());
		} catch (Exception e) {
			return "Error encountered";
		}

	}

	public String getCellData(String sheetName, int cNumber, int rNumber) {
		try {
			rw = st.getRow(rNumber - 1);
			if (rw == null)
				return "";
			cl = rw.getCell(cNumber);
			if (cl == null)
				return "";
			if (cl.getCellTypeEnum() == CellType.BLANK)
				return "";
			else if (cl.getCellTypeEnum() == CellType.STRING)
				return cl.getStringCellValue();
			else if (cl.getCellTypeEnum() == CellType.NUMERIC)
				return String.valueOf(cl.getNumericCellValue());
			else
				return String.valueOf(cl.getBooleanCellValue());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "Error encountered";
		}
	}

	public void writeCellData(String sheetName, int cNumber, int rNumber) throws Exception {
		st = wb.getSheet(sheetName);
		st.getRow(rNumber - 1).createCell(cNumber).setCellValue("True");
		FileOutputStream op = new FileOutputStream(f);
		wb.write(op);
	}

	public static void main(String[] args) {
		Xls_Reader xls = new Xls_Reader("C:\\Users\\gramakrishn6\\Desktop\\File.xlsx");
		System.out.println("Total rows based on index are " + xls.getrowNum(0));
		//System.out.println("Total rows based on name are " + xls.getrowNum("Data"));
		System.out.println("Total cells based on index are " + xls.getcolNum(0, 1));
		//System.out.println("Total cells based on name are " + xls.getcolNum("Data", 1));
		//System.out.println("Cell value based on index is " + xls.getCellData("Data", 1, 5));
		//System.out.println("Cell value based on column name is " + xls.getCellData(0, "UserName", 5));
		//for(int i=1;i<)
		for(int i=1;i<=xls.getrowNum(1);i++){
			for(int j=0;j<xls.getcolNum(0, 1);j++){
				System.out.print(xls.getCellData("Sheet1", i, j)+" ");
			}
			System.out.println();
		}
	}

	
}
