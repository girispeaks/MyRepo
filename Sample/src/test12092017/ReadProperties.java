package test12092017;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileInputStream ip=new FileInputStream("C:\\Users\\gramakrishn6\\workspace\\Sample\\src\\test12092017\\Test.properties");
		Properties p=new Properties();		
		p.load(ip);
		System.out.println(p.getProperty("browser"));
	}
}
