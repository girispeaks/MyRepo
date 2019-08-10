package package05052017;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
 
 
public class BigBasket {
     
      @SuppressWarnings("rawtypes")
      public static void main(String[] args) throws Exception{
            XLReader data=new XLReader("//Users//girishr//Documents//workspace//LearnSelenium//Temp//bigBasket.xlsx");
            List<String> productsToBeAdded=new ArrayList<String>();
            Hashtable<String,String> productQuantityPair=new Hashtable<String,String>();
            int rowCnt=data.rowNumber("Shopping");
            System.out.println(rowCnt);
            for(int i=1;i<rowCnt;i++){
                  productsToBeAdded.add(data.cellValue("Shopping", i, 0));
                  productQuantityPair.put(data.cellValue("Shopping", i, 0),data.cellValue("Shopping", i, 1));
            }
            //Printing all products in ArrayList
            Iterator<String> it=productsToBeAdded.iterator();
            while(it.hasNext()){
                  String str=it.next();
                  System.out.println(str);
            }
            //Printing all quantities of a Product in Hashtable
            Set st=productQuantityPair.entrySet();
            Iterator itr=st.iterator();
            while(itr.hasNext()){
                  Map.Entry mp=(Map.Entry)itr.next();
                  System.out.println(mp.getKey()+"----"+mp.getValue());
            }
           
            System.setProperty("webdriver.gecko.driver", "//users//girishr//Downloads//geckodriver");
            WebDriver driver=new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            driver.get("https://www.bigbasket.com/");
            driver.findElement(By.xpath("//*[@id='city-select']")).clear();
            driver.findElement(By.xpath("//*[@id='city-select']")).sendKeys("Bangalore");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//ul[@id='ui-id-2']/li/a")).click();
            WebDriverWait wt=new WebDriverWait(driver,10);
            wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='navbar']/ul[1]/li[1]/a"))));
            //*[@id='ui-id-62']
            // Thread.sleep(2000);
            //driver.findElement(By.xpath("//*[@id='city-select']")).sendKeys(Keys.ENTER);
           // Actions act=new Actions(driver);
            //act.moveToElement(driver.findElement(By.xpath("//div[@id='navbar']/ul[1]/li[1]/a"))).build().perform();
            driver.findElement(By.xpath("//div[@id='navbar']/ul[1]/li[1]/a")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='navBarMegaNav']/li[1]/a")).click();
            wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("html/body/div[14]/div[3]/div[2]/div[2]/h2"))));
            //storing all products in a List
            List<WebElement> allProducts=driver.findElements(By.xpath("//div[@class='uiv2-shopping-lis-sku-cards']/ul/li/div[2]/span[2]/a"));
            //div[@class='uiv2-list-box-img-title']/span[2]/a
          //div[@class='uiv2-shopping-lis-sku-cards']/ul/li[not(contains(style,'display:none;'))]/div[2]/span[2]/a
            //uiv2-list-box-img-title
            System.out.println("All products size is "+allProducts.size());
            //Printing all product names
            for(int i=0;i<allProducts.size();i++){
                  System.out.println(allProducts.get(i).getText());
            }
            //storing all Add buttons in the page to a list
            List<WebElement> allButtons=driver.findElements(By.xpath("//div[@class='uiv2-add-to-basket']/a[1]"));
            System.out.println("All products button size is "+allButtons.size());
            for(int i=0;i<allButtons.size();i++)
            	System.out.println(allButtons.get(i).getText());
            List<WebElement> allQuantityTextBox=driver.findElements(By.xpath("//div[@class='uiv2-rate-count-btn']/input"));
            System.out.println("All products quantity field size is "+allQuantityTextBox.size());
            //Adding the product to Basket
            WebElement basketCount;
            String str;
            int actBasketCount=0;
            int expBasketCount;
           // System.out.println(allProducts.get(0).getText().split("\\n")[1]);
            System.out.println(productQuantityPair.get(allProducts.get(0).getText().split("\\n")[1]));
           for(int i=0;i<allProducts.size()-1;i++){
                  if(productsToBeAdded.contains(allProducts.get(i).getText().split("\\n")[1])){
                	    allQuantityTextBox.get(i).clear();
                        allQuantityTextBox.get(i).sendKeys(productQuantityPair.get(allProducts.get(i).getText().split("\\n")[1]));
                        Thread.sleep(2000);
                        allButtons.get(i).click();
                        Thread.sleep(2000);
                        actBasketCount++;
                        basketCount=driver.findElement(By.xpath("//*[@id='totalNumberOfCartItems']"));
                        str=basketCount.getText().split("\\s")[0];
                        expBasketCount=Integer.parseInt(str);
                        Assert.assertEquals(expBasketCount, actBasketCount);
                  }
            }    
            //checking the content of checkout
            //*[@id="navbar-main"]/div/div/div[4]/div/div[2]/div/ul/li[1]/div/div[3]/div/div[2]/span
            //*[@id="navbar-main"]/div/div/div[4]/div/div[2]/div/ul/li[2]/div/div[3]/div/div[2]/span*/
      }
}
