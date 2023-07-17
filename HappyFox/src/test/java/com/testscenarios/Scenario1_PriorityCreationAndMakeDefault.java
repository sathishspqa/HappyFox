package com.testscenarios;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

public class Scenario1_PriorityCreationAndMakeDefault {
	

	static WebDriver driver;
	
	ExtentReports er = new ExtentReports();
	
	@BeforeTest
	public void beforeClass() throws Exception {

		ChromeOptions ops = new ChromeOptions();
		
		ops.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(ops);
		
		driver.get("https://interview.supporthive.com/staff/login");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
	
		ExtentSparkReporter ESR = new ExtentSparkReporter("C:\\Users\\Light\\eclipse-workspace\\HappyFox\\Reports\\Priority.html");
		
		er.attachReporter(ESR);
		
		
		er.createTest("test1");

		er.flush();
		
		
	}

	@Test
	public void f() throws Exception {
		
		ExtentTest test = er.createTest("Verify Priority Creation").assignAuthor("Abhinav").assignCategory("Functional Testing").assignDevice("Windows");		
				
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
		
		
			test.info("Click Priority"); 

		    driver.findElement(By.xpath("//a[@title='Priorities']")).click();						
			
			Thread.sleep(5000);
			
			
			test.info("Click Priority + Button"); 	
			
			driver.findElement(By.xpath("//button[@class='hf-mod-create']")).click();	
			
			Thread.sleep(2000);
			
			
			test.info("Enter Priority Name"); 			
			
           driver.findElement(By.xpath("//input[@aria-label='Priority Name']")).sendKeys("Priority Test");
			
			Thread.sleep(2000);
			
			
			test.info("Enter Priority description"); 
			
			driver.findElement(By.xpath("//textarea[@aria-label='Description']")).sendKeys("Priority Test Area");
			
			Thread.sleep(2000);
			
			
			test.info("Enter Priority Help Area"); 
			
			
           driver.findElement(By.xpath("//textarea[@aria-label='Help text for agents (1500 Characters)']")).sendKeys("Priority Help Area Text");
			
			Thread.sleep(2000);
			
			
			test.info("Click Add Priority"); 
			
			driver.findElement(By.xpath("(//button[normalize-space()='Add Priority'])[1]")).click();
			
			Thread.sleep(2000);	
			
			er.flush();
			
		
	}



	@AfterTest
	public void afterClass() throws Exception { 
		
		
		ExtentTest test = er.createTest("Priority set as default").assignAuthor("Abhinav").assignCategory("Functional Testing").assignDevice("Windows");
		
		
		test.info("Move to Priority Area"); 
		
		 WebElement e2 = driver.findElement(By.xpath("//span[@title='Priority Help Area Text']"));
		
		 Actions act2 = new Actions(driver);		
			
		 act2.moveToElement(e2).build().perform();
		 
		 Thread.sleep(2000);
		 
		 
		 
		test.info("Make Priority default"); 
			
		WebElement e3 = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/section[1]/section[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[7]/td[5]/div[1]/div[1]"));
		 
		// WebElement e3 = driver.findElement(By.cssSelector("div[data-test-id='make-default-1443']"));
		 
         JavascriptExecutor js = (JavascriptExecutor)driver;
         
         js.executeScript("arguments[0].setAttribute('style','visibility:visible;');",e3);
			
		 js.executeScript("arguments[0].click();", e3);		 
		 			
		 Thread.sleep(2000);
		
		 
		WebElement e = driver.findElement(By.xpath("//span[@title='Priority Help Area Text']"));
			
		String str = e.getText();
			
		System.out.println(str);
			
			
			
		    Assert.assertEquals(str, "Priority Help Area Text");
			
			System.out.println("Test Completed : Priority Created");
			
		 
		 System.out.println("Test passed : Priority set as default");
		 
		 
		 er.flush();
	
	
}
	
}
	

