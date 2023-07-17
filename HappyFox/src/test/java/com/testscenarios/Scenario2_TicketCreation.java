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

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class Scenario2_TicketCreation {
	

WebDriver driver;

ExtentReports er = new ExtentReports();
	
	@BeforeTest
	public void beforeClass() throws Exception {

		ChromeOptions ops = new ChromeOptions();
		
		ops.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(ops);
		
		driver.get("https://interview.supporthive.com/new");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
       ExtentSparkReporter ESR = new ExtentSparkReporter("C:\\Users\\Light\\eclipse-workspace\\HappyFox\\Reports\\Ticket.html");
		
		er.attachReporter(ESR);
		
		
		er.createTest("test1");

		er.flush();
		
		
	}

	@Test
	public void f() throws Exception {
		
		 ExtentTest test = er.createTest("Creation of Ticket").assignAuthor("SathishSp").assignCategory("Functional Testing").assignDevice("Windows");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		
		test.info("Enter the Subject");
	
		driver.findElement(By.xpath("//input[@id='id_subject']")).sendKeys("Create Sample Ticket");
		
		Thread.sleep(2000);	  
		
		
		test.info("Enter Message");
		
		
		WebElement ta = driver.findElement(By.xpath("/html/body/div[1]/div[4]/section/div/form/div[1]/div[2]/div/div/div/div"));
		
				
		 JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		 
		 jsExecutor.executeScript("document.getElementById('id_html').setAttribute('style','visibility:visible;');",ta);
		 
		 jsExecutor.executeScript("document.getElementById('id_html').setAttribute('style','type', 'text');",ta);
		 
		 ta.clear();
		 
		 ta.sendKeys("1234");		 		  
		 
		 Thread.sleep(2000);   
		 
		 
		test.info("Click Add CC Button");         
	     		
		driver.findElement(By.xpath("//button[@id='add-cc']")).click();
		
		Thread.sleep(1000);
		
		
		test.info("Enetr CC Mail ID");
		
		driver.findElement(By.xpath("//input[@id='id_cc']")).sendKeys("1234@gmail.com");
		
		Thread.sleep(1000);
		
		
		test.info("Click Add BCC Button");
		
		driver.findElement(By.xpath("//button[@id='add-bcc']")).click();
		
		Thread.sleep(1000);
		
		
		test.info("Enter BCC Mail ID");
		
		driver.findElement(By.xpath("//*[@id='id_bcc']")).sendKeys("abcd@gmail.com");
		
		Thread.sleep(1000);
		
		test.info("Enter name");
		
		driver.findElement(By.xpath("//input[@id='id_name']")).sendKeys("Sathish SP");
		
		Thread.sleep(1000);
		
		test.info("Enter email id");
		
		driver.findElement(By.xpath("//input[@id='id_email']")).sendKeys("sathishspqa@gmail.com");
		
		Thread.sleep(1000);
		
		
		test.info("Enter Phone Number");
		
		driver.findElement(By.xpath("//input[@id='id_phone']")).sendKeys("9894118040");
		
		Thread.sleep(1000);
		
		
		test.info("Click Create Ticket");
		
		driver.findElement(By.xpath("//button[@id='submit']")).click();
			
		Thread.sleep(2000);
		
		test.info("Go to Staff Login URL");
		
		driver.get("https://interview.supporthive.com/staff/login");
		
        test.info("Entering Username");
		
		driver.findElement(By.xpath("//input[@id='id_username']")).sendKeys("Agent");
		
		
		test.info("Entering Password");
		
		driver.findElement(By.xpath("//input[@id='id_password']")).sendKeys("Agent@123");
		
		
		test.info("Click the Login Button");
		
		driver.findElement(By.xpath("//input[@id='btn-submit']")).click();
		
		
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		Thread.sleep(5000);
		
		
		test.info("Click the Title of the Ticket");
		
		driver.findElement(By.xpath("//article[@class='js-ticket-box-896 hf-ticket-box ember-view']//a[@title='Create Sample Ticket']")).click();
		
		Thread.sleep(2000); 
		
		
		test.info("Click the reply to the Ticket");
		
		driver.findElement(By.xpath("//a[@data-test-id='reply-link']")).click();
		
		Thread.sleep(2000);
		
		
		test.info("enter the updated message");
		
		driver.findElement(By.xpath("//div[contains(@aria-label,'false')]")).sendKeys("Ticket updated");
		
		Thread.sleep(2000);
		
		
		test.info("Click to Minimize the window");
		
		driver.findElement(By.xpath("//div[contains(@class,'hf-floating-editor_min-max-button')]")).click();
		
		er.flush();
			
		
	}



	@AfterTest
	public void afterClass() throws Exception {
		
		ExtentTest test = er.createTest("Validate the Ticket").assignAuthor("Abhinav").assignCategory("Functional Testing").assignDevice("Windows");
		
		test.info("Validation of Ticket");
		
		WebElement tik = driver.findElement(By.xpath("//*[@id='main']/section/section[2]/div/div/div"));
		
		String str = tik.getText();
		
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String screenshotPath = "C:\\Users\\Light\\eclipse-workspace\\HappyFox\\test-output\\Screenshot\\Ticket.png";

		FileHandler.copy(srcFile, new File(screenshotPath));

		System.out.println("Screen Shot Taken");
		
		System.out.println("Status of the ticket:" + str);
		
		System.out.println("Test Completed : Ticket Created");		
		
		er.flush();
		
		
	}

}
