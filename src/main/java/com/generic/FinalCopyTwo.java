package com.generic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.selenium.pagefactory.SeleniumPageFactory;
import com.util.Constant;
import com.util.Highlighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FinalCopyTwo {
	
public static void getFinalCopy(){
		
		//Login ==>https://magento.softwaretestingboard.com/
		//open browser
	WebDriver driver = DriverManager.getBrowser("chrome");
		WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		SeleniumWait.getImplicitWait(driver, 3);
		
		// got to Application
		driver.navigate().to(Constant.URL);
		
		//ScreenShot.getScreenShot(driver, "Home Page");
		SeleniumPageFactory pf = new SeleniumPageFactory(driver);
		Highlighter.getcolor(driver, pf.getLumaSignin().get(0), "Orange");
		pf.getLumaSignin().get(0).click();
		//click sign in button
	
		//ScreenShot.getScreenShot(driver, "Login Page");
		Highlighter.getcolor(driver,pf.getLumaEmail().get(0), "Red");
		pf.getLumaEmail().get(0).click();
		pf.getLumaEmail().get(0).sendKeys(Constant.user);
		Highlighter.getcolor(driver, pf.getLumaPass().get(0), "blue");
		pf.getLumaPass().get(0).click();
		pf.getLumaPass().get(0).sendKeys(Constant.pass);
		
		Highlighter.getcolor(driver, pf.getSecondSigninBtn().get(0), "Pink");
		pf.getLumaSecondSignin().get(0).click();
		
		//ScreenShot.getScreenShot(driver, "Welcome Page");
		SoftAssert sf = new SoftAssert();
		sf.assertTrue(pf.getWelcomeBtn().get(0).isDisplayed());
		sf.assertAll();
		
		
		

	}
	
	
	public static void main(String[] args) {
		getFinalCopy();
	}
	
	
	
	
	

}
