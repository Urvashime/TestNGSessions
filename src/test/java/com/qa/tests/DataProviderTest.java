package com.qa.tests;
/**
 * DataProvider annotation is same as Parameters except the data comes not from testng.xml 
 * but from a method annotated with DataProvider and  another test method to run the actual 
 * tests several times with different set of data. The test method needs to define all the 
 * column names from the excel sheet in the same order and type. Also the Test annotation 
 * needs to define the method name of the DataProvider method or its name. 
 * @DataProvider(name="somename")
 * public Object[][] loadData()
 * @Test(dataProvider="somename" or "loadData"
 * public void chkLogin(String Username,String Passwd)
 */
//import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.util.FetchData;

public class DataProviderTest {

	 WebDriver driver;
	 String sheetnm ="login";   
		@BeforeMethod
		public void setup()
		{
			System.setProperty("webdriver.gecko.driver", "/Users/urvashimehta/bin/geckodriver");
			driver = new FirefoxDriver();

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);//deprecated
			//driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);//deprecated
			System.out.println("driver : " + driver.toString());
			driver.get("https://freecrm.com");
			boolean signin_exists = driver.findElement(By.xpath("//span[contains(text(),'Log In')]")).isDisplayed();
			System.out.println(signin_exists);
			if(signin_exists)
				driver.findElement(By.xpath("//span[contains(text(),'Log In')]")).click();
		}
		
		@DataProvider(name="dp")
		public Object[][] loadData()
		{
			Object[][] data= FetchData.getTestData(sheetnm);
			System.out.println("DataProvider Array length  : "+data.length);
			return data;
		}
		
		//@Parameters({"email","passwd"})
		@Test(dataProvider="dp")
		public void chkLoginIcon(String Username,String Password)
		{
			try {
			driver.findElement(By.xpath("//input[contains(@name,'email')]")).clear();//to clean the element data
			driver.findElement(By.xpath("//input[contains(@name,'email')]")).sendKeys(Username);//"uam11970@hotmail.com");//email);
			driver.findElement(By.xpath("//input[contains(@name,'password')]")).clear();
		    driver.findElement(By.xpath("//input[contains(@name,'password')]")).sendKeys(Password);//"this4CRM.");
		    WebElement element=driver.findElement(By.xpath("//div[contains(text(),'Login')]"));
		    JSClick(element,driver);
			}catch(Exception e)
			{   System.out.println("There is no value in this column");
				e.printStackTrace();}
		}
		
		@AfterMethod
		public void tearDown()
		{
			driver.quit();
		}
		
		public void JSClick(WebElement element,WebDriver driver)
		{
			JavascriptExecutor js = ((JavascriptExecutor)driver);
			js.executeScript("arguments[0].click();",element);
		}
		
}