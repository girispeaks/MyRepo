package dummy;

import java.io.File;
import java.io.FileInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XLMFunction {

	public static Element xmlData(String object) throws Exception{
		File f=new File("C:\\Users\\gramakrishn6\\Desktop\\new.xml");
		FileInputStream ip=new FileInputStream(f);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    DocumentBuilder db = dbf.newDocumentBuilder();
	    Document document = db.parse(ip);// same xml comments as above.
	        XPathFactory xpf = XPathFactory.newInstance();
	        XPath xpath = xpf.newXPath();
	        Element userElement = (Element) xpath.evaluate("/schema/"+object+"", document,
	            XPathConstants.NODE);	        
	        return userElement;
	}	
}
