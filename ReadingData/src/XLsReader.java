import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.xssf.usermodel.XSSFRow;
 
public class XLsReader {
      public File f;
      public FileInputStream ip;
      public XSSFWorkbook wb;
      public XSSFSheet st;
      public XSSFRow row;
      public XSSFCell cell;
      public XLsReader(String path) throws Exception{
            f=new File(path);
            ip=new FileInputStream(f);
            wb=new XSSFWorkbook(ip);
      }
     
      public int getRowCnt(String sheetName){
            int index=0;
            int rowcnt=0;
            index=wb.getSheetIndex(sheetName);
            st=wb.getSheetAt(index);
            rowcnt=st.getLastRowNum()+1;
            return rowcnt;
      }
     
      public int getRowCnt(int sheetIndex){
            int rowcnt=0;
            st=wb.getSheetAt(sheetIndex);
            rowcnt=st.getLastRowNum()+1;
            return rowcnt;
      }
     
      public int getColumnCount(String sheetName, int rowNum){
            int index=0;
            int colcnt=0;
            index=wb.getSheetIndex(sheetName);
            st=wb.getSheetAt(index);
            row=st.getRow(rowNum-1);
            colcnt=row.getLastCellNum();
            return colcnt;
      }
     
      public int getColumnCount(int sheetIndex, int row){
            int colcnt=0;
            st=wb.getSheetAt(sheetIndex);
            colcnt=st.getRow(row).getLastCellNum();
            return colcnt;
      }
     
      public String getCellData(String sheetName, int rwnum, String clName){
            int index=0;
            int col_length=0;
            int colnum=0;
            index=wb.getSheetIndex(sheetName);
            st=wb.getSheetAt(index);
            row=st.getRow(rwnum);
            col_length=row.getLastCellNum();
            //get column number based on column name
            for(int i=0;i<col_length;i++){
                  if(row.getCell(i).getStringCellValue().trim()==clName.trim())
                        colnum=i;
            }
            row=st.getRow(rwnum-1);
            if(row==null)
                  return "";
            cell=row.getCell(colnum);
            if(cell==null)
                  return "";
            if(cell.getCellType()==Cell.CELL_TYPE_STRING)
                  return cell.getStringCellValue();
            else if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
                  return "";
            else
                  return  String.valueOf(cell.getBooleanCellValue());
           
      }
     
      public String getCellData(String sheetName, int rwnum, int clnum){
            int index=0;
            index=wb.getSheetIndex(sheetName);
            st=wb.getSheetAt(index);
 
            row=st.getRow(rwnum-1);
            if(row==null)
                  return "";
            cell=row.getCell(clnum);
            if(cell==null)
                  return "";
            if(cell.getCellType()==Cell.CELL_TYPE_STRING)
                  return cell.getStringCellValue();
            else if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
                  return "";
            else
                  return  String.valueOf(cell.getBooleanCellValue());        
      }
}