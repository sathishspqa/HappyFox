package com.testscenarios;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class Scenario1_StatusCreationAndMakeDefault {
	
	WebDriver driver;
	
	ExtentReports er = new ExtentReports();
	
	
	@BeforeTest
	  public void beforeTest() throws Exception {
		
ChromeOptions ops = new ChromeOptions();
		
		ops.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(ops);
		
		driver.get("https://interview.supporthive.com/staff/login");
		
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		
        ExtentSparkReporter ESR = new ExtentSparkReporter("C:\\Users\\Light\\eclipse-workspace\\HappyFox\\Reports\\Status.html");
		
		er.attachReporter(ESR);
		
		
		er.createTest("test1");

		er.flush();
		
	  }
	
	
  @Test
  public void f() throws Exception {	 
	  
	        ExtentTest test = er.createTest("Verify Status Creation").assignAuthor("SathishSp").assignCategory("Functional Testing").assignDevice("Windows");		
	  		
	        test.info("Entering Username");
			
			driver.findElement(By.xpath("//input[@id='id_username']")).sendKeys("Agent");
			
			
			test.info("Entering Password");
			
			driver.findElement(By.xpath("//input[@id='id_password']")).sendKeys("Agent@123");
			
			
			test.info("Click the Login Button");
			
			driver.findElement(By.xpath("//input[@id='btn-submit']")).click();
			
			
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			
			Thread.sleep(5000);
			
			
			test.info("Click the Ticket");  			
			      
			WebElement Ticket = driver.findElement(By.xpath("//span[@title='Tickets']"));	
				
			Ticket.click();
			
			
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			
			Thread.sleep(5000);
			
			
			test.info("Click Statuses"); 
			
			WebElement Statuses = driver.findElement(By.xpath("//a[@class='ember-view'][normalize-space()='Statuses']"));
			
		    Actions actions = new Actions(driver);		
			   			
		    actions.moveToElement(Statuses).perform();
						
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

			jsExecutor.executeScript("arguments[0].click();", Statuses);
				
			Thread.sleep(3000);
				
				
				
			test.info("Create a Status"); 
				
			driver.findElement(By.xpath("//button[@class='hf-mod-create']")).click();
				
			Thread.sleep(5000);
				
				
			test.info("Enter Status name");
				
			driver.findElement(By.xpath("//input[@aria-label='Status Name']")).sendKeys("Test");
				
			Thread.sleep(2000);
				
				
			test.info("Select Completed");
				
			driver.findElement(By.xpath("/html/body/div[6]/aside/div[2]/section/section[2]/div[2]/div/div/div[1]")).click();
			
			driver.findElement(By.xpath("/html/body/div[6]/aside/div[2]/section/section[2]/div[2]/div/div/div[2]/div/ul/li[2]")).click();
			
			Thread.sleep(2000);
			
			
			test.info("Enter the Text Area");
				
		    WebElement TextArea = driver.findElement(By.xpath("//textarea[@aria-label='Description']"));
		       
		    TextArea.click();
				
		    jsExecutor.executeScript("arguments[0].value='New Status Created'", TextArea);
				
			Thread.sleep(2000);
				
				
			test.info("Click Add Status");				
				
			driver.findElement(By.xpath("(//button[normalize-space()='Add Status'])[1]")).click();
				
			Thread.sleep(2000);
				
			er.flush();
				
				
	  
  }
  

  @AfterTest
  public void afterTest() throws Exception {
	  
	  
	  ExtentTest test = er.createTest("Status set as default").assignAuthor("Abhinav").assignCategory("Functional Testing").assignDevice("Windows");

	  
	   test.info("Move to Status Area"); 
	  
	   WebElement e2 = driver.findElement(By.xpath("/html/body/div[3]/div/section/section/div/div/section/div/div/div[2]/div/div[2]/div/table/tbody/tr[7]/td[4]/span"));
		
	   Actions act2 = new Actions(driver);		
			
	   act2.moveToElement(e2).build().perform();
			
	   Thread.sleep(2000);
		
		
		test.info("Click Status Area"); 
			
		WebElement e3 = driver.findElement(By.xpath("/html/body/div[3]/div/section/section/div/div/section/div/div/div[2]/div/div[2]/div/table/tbody/tr[7]/td[5]/div/a"));
			
		act2.moveToElement(e3).click().perform();
			
		Thread.sleep(2000);		
			
			  
		test.info("Move to Status Area"); 
			  
		WebElement e = driver.findElement(By.xpath("//span[@title='New Status Created']"));
				
		String str = e.getText();
				
		System.out.println(str);
		
				
		 Assert.assertEquals(str, "New Status Created");
				
		 System.out.println("Test Completed : Status Created");
				
		 Thread.sleep(2000);
		 
		 
			
		 System.out.println("Status : Set as default");
			
		 er.flush();
		  
	  
  }

}
