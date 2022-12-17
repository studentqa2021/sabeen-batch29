package com.cucumber.test;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.selenium.pagefactory.SeleniumPageFactory;
import com.util.Constant;
import com.util.Highlighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {
	WebDriver driver;
	SeleniumPageFactory pf;
	
	@Given("Open a browser")
	public void open_a_browser() {
		driver = DriverManager.getBrowser("chrome");
		pf=new SeleniumPageFactory (driver);
		driver.manage().window().maximize();
		//Implicit wait
		SeleniumWait.getImplicitWait(driver, 3);
	
	}

	@Given("Go to application URL")
	public void go_to_application_URL() {
		driver.navigate().to(Constant.URL);
		ScreenShot.getScreenShot(driver, "Home Page");
		//Explicit Wait
		SeleniumWait.getExplicitWait(driver, pf.getFirstSigninBtn().get(0), 0);
	 
	}

	@When("Click Sign in BTN")
	public void click_Sign_in_BTN() {
		Highlighter.getcolor(driver, pf.getFirstSigninBtn().get(0), "green");
		pf.getFirstSigninBtn().get(0).click();
		ScreenShot.getScreenShot(driver, "Login Page");
		
	 
	}

	@When("put user email address")
	public void put_user_email_address() {
		Highlighter.getcolor(driver, pf.getUser(), "Red");
		pf.getUser().click();
		pf.getUser().sendKeys(Constant.user);
		
	 
	}

	@When("Put password")
	public void put_password() {
		Highlighter.getcolor(driver, pf.getPass(), "Orange");
		pf.getPass().click();
		pf.getPass().sendKeys(Constant.pass);
	 
	}

	@When("Click Second login BTN")
	public void click_Second_login_BTN() {
		Highlighter.getcolor(driver,	pf.getSecondSigninBtn().get(0), "Yellow");
		pf.getSecondSigninBtn().get(0).click();
		ScreenShot.getScreenShot(driver, "Welcome Page");
		
	 
	}

	@Then("Validation")
	public void validation() {
		Highlighter.getcolor(driver, null, null);
		boolean status = pf.getWelcomeBtn().get(0).isDisplayed();
		SoftAssert sf = new SoftAssert();
		sf.assertTrue(status);
		System.out.println(status);
		ScreenShot.getScreenShot(driver, "Validation");
		
		//driver.quit();
		
	 
	}


}
