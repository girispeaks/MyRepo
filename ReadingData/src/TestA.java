import java.util.Hashtable;

import org.testng.annotations.DataProvider;

public class TestA {
	
	@org.testng.annotations.Test(dataProvider="getData")
	public static void Test(Hashtable<String, String> data){
		//System.out.println(data.get("Runmode")+"---"+data.get("Col1")+"---"+data.get("Col2")+"---"+data.get("Col3"));;
		
	}
	
	@DataProvider
	public Object[][] getData() throws Exception{
		
		XLsReader xls=new XLsReader("//Users//girishr//Documents//workspace//ddf//data.xlsx");
		String testCaseName="TestC";
		int testStartRowNum=1;
		while(!xls.getCellData("Data", testStartRowNum, 0).trim().equals(testCaseName.trim())){
			testStartRowNum++;
		}
		System.out.println("Test row starts from "+testStartRowNum);
		int colStartRowNum=testStartRowNum+1;
		int dataStartRowNum=testStartRowNum+2;
		//calculate the number of rows 
		int rows=0;
		while(!xls.getCellData("Data", dataStartRowNum+rows, 0).equals("")){
			rows++;		
		}
		System.out.println("The total number of rows for TestB is "+rows);
		//calculate the number of columns
		int cols=xls.getColumnCount("Data", colStartRowNum);
		System.out.println("Total columns are "+cols);
		Object[][] data=new Object[rows][1];
		Hashtable<String, String> table=null;
		//Reading the data
		int datarow=0;
		for(int i=dataStartRowNum;i<dataStartRowNum+rows;i++){
			table=new Hashtable<String, String>();
			for(int j=0;j<cols;j++){
				String col=xls.getCellData("Data", colStartRowNum, j);
				String val = xls.getCellData("Data", i, j);
				//System.out.print(data[datarow][j]+" ");
				table.put(col, val);
			}
			System.out.println();
			data[datarow][0]=table;
			datarow++;
		}	
		return data;	
	}
}
