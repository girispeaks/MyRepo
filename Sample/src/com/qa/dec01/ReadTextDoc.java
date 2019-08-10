package com.qa.dec01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadTextDoc {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*FileReader file=new FileReader("C:\\Users\\gramakrishn6\\Desktop\\temp.txt");
		BufferedReader text=new BufferedReader(file);
		//System.out.println(text.readLine());
		while(!(text.readLine()==null))
			System.out.println(text.readLine());*/
		
		FileWriter f=new FileWriter("C:\\Users\\gramakrishn6\\Desktop\\tump.txt");
		BufferedWriter bw=new BufferedWriter(f);
		bw.write("Writing from code");
		bw.flush();
	}

}
