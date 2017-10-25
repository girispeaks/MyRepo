package dummy;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Dummy2 {
	static WebDriver driver=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[] str1={"Banana - Yelakki 1 kg","Cauliflower 1 pc","Ladies Finger 1 kg","Lemon 1 kg","Onion 1 kg"};
		//String str2="Banana";
		
		//for(int i=0;i<str1.length;i++){
		//	System.out.println((str2.contains(str1[i].split(" ")[0])));
		//		//System.out.println(str1[i]);
		//}
		/*String str1="Banana - Yelakki 1 kg (approx. 17 to...";
		String str2=str1.split("1")[0];
		System.out.println(str2.trim());*/
		/*System.setProperty("webdriver.gecko.driver", "C://Users//gramakrishn6//Desktop//Jars//geckodriver-v0.17.0-win64//geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("https://www.bigbasket.com/cl/fruits-vegetables/?nc=nb#!page=2");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		custWait(1);
		pageload();
		WebElement cartOnScreen=driver.findElement(By.xpath("//span[@id='totalNumberOfCartItems']"));
		System.out.println(cartOnScreen.getText());*/
		
		/*String[] str={"Bangalore","Goa","Kolar","Delhi","Bombay","Bangalore","Delhi"};
		//String city="Bangalore";
		int cnt=1;
		for(int i=0;i<str.length-1;i++){
			for(int j=i+1;j<str.length;j++){
				//System.out.println(str[i]+"--------------"+str[j]);
				if(str[i].equals(str[j])){
				cnt++;
				}
			}
			System.out.println("The city "+str[i]+" is repeated "+cnt+" times");
			cnt=1;
		}*/
		
//		custWait(2);
		
		System.out.println(System.getProperty("user.dir"));
	}
	
	public static void custWait(int sec){
		try
		{
		Thread.sleep(sec*1000);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void pageload(){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String state=(String) js.executeScript("return document.readyState");
		System.out.println("State "+state);
		while(!state.equals("complete")){
			System.out.println("State "+state);
			custWait(2);
			state=(String)js.executeScript("return document.readystate");
		}
	}

}
