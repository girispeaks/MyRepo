package package05052017;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class purchaseProducts {
	@Test
	public static void BuyProduct() throws Exception {
        // TODO Auto-generated method stub
        List<String> productsToBeSelected=new ArrayList<String>();
        Hashtable<String,String> productQuantityToBeSelected=new Hashtable<String,String>();
        XLReader data=new XLReader("//Users//girishr//Documents//workspace//LearnSelenium//Temp//WeBuy.xlsx");
        int rowCount=data.rowNumber(0);
        int colCount=data.colNumber(0);
        System.out.println("Total number of rows are "+rowCount);
        System.out.println("Total number of columns are "+colCount);
        String cellProduct="";
        String cellQuantity="";
        //adding products into ArrayList,Hashtable
        for(int i=1;i<rowCount;i++){
              cellProduct=data.cellValue(0, i, 0);
              cellQuantity=data.cellValue(0, i, 1);
              productsToBeSelected.add(cellProduct);
              productQuantityToBeSelected.put(cellProduct, cellQuantity);
        }
        //reading data from ArrayList
        int arrListSize=productsToBeSelected.size();
        System.out.println(arrListSize);
       for(int i=0;i<arrListSize;i++)
              System.out.println(productsToBeSelected.get(i));     
        //Extracting all products from the screen
        System.setProperty("webdriver.gecko.driver", "//users//girishr//Downloads//geckodriver");
        WebDriver driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("https://uk.webuy.com/search/index.php?stext=*&section=&catid=956");
        List<WebElement> allProducts=driver.findElements(By.xpath("//div[@class='searchRecord']/div[2]/h1/a"));
        //Finding the size of all products on a page
        System.out.println("Total number of products on the page "+allProducts.size());
        //Extracting all 'I want to buy this item' button into a List
        List<WebElement> allButtons=driver.findElements(By.xpath("//div[@class='action']/div/a[2]/div/span"));
        //Finding the size of all I want to buy this item' buttons on the page
        System.out.println("Total number of buttons "+allButtons.size());
        //'allProducts' count must be equal to 'allButtons' count
        //Adding products to the cart based on products present in arrayList
        int baskCnt;
        int countProductsInCart=0;
        for(int i=0;i<allProducts.size();i++){
              if(productsToBeSelected.contains(allProducts.get(i).getText().split("\\n")[0])){
            	    allButtons.get(i).click();
                    countProductsInCart++;
                    String basketCount=driver.findElement(By.xpath("//span[@id='buyBasketCount']")).getText();
                    baskCnt=Integer.parseInt(basketCount);
                    Assert.assertEquals(countProductsInCart, baskCnt);
                    System.out.println("Entered if statement");
              }
        }
        //Go to View Basket screen
        driver.findElement(By.xpath("//div[@class='buyBasketContent']/table/tbody/tr/td[2]/a")).click();
        //Selecting the quantity
        List<WebElement> selectedProducts=driver.findElements(By.xpath("//form[@name='frmCart']/table/tbody/tr/td[2]"));
        //Print the size of selectedProducts
        System.out.println("Size of selected Products is "+selectedProducts.size());
        //Extract allDropdowns
        List<WebElement> allDropdowns=driver.findElements(By.xpath("//div[@class='basketPageBox']/form/table/tbody/tr/td[1]/div/select"));
        System.out.println("Dropdowns available is "+allDropdowns.size());
        for(int i=0;i<selectedProducts.size()-2;i++){
              String productName=selectedProducts.get(i).getText().split("\\n")[0];
              Select s=new Select(allDropdowns.get(i));
              s.selectByVisibleText(productQuantityToBeSelected.get(productName));
              selectedProducts=driver.findElements(By.xpath("//form[@name='frmCart']/table/tbody/tr/td[2]"));
              allDropdowns=driver.findElements(By.xpath("//div[@class='basketPageBox']/form/table/tbody/tr/td[1]/div/select"));
        }
        Thread.sleep(2000);
        //Getting delivery charges from page
        WebElement delcharge=driver.findElement(By.xpath("//form[@name='frmCart']/table/tbody/tr[4]/td[2]"));
        String dcharge=delcharge.getText().split("\\£")[1];
        WebElement actualPrice=driver.findElement(By.xpath("//form[@name='frmCart']/table/tbody/tr[5]/td[2]/strong"));
        double actPrice=Double.parseDouble(actualPrice.getText().split("\\£")[1]);
        Double deliveryCharges=Double.parseDouble(dcharge);
        System.out.println("Delivery charge is "+deliveryCharges);
        List<WebElement> prices=driver.findElements(By.xpath("//form[@name='frmCart']/table/tbody/tr/td[4]"));
        System.out.println("Size of prices "+prices.size());
        //Adding prices and delivery charges
        double sum;
        double temp=0.0;
        for(int i=0;i<prices.size();i++){
              sum=Double.parseDouble(prices.get(i).getText().split("\\£")[1]);
              System.out.println("Product value is "+sum);
              temp=temp+sum;
        }
        double actualTotal=temp+deliveryCharges;
        System.out.println("Actual Total is "+actualTotal);
        Assert.assertEquals(actualTotal, actPrice);
        System.out.println("Actual price on screen "+actPrice);
  }

}
