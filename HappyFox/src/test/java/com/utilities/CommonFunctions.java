package com.utilities;

import java.io.File;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonFunctions extends BaseClass {

	/*********** Chrome Browser ****************/
	
	   public void chromeBrowserLaunch() throws Exception

		{

			

			driver = new ChromeDriver();

			driver.manage().window().maximize();

			Thread.sleep(3000);

		}
		
		/*********** Firefox Browser ****************/

		public void firefoxBrowserLaunch() throws Exception

		{

	

			driver = new FirefoxDriver();

			driver.manage().window().maximize();

			Thread.sleep(3000);

		}
		
		/*********** Edge Browser ****************/

		public void edgeBrowserLaunch() throws Exception

		{

		

			driver = new EdgeDriver();

			driver.manage().window().maximize();

			Thread.sleep(3000);

		}

		
		/*********** Border ****************/
		
		public void JavaScriptBorder(WebElement element) throws Exception

		{

			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

			jsExecutor.executeScript("arguments[0].style.border='2px solid red'", element);

		}
		
		/*********** Background color ****************/
		
		public void JavaScriptBg(WebElement element) throws Exception

		{

			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

			jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

		}

		/*********** JavaScript Click Border ****************/
		
		public void JavaScriptClick(By Locator) throws Exception

		{

			WebElement element = driver.findElement(Locator);

			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

			JavaScriptBorder(element);

			jsExecutor.executeScript("arguments[0].click();", element);

		}
		
		
		/*********** JavaScript Click BG ****************/
		
		public void JavaScriptClick2(By Locator) throws Exception

		{

			WebElement element = driver.findElement(Locator);

			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

			JavaScriptBg(element);

			jsExecutor.executeScript("arguments[0].click();", element);

		}
		
		
		/*********** Explicit Wait ****************/
		
		public void explitWaitForElementToBeClickable(By Locator)

		{


			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			wait.until(ExpectedConditions.elementToBeClickable(Locator));

		}

		/*********** Time Stamp ****************/
		
		public String timestamp() {
			
			Date d = new Date(0);
			DateFormat df = new SimpleDateFormat("ddMMMyyy_HHmmss");
			String timeTamp = df.format(d);
			return timeTamp;
			
			
		}
		
		
		/*********** Screen Shots 
		 * @throws Exception ****************/
		
		public void takeScreenShot() throws Exception {
			
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
			String screenshotPath = ".\\Screenshot\\";
			
			FileHandler.copy(srcFile, new File (screenshotPath + "abc" + ".png"));
			
			System.out.println("Screen Shot Taken");
			
		}

	}

