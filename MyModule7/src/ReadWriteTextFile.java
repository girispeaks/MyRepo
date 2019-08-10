import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWriteTextFile {

	public static void main(String[] args) throws IOException {
		File f = new File("//Users//girishr//Desktop//Selenium_Project//temp.txt");
		f.createNewFile();
		//Write into file
		/*FileWriter w = new FileWriter("//Users//girishr//Desktop//Selenium_Project//temp.txt");
		BufferedWriter out = new BufferedWriter(w);
		out.write("My First program");
		out.newLine();
		out.write("Hello World");
		out.flush();*/
		//Read from file
		FileReader r = new FileReader("//Users//girishr//Desktop//Selenium_Project//temp.txt");
		BufferedReader bfr = new BufferedReader(r);
		//System.out.println(bfr.readLine());
		//System.out.println(bfr.readLine());
		String i;
		
		while ((i=bfr.readLine())!=null)
		System.out.println(i);
	}
}
