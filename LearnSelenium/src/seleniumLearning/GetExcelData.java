package seleniumLearning;

public class GetExcelData {
	
	static String path="//Users//girishr//Documents//workspace//LearnSelenium//src//seleniumLearning//Temp//TestData.xlsx";

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		XLReader data = new XLReader(GetExcelData.path);
		int rw = data.rowCount(0);
		System.out.println(rw);
		int cl = data.colCount(0,0);
		System.out.println(cl);
		String str;
		for (int i = 0; i < rw; i++) {
			for (int j = 0; j < cl; j++) {
				str = data.getData(0, i, j);
				System.out.print(str+" ");
			}
			System.out.println();
		}
		//Write data
		for(int a=0;a<rw;a++)
		data.writeExcel(GetExcelData.path, a,"Pass");
	}

}
