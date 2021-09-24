package com.qa.testscripts;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.FirstNaukriPages;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static FirstNaukriPages pages;
	
	@Parameters({"Browser", "Url"})
	@BeforeClass
	public void setUp(String browser, String url) throws InterruptedException {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		pages = new FirstNaukriPages(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		}

	@AfterClass
	public void tearDown() {
		// close browser
		driver.close();
	}
	
	public void captureScreenShot(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File Source =screenshot.getScreenshotAs(OutputType.FILE);
		String dest= System.getProperty("user.dir")+"/Screenshots/"+ tname +".png";
		FileUtils.copyFile(Source, new File(dest));
	}
	
//	@Parameters({ "email", "password" })
//	public static void LoginFunctionality(String email,String password) throws InterruptedException {
//		pages = new Login_Pages(driver);
//		pages.getLoginButton().click();
//		Thread.sleep(2000);
//		
//		pages.getEmail().sendKeys(email);
//		Thread.sleep(2000);
//		if(email.equals("ravikumaryalapala@gmail.com")) {
//			pages.getPassWord().sendKeys(password);
//			Thread.sleep(2000);
//			if(password.equals("Ravikumar@123")) {
//				pages.getSubmitButton().click();
//				Thread.sleep(2000);
//			}
//			else {
//				System.out.println("Password does not match");
//			}
//				
//			} else {
//				System.out.println("email does not match");
//			}
//		}
//		
//		Thread.sleep(2000);
//		pages.getPassWord().sendKeys(password);
//		Thread.sleep(2000);
//		
//		pages.getSubmitButton().click();
//		Thread.sleep(2000);
//		
//		if(email.equals("") && password.equals(""))
//		{
//			
//		}

}
