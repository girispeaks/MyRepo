package test13092017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadTxtString {
	static String[] str;
	static String read;
	static ArrayList<String> arr;
	static int count=0;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileReader fr=new FileReader("C:\\Users\\gramakrishn6\\Desktop\\Test.txt");
		BufferedReader br=new BufferedReader(fr);
		arr=new ArrayList<String>();
		read=br.readLine();
		while(!(read==null)){
		str=read.split(" ");
		for(int i=0;i<str.length;i++)
			arr.add(str[i]);
		read=br.readLine();
		}
		System.out.println(arr.size());
		for(int i=0;i<arr.size();i++){
			count=0;
			for(int j=0;j<arr.size();j++){
				String str1=arr.get(i);
				String str2=arr.get(j);
				if(j<i&&(str1.equals(str2)))
						break;
				if(str1.trim().equals(str2.trim()))
					count=count+1;													
			}
			if(count==0)
				break;
			if(count>1)
			System.out.println(arr.get(i)+" occurs "+count+" times");	
		}			
	}
}
