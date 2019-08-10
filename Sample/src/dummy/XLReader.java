package dummy;

import java.io.File;
import java.io.FileInputStream;
import java.util.Hashtable;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class XLReader {
	XSSFWorkbook wb=null;
	XSSFSheet st=null;
	XSSFRow rw=null;
	XSSFCell col=null;
	public XLReader(String path){
		File f=new File(path);
		try{
		FileInputStream ip=new FileInputStream(f);
		wb=new XSSFWorkbook(ip);
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	public int getRowNum(int sheetNum){
		st=wb.getSheetAt(sheetNum);
		return (st.getLastRowNum()+1);
	}
	
	public int getRowNum(String sheetName){
		st=wb.getSheet(sheetName);
		return (st.getLastRowNum()+1);
	}
	
	public int getColNum(int sheetNum, int rNum){
		st=wb.getSheetAt(sheetNum);
		return(st.getRow(rNum-1).getLastCellNum());
	}
	
	public int getColNum(String sheetName, int rNum){
		st=wb.getSheet(sheetName);
		return(st.getRow(rNum).getLastCellNum());
	}
	
	public String getCellValue(String sheetName, int rNum, int cNum){
		//try{
		st=wb.getSheet(sheetName);
		if(rNum<=0)
			return "";
		if(cNum<0)
			return "";
		rw=st.getRow(rNum-1);
		if(rw==null)
			return "";
		col=rw.getCell(cNum);
		if(col==null)
			return "";
		//CellType type=col.getCellTypeEnum();
		//String str=type.toString();
		//System.out.println(type.toString());
		

		 if(col.getCellTypeEnum()==CellType.STRING)
			return col.getStringCellValue();
		 else if(col.getCellTypeEnum()==CellType.BLANK)
			return "";
		else if(col.getCellTypeEnum()==CellType.NUMERIC)
			return String.valueOf(col.getNumericCellValue());
		else if(col.getCellTypeEnum()==CellType.BOOLEAN)
			return String.valueOf(col.getBooleanCellValue());
		else 
			return "";
		//}catch(Exception e){
		//	return "Error Encountered";
		//}
	}
	
	public static void main(String[] args){
		XLReader rd=new XLReader("C:\\Users\\gramakrishn6\\Desktop\\Test1.xlsx");
		System.out.println(rd.getRowNum(0));
		System.out.println(rd.getColNum(0, 1));
		//System.out.println(rd.getCellValue("Data", 2, 0));
		for(int i=1;i<=rd.getRowNum(0);i++){
			for(int j=0;j<rd.getColNum(0, 1);j++){
				System.out.print(rd.getCellValue("Data", i, j)+" ");
			}
			System.out.println();
		}
		//System.out.println(rd.getCellValue(0, 5, 1,"Quantity"));
	}
	
	public String getCellValue(int sheetNum, int rNum, int hdRowNum,String colName){
		try
		{
		st=wb.getSheetAt(0);
		if(rNum<=0)
			return "";
		rw=st.getRow(hdRowNum-1);
		int colNum=0;
		System.out.println("passed value is "+colName);
		for(int i=0;i<rw.getLastCellNum();i++){
			if(rw.getCell(i).getStringCellValue().trim().equals(colName)){
			colNum=i;
			break;
			}
		}
		rw=st.getRow(rNum-1);
		if(rw==null)
			return "";
		col=rw.getCell(colNum);
		if(col==null)
			return "";
		if(col.getCellTypeEnum()==CellType.BLANK)
			return "Blank Cell";
		else if(col.getCellTypeEnum()==CellType.STRING)
			return col.getStringCellValue();
		else if(col.getCellTypeEnum()==CellType.NUMERIC)
			return String.valueOf(col.getNumericCellValue());
		else 
			return String.valueOf(col.getBooleanCellValue());
		}catch(Exception e){
			return "Error Encountered";
		}
	}
	
	/*@Test(dataProvider="data")
	public void shop(Hashtable<String, String> table){
		System.out.println(table.get("Products")+"--------"+table.get("Quantity"));
	}
	
	@DataProvider
	public Object[][] data(){
		XLReader xls=new XLReader("C:\\Users\\gramakrishn6\\Desktop\\Test.xlsx");
		int tRwNum=xls.getRowNum(0);
		int tClNum=xls.getColNum(0, 1);
		Object[][] test=new Object[tRwNum-1][1];
		int k=0;
		Hashtable<String, String> st=null;
		for(int i=2;i<=tRwNum;i++){
			st=new Hashtable<String, String>();
			for(int j=0;j<tClNum;j++){
				st.put(xls.getCellValue("Data", 1, j), xls.getCellValue("Data", i, j));
				test[k][0]=st;
				k++;
			}
		}
		return test;
	}*/
}
