
public class Reading_Excel {

	public static void main(String[] args) {
		Xls_Reader dt = new Xls_Reader("//Users//girishr//Desktop//Selenium_Project//temp//Workbook1.xlsx");
		int i = dt.getRowCount("MyData");
		System.out.println(i);
		String g = dt.getCellData("MyData",0,2);
		System.out.println(g);
		dt.setCellData("MyData", "Name", 5, "Rakesh");
	}

}
