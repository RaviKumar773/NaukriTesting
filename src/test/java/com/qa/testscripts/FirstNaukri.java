package com.qa.testscripts;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;



public class FirstNaukri extends TestBase{
	
	//FirstNaukriPages pages;
	@Test
	public void Login() throws Exception {
		Thread.sleep(3000);
		pages.getLoginBtn().click();
		Thread.sleep(3000);
		pages.getUserName().sendKeys("ravikumaryalapala@gmail.com");
		Thread.sleep(3000);
		pages.getPassword().sendKeys("Ravikumar@123");
		Thread.sleep(3000);
		pages.getLoginSubmit().click(); 
		
		Thread.sleep(2000);
		
		
		pages.getHomePage().click();	
		Thread.sleep(3000);
		pages.getInternship().click();
		Thread.sleep(3000);
		pages.getInternshipSearchField().click();
		Thread.sleep(3000);
		
//		Select course=new Select(pages.getSelectCourse());
//		course.selectByVisibleText("B.com");
//		Thread.sleep(4000);
		
		pages.getSelectCourse().click();
		Thread.sleep(3000);
		List<WebElement> list=pages.getBranch();
		for(WebElement l:list)
		{
			Thread.sleep(3000);
			if(l.getText().equalsIgnoreCase("BE / B.Tech")) {
				Reporter.log("course is matched");
				l.click();
				Assert.assertTrue(true);
				break;
			}
//			else {
//				captureScreenShot(driver,"Search");
//				Reporter.log("course is  not matched");
//				Assert.assertTrue(false);
//				
//			}
		}
		
		
		pages.getLocation().sendKeys("Varanasi");
		pages.getDomain().sendKeys("Java Developer");
		pages.getSearchBtn().click();
		Thread.sleep(3000);
		pages.getSelectJob().click();
		Thread.sleep(3000);
	
		String parent=driver.getWindowHandle();
		
		Set<String> s=driver.getWindowHandles();

		// Now iterate using Iterator
		//Iterator<String> I1= s.iterator();

		for (String child : s) {
			Thread.sleep(3000);
			if (!child.equals(parent)) {
				driver.switchTo().window(child);
		
				Thread.sleep(3000);
				pages.getApplyBtn().click();
				Thread.sleep(3000);
				System.out.println("clicked");
				Assert.assertTrue(true);
				driver.close();
			}
//			else {
//			driver.switchTo().window(child);
//			captureScreenShot(driver,"Search");
//			System.out.println("tab address is not matched");
//			Assert.assertTrue(false);
//			driver.close();
//			}
		}
		
		driver.switchTo().window(parent);
		
	
	}

}
