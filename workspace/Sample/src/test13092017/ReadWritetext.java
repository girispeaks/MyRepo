package test13092017;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class ReadWritetext {
	static String[] str;
	static String str1;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//Reading
		FileReader fr=new FileReader("C:\\Users\\gramakrishn6\\Desktop\\Test.txt");
		BufferedReader bfr=new BufferedReader(fr);
		str1=bfr.readLine();
		int i=0;
		while(!(str1==null)){
			str=str1.split(" ");
			//System.out.println(str.length);
			str1=bfr.readLine();
			i=i+str.length;	
		}
		System.out.println("Total number of string in the file is "+i);
		
		//Writing
		FileWriter fw=new FileWriter("C:\\Users\\gramakrishn6\\Desktop\\Test.txt");
		BufferedWriter bw=new BufferedWriter(fw);
		bw.append('c');
		bw.newLine();
		bw.write("Test line45");
		bw.flush();
		
	}
		
}
