package com.qa.tests;
/**
 * Parameters are defined in testng.xml.
 * @Parameter annotation is wrote before test or test related annotation with a bracket 
 * and curly bracket defining those parameter names here too @Parameters({"url","browser"})
 * The method argument should define the type of parameters with a new variable nm to refer them.
 * These variables can be used in the method
 * This can be used with any test related method annotations
 * 
 */
import org.openqa.selenium.By;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Testngstart {
 WebDriver driver;
 
    @Parameters({"url"})
	@BeforeMethod
	public void setup(String url)
	{
		System.setProperty("webdriver.gecko.driver", "/Users/urvashimehta/bin/geckodriver");
		driver = new FirefoxDriver();
		System.out.println("1");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);//deprecated
		//driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);//deprecated
		System.out.println("2");
		//System.out.println("driver : " + driver.toString());
		driver.get(url);
	}
	
	@Test
	public void chkLogin()
	{
		boolean signin_exists = driver.findElement(By.xpath("//span[contains(text(),'Log In')]")).isDisplayed();
		System.out.println(signin_exists);
		if(signin_exists)
			driver.findElement(By.xpath("//span[contains(text(),'Log In')]")).click();
		
		driver.findElement(By.xpath("//input[contains(@name,'email')]")).sendKeys("uam11970@hotmail.com");//email);
	    driver.findElement(By.xpath("//input[contains(@name,'password')]")).sendKeys("this4CRM.");
	    driver.quit();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
