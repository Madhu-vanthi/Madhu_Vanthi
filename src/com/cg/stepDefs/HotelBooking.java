package com.cg.stepDefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HotelBooking 
{

	static WebDriver driver=null;
	static String alertMessage=null;
	
	public static void main(String[] args) {
		driver = new FirefoxDriver();
		driver.get("file:///D:/mmuthuva_Madhu/hotelbooking.html");

		String title=driver.getTitle();
		System.out.println("The page title is :" + title);

		/******* For blank First Name *******/
		driver.findElement(By.name("txtFN")).sendKeys("");
		driver.findElement(By.id("btnPayment")).click();	
		callAlert();

		
		/******* For valid First Name *******/
		driver.findElement(By.name("txtFN")).sendKeys("madhu");
		
		/******* For blank Last Name *******/
		driver.findElement(By.xpath("//*[@id='txtLastName']")).sendKeys("");
		driver.findElement(By.id("btnPayment")).click();	
		callAlert();

		/******* For valid Last Name *******/
		driver.findElement(By.xpath("//*[@id='txtLastName']")).sendKeys("M");


		/******* For blank Email Id *******/
		driver.findElement(By.name("Email")).sendKeys("");
		driver.findElement(By.id("btnPayment")).click();	
		callAlert();
		
		/******* For invalid Email ID *******/
		driver.findElement(By.name("Email")).sendKeys("a.com");								
		driver.findElement(By.id("btnPayment")).click();	
		callAlert();
		
		/******* For valid Email ID *******/
		driver.findElement(By.name("Email")).clear();
		driver.findElement(By.name("Email")).sendKeys("madhu@gmail.com");	

		/******* For blank MobileNo *******/
		driver.findElement(By.cssSelector("input[pattern='[789][0-9]{9}']")).sendKeys("");
		driver.findElement(By.id("btnPayment")).click();	
		callAlert();
		
		/******* For invalid Mobile No *********/ 
		driver.findElement(By.cssSelector("input[pattern='[789][0-9]{9}']")).sendKeys("7896");	
		driver.findElement(By.id("btnPayment")).click();	
		callAlert();
		
		/******* For valid Mobile No *******/
		driver.findElement(By.cssSelector("input[pattern='[789][0-9]{9}']")).clear();
		driver.findElement(By.cssSelector("input[pattern='[789][0-9]{9}']")).sendKeys("7897897890");	

		/******* For blank city  *******/
		Select drpCity = new Select(driver.findElement(By.name("city")));
		drpCity.selectByVisibleText("Select City");
		driver.findElement(By.id("btnPayment")).click();	
		callAlert();
		
		/******* For selecting city  *******/
		drpCity.selectByVisibleText("Coimbatore");


		/******* For blank State  *******/
		Select drpState = new Select(driver.findElement(By.name("state")));
		drpState.selectByVisibleText("Select State");
		driver.findElement(By.id("btnPayment")).click();	
		callAlert();
		
		/******* For selecting State  *******/
		drpState.selectByVisibleText("Tanilnadu");


		/******* For blank CardHolderName ******/
		driver.findElement(By.id("txtCardholderName")).sendKeys("");
		driver.findElement(By.id("btnPayment")).click();	
		callAlert();
		
		/******* For valid CardHolderName *******/
		driver.findElement(By.id("txtCardholderName")).sendKeys("MadhuVanthi M");

		/***** For blank DebitCardNo *******/
		driver.findElement(By.id("txtDebit")).sendKeys("");
		driver.findElement(By.id("btnPayment")).click();	
		callAlert();
		
		/******* For valid DebitCardNo *******/
		driver.findElement(By.id("txtDebit")).sendKeys("6789678978906789");

		/***** For blank CVV *******/
		driver.findElement(By.name("cvv")).sendKeys("");
		driver.findElement(By.id("btnPayment")).click();	
		callAlert();
		
		/******* For valid CVV *******/
		driver.findElement(By.name("cvv")).sendKeys("890");

		/***** For blank Expiry Month  *****/
		driver.findElement(By.id("txtMonth")).sendKeys("");
		driver.findElement(By.id("btnPayment")).click();	
		callAlert();
		
		/***** For valid Expiry Month  *****/
		driver.findElement(By.id("txtMonth")).sendKeys("5");

		/***** For blank Expiry Year  *****/
		driver.findElement(By.id("txtYear")).sendKeys("");
		driver.findElement(By.id("btnPayment")).click();	
		callAlert();
		
		/***** For valid Expiry Year  *****/
		driver.findElement(By.id("txtYear")).sendKeys("2020");

		//entered all valid data. Now its time to navigate to next page
		driver.findElement(By.id("btnPayment")).click();
		driver.navigate().to("file:///D:/Lesson%205-HTML%20Pages/success.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//	driver.close();
	}
	
	public static void callAlert()
	{
		String alertMessage= driver.switchTo().alert().getText();
		System.out.println(alertMessage);		
		driver.switchTo().alert().accept();

	}	
}