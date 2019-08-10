import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {

	public static void main(String[] args) throws IOException {
		System.out.println(System.getProperty("user.dir"));
		Properties p = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"//src//Config//Staff.properties");
		p.load(ip);
		System.out.println(p.getProperty("name"));
		System.out.println(p.getProperty("age"));
		System.out.println(p.getProperty("weight"));
		
		
	}

}
