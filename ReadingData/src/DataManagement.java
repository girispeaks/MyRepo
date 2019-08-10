

public class DataManagement {
	static XLsReader xls;

	public static void main(String[] args) throws Exception {
		xls=new XLsReader("//Users//girishr//Documents//workspace//ddf//data.xlsx");
		String testCaseName="TestA";
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
		int col=xls.getColumnCount("Data", colStartRowNum);
		System.out.println("Total columns are "+col);
		
		//Reading the data
		for(int i=dataStartRowNum;i<dataStartRowNum+rows;i++){
			for(int j=0;j<col;j++){
				String str = xls.getCellData("Data", i, j);
				System.out.print(str+" ");
			}
			System.out.println();
		}
	}

}
	