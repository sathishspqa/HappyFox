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

public class Scenario3_DeletePriority {
	

	WebDriver driver;
	
	ExtentReports er = new ExtentReports();
	
	@BeforeTest
	public void beforeClass() throws Exception {

		ChromeOptions ops = new ChromeOptions();
		
		ops.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(ops);
		
		driver.get("https://interview.supporthive.com/staff/login");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
       ExtentSparkReporter ESR = new ExtentSparkReporter("C:\\Users\\Light\\eclipse-workspace\\HappyFox\\Reports\\DeletePriority.html");
		
		er.attachReporter(ESR);
		
		
		er.createTest("test1");

		er.flush();
		
		
	}

	@Test
	public void f() throws Exception {
		
		ExtentTest test = er.createTest("Delete Priority").assignAuthor("SathishSp").assignCategory("Functional Testing").assignDevice("Windows");
		
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
			
			
			
			test.info("Click Priority Title");
			
			driver.findElement(By.xpath("//span[@title='Priority Test']")).click();
			
			Thread.sleep(2000);
			
				
			test.info("Click Delete Button");
			
			driver.findElement(By.xpath("//a[@class='hf-delete-item hf-u-push-right hf-js-delete-priority-trigger']")).click();
			
			Thread.sleep(7000);
			
		 	
		 test.info("Delete Priority");
			 			
		  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			
	      WebElement ModContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='hf-confirmation-dialog_body hf-js-confirmation-dialog-body']")));
	       
	      WebElement ModElement = ModContainer.findElement(By.xpath("//span[normalize-space()='Choose Priority']"));
	     
	      ModElement.click(); 
	      
	      Thread.sleep(2000); 
	      
	      WebElement completed = ModContainer.findElement(By.xpath("//li[normalize-space()='Low']"));
	       
	      completed.click();
	      
	      Thread.sleep(2000); 
	      
	      WebElement delete = ModContainer.findElement(By.xpath("(//button[normalize-space()='Delete'])[1]"));
	       
	      delete.click();			
			
	      er.flush();
			
		
	}



	@AfterTest
	public void afterClass() throws Exception {
		
	
		System.out.println("Priority Deleted");
		
	}

}
