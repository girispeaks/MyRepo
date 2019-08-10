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
//import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class PurchaseProcess {
	@Test
	public static void WeBuy() throws Exception {
		XLReader xl = new XLReader("//Users//girishr//Documents//workspace//LearnSelenium//Temp//WeBuy.xlsx");
		int rwnum = xl.rowNumber(0);
		System.out.println("Total row number are " + rwnum);
		int colnum = xl.colNumber("Products");
		System.out.println("Total column are " + colnum);
		List<String> productsTobeAdded = new ArrayList<String>();
		Hashtable<String, String> productsQuantityToBeAdded = new Hashtable<String, String>();
		for (int i = 1; i < rwnum; i++) {
			String productNames = xl.cellValue("Products", i, 0);
			String productQuantity = xl.cellValue("Products", i, 1);
			productsTobeAdded.add(productNames);
			productsQuantityToBeAdded.put(productNames, productQuantity);
		}

		System.setProperty("webdriver.gecko.driver", "//users//girishr//Downloads//geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://uk.webuy.com/search/index.php?stext=*&section=&catid=956");
		List<WebElement> allProducts = driver.findElements(By.xpath("//div[@class='searchRecord']/div[2]/h1/a"));
		List<WebElement> allButtons = driver.findElements(By.xpath("//div[@class='action']/div/a[2]/div/span"));
		int allProductsSize = allProducts.size();

		// selecting the products
		int cnt = 0;
		for (int a = 0; a < allProductsSize; a++) {
			if (productsTobeAdded.contains(allProducts.get(a).getText())) {
				System.out.println(allProducts.get(a).getText());
				allButtons.get(a).click();
				cnt++;
				allProducts = driver.findElements(By.xpath("//div[@class='searchRecord']/div[2]/h1/a"));
				allButtons = driver.findElements(By.xpath("//div[@class='action']/div/a[2]/div/span"));
			}
			String totcnt = driver.findElement(By.xpath("//*[@id='buyBasketCount']")).getText();
			int tcnt = Integer.parseInt(totcnt);
			Assert.assertEquals(cnt, tcnt);
		}
		driver.findElement(By.xpath("html/body/div[5]/div[2]/div[4]/div[2]/table/tbody/tr/td[2]/a[1]")).click();

		List<WebElement> selectedProducts = driver
				.findElements(By.xpath("//div[@class='basketPageBox']/form/table/tbody/tr/td[2]"));
		System.out.println("size of selected items " + selectedProducts.size());
		for (int i = 0; i < selectedProducts.size() - 2; i++) {
			System.out.println("Selected items are " + selectedProducts.get(i).getText());
		}
		List<WebElement> QuantityOnSelectedScreen = driver
				.findElements(By.xpath("//div[@class='basketPageBox']/form/table/tbody/tr/td[1]/div/select"));
		System.out.println("No of dropdowns " + QuantityOnSelectedScreen.size());

		// selecting the quantity

		for (int i = 0; i < selectedProducts.size() - 2; i++) {

			if (productsTobeAdded.contains(selectedProducts.get(i).getText().split("\\n")[0])) {
				System.out.println("if loop entered");
				Select s = new Select(QuantityOnSelectedScreen.get(i));
				s.selectByVisibleText(productsQuantityToBeAdded.get(selectedProducts.get(i).getText().split("\\n")[0]));
			}
		}
		int totalrows=driver.findElements(By.xpath("//div[@class='basketPageBox']/form/table/tbody/tr")).size();
		System.out.println("totalrows "+totalrows);
		String delCharges=driver.findElement(By.xpath("//div[@class='basketPageBox']/form/table/tbody/tr["+(totalrows-1)+"]/td[2]")).getText();
		System.out.println("String delCharges "+delCharges);
		String totalPrice=driver.findElement(By.xpath("//div[@class='basketPageBox']/form/table/tbody/tr["+totalrows+"]/td[2]")).getText();
		System.out.println("String totalPrice "+totalPrice);
		double charges=Double.parseDouble(delCharges.split("\\£")[1]);
		System.out.println("charges "+charges);
		double expectedtotal=Double.parseDouble(totalPrice.split("\\£")[1]);
		System.out.println("expectedtotal "+expectedtotal);
		List<WebElement> individualPrice=driver.findElements(By.xpath("//form[@name='frmCart']/table/tbody/tr/td[4]"));
		System.out.println("Size of selected price "+individualPrice.size());
		double temp=0.0;
		for(int i=0;i<individualPrice.size();i++){
			individualPrice.get(i).getText();
			temp=temp+Double.parseDouble((individualPrice.get(i).getText()).split("\\£")[1]);
		}
		temp=temp+charges;
		System.out.println("added price is "+temp);
		Assert.assertEquals(temp,expectedtotal);
	}
}
