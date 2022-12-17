package com.generic;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.selenium.pagefactory.SeleniumPageFactory;
import com.util.Constant;
import com.util.Highlighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

public class BaseLogin {
	public void getLogin() {
		WebDriver driver;
		SeleniumPageFactory pf;
		//open the browser
		driver= DriverManager.getBrowser("chrome");
		pf=new SeleniumPageFactory (driver);
		driver.manage().window().maximize();
		//Implicit wait
		SeleniumWait.getImplicitWait(driver, 3);
		//go to application
		driver.navigate().to(Constant.URL);
		ScreenShot.getScreenShot(driver, "Home Page");
		//Explicit Wait
		SeleniumWait.getExplicitlWait(driver, pf.getFirstSigninBtn().get(0));
		//Click sign in btn
		Highlighter.getcolor(driver, pf.getFirstSigninBtn().get(0), "green");
		pf.getFirstSigninBtn().get(0).click();
		ScreenShot.getScreenShot(driver, "Login Page");
		
		//put email address
		Highlighter.getcolor(driver, pf.getUser(), "Red");
		pf.getUser().click();
		pf.getUser().sendKeys(Constant.user);
		
		// Enter Password
		Highlighter.getcolor(driver, pf.getPass(), "Orange");
		pf.getPass().click();
		pf.getPass().sendKeys(Constant.pass);
		
		// Click second log in BTN 
		Highlighter.getcolor(driver,	pf.getSecondSigninBtn().get(0), "Yellow");
		pf.getSecondSigninBtn().get(0).click();
		ScreenShot.getScreenShot(driver, "Welcome Page");
		
		// Validation 
		Highlighter.getcolor(driver, null, null);
		boolean status = pf.getWelcomeBtn().get(0).isDisplayed();
		SoftAssert sf = new SoftAssert();
		sf.assertTrue(status);
		System.out.println(status);
		ScreenShot.getScreenShot(driver, "Validation");
		
		//driver.quit();
		
	
	
	}
	

}
