package com.selenium.pagefactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumPageFactory {
	WebDriver driver;
	
	public SeleniumPageFactory (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath ="//*[@class='authorization-link']" )//1 of 2 
	private List<WebElement> firstSigninBtn;
	
	@FindBy (xpath = "//*[@name='login[username]']")
	private WebElement user;
	
	

	@FindBy (xpath = "//*[@name='login[password]']")
	private WebElement pass;
	
	@FindBy (xpath= "//*[@name='send']") // 1 of 2
	private List<WebElement> secondSigninBtn;
	
	@FindBy(xpath= "//*[@class='logged-in']") //1 of 2 
	private List <WebElement> welcomeBtn;

	//*[text()='Sign In / Register']
	@FindBy(xpath= "//*[text()='Sign In / Register']")
	private List<WebElement> signInCostco;
	
	@FindBy(xpath="(//*[@class='authorization-link']/a)[1]")
	private List<WebElement> LumaSignin;
	
	@FindBy(xpath="//*[@id='email']")
	private List<WebElement> LumaEmail;
	
	@FindBy(xpath="//*[@title='Password']")
	private List<WebElement> LumaPass;
	
	@FindBy(xpath="//*[@class='action login primary']")
	private List<WebElement> LumaSecondSignin;
	
	@FindBy(xpath="(//*[contains(text(),'Welcome')])[1]")
	private List<WebElement> LumaWelcomeBTN;
	
//(Cosco Sign In Xpath with another method//*[@id='header_sign_in'])
	
	
	//@FindBy(xpath= "//*[@class='menu']")// 1 of 2 
	//private List<WebElement> costcoMenuBtn;
	
	
	
	//public List<WebElement> getCostcoMenuBtn() {
		//return costcoMenuBtn;
//	}

	@FindBy(xpath ="//*[@id='navigation-widget']//a")
	private List<WebElement> costcoMenuBtn;
	
	public List<WebElement> getLumaSignin() {
		return LumaSignin;
	}

	public List<WebElement> getLumaEmail() {
		return LumaEmail;
	}

	public List<WebElement> getLumaPass() {
		return LumaPass;
	}

	public List<WebElement> getLumaSecondSignin() {
		return LumaSecondSignin;
	}

	public List<WebElement> getLumaWelcomeBTN() {
		return LumaWelcomeBTN;
	}


	@FindBy(xpath ="//*[@class='sub-item']")
	private List<WebElement> dealOptions;

	public List<WebElement> getDealOptions() {
		return dealOptions;
	}

	public List<WebElement> getSignInCostco() {
		return  signInCostco;
	}

	public List<WebElement> getCostcoMenuBtn() {
		return costcoMenuBtn;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public List<WebElement> getFirstSigninBtn() {
		return firstSigninBtn;
	}

	public WebElement getUser() {
		return user;
	}

	public WebElement getPass() {
		return pass;
	}

	public List<WebElement> getSecondSigninBtn() {
		return secondSigninBtn;
	}

	public List<WebElement> getWelcomeBtn() {
		return welcomeBtn;
	}
	
	
	
	
	
	
	
}
