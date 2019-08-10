package com.testng.tests2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class WordReadWrite {
	
	public void wordReader() throws Exception{
		FileReader frd=new FileReader("");
		BufferedReader bfr=new BufferedReader(frd);
		bfr.readLine();
		while(bfr.readLine()!=null)
			System.out.println(bfr.readLine());
		
	}
	
	public void wordWriter() throws Exception{
		FileWriter fwr=new FileWriter("");
		BufferedWriter bw=new BufferedWriter(fwr);
		bw.write("");
		bw.flush();
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
