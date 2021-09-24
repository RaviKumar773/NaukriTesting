package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FirstNaukriPages {
	
WebDriver driver;
	
	@FindBy(xpath="/html/body/div[1]/div/div/ul[1]/li[7]/a")
	WebElement LoginBtn;
	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	
	@FindBy(xpath="//*[@id=\"loginEmail\"]")
	WebElement UserName;
	public WebElement getUserName() {
		return UserName;
	}
	
	@FindBy(xpath="//*[@id=\"loginPassword\"]")
	WebElement Password;
	public WebElement getPassword() {
		return Password;
	}
	
	@FindBy(xpath="//*[@id=\"loginSubmitBtn\"]")
	WebElement LoginSubmit;
	public WebElement getLoginSubmit() {
		return LoginSubmit;
	}
	
	@FindBy(xpath = "//a[contains(text(),'Home')]")
	WebElement HomePage;
	public WebElement getHomePage() {
		return HomePage;
	}
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/span[1]")
	WebElement Internship;
	public WebElement getInternship() {
		return Internship;
	}
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/form/div/input")
	WebElement InternshipSearchField;
	public WebElement getInternshipSearchField() {
		return InternshipSearchField;
	}
	
	@FindBy(xpath="//*[@id=\"course\"]")
	WebElement SelectCourse;
	public WebElement getSelectCourse() {
		return SelectCourse;
	}
	
	@FindBy(xpath="//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li")
	List<WebElement> Branch;
	public List<WebElement> getBranch() {
		return Branch;
	}
	
	@FindBy(xpath="//*[@id=\"location-sugg\"]")
	WebElement Location;
	public WebElement getLocation() {
		return Location;
	}
	
	@FindBy(xpath="//*[@id=\"keyword-sugg\"]")
	WebElement Domain;
	public WebElement getDomain() {
		return Domain;
	}
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/form/button/span")
	WebElement SearchBtn;
	public WebElement getSearchBtn() {
		return SearchBtn;
	}
	
	@FindBy(xpath="/html/body/div[2]/div[3]/div[1]/div[2]/div[2]/div[2]/div/div[1]/a/span[1]/span")
	WebElement SelectJob;
	public WebElement getSelectJob() {
		return SelectJob;
	}
	
	@FindBy(xpath="//body/div[2]/div[2]/div[1]/div[3]/div[1]")  //     //*[@id="button_up"]  /html/body/div[2]/div[2]/div[1]/div[3]/div[1]
	WebElement ApplyBtn;
	public WebElement getApplyBtn() {
		return ApplyBtn;
	}
	
	@FindBy(xpath="/html/body/div[3]/div[3]/ul/li[5]/a")
	WebElement Terms;
	public WebElement getTerms() {
		return Terms;
	}
	
	@FindBy(xpath="/html/body/div[3]/div[3]/ul/li[6]/a")
	WebElement Privacy;
	public WebElement getPrivacy() {
		return Privacy;
	}
	
	public FirstNaukriPages(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
