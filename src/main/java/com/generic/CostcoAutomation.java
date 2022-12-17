package com.generic;

import java.time.Duration;

import javax.swing.text.Highlighter.Highlight;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.selenium.pagefactory.SeleniumPageFactory;
import com.util.Constant;
import com.util.Highlighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

public class CostcoAutomation {

	
	public static void productHandle () {
		
		
		WebDriver driver = DriverManager.getBrowser("chrome");
		driver.manage().window().maximize();
		driver.navigate().to(Constant.Costco_URL);
		//Implicit wait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		SeleniumWait.getImplicitWait(driver, 3);
		//get the page name/ title/ page title//getTitle()
		
				System.out.println("Home Page Title"+ driver.getTitle());
			
			System.out.println("Current URL" + driver.getCurrentUrl());
		//check if Expected = actual or not 
		SoftAssert sf = new SoftAssert ();
		sf.assertEquals(Constant.Costco_URL, driver.getCurrentUrl());
		//go to the sign in page
		SeleniumPageFactory pf = new SeleniumPageFactory (driver);
		SeleniumWait.getExplicitWait(driver, pf.getSignInCostco().get(0), 3);
		Highlighter.getcolor(driver,pf.getSignInCostco().get(0), "Red");
		pf.getSignInCostco().get(0).click();
		
		//get page title 
		System.out.println("Sign in Page Title"+ driver.getTitle());
		
		// get screen shot
		//ScreenShot.getScreenShot(driver, "CostCo Sign in Page");
		
		// go back to home page (navigate().back().)
		//put hard wait
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//driver.navigate().back();
		//driver.navigate().back();
		//for (int i = 0; i<10;i++) {
		//	if(pf.getSignInCostco().isDisplayed()) {
			//	break;
		//	}else {
			//	driver.navigate().back();
			//	try {
			//		Thread.sleep(3000);
			//	} catch (InterruptedException e) {
		//			// TODO Auto-generated catch block
			//		e.printStackTrace();
		//		}
		//	}
	//	}
		driver.navigate().refresh();
		while(true) {
			if(pf.getSignInCostco().size()>0 ) {
			break;	
				
			}else {
				
				driver.navigate().back();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			}
			
		//get menu btn
	//	pf.getCostcoMenuBtn()
		//System.out.println("Menu count =" + pf.getCostcoMenuBtn().size() );
		//for (int i =0;i<pf.getCostcoMenuBtn().size();i++) {
			
			
		//}
System.out.println("Menu count = "+pf.getCostcoMenuBtn().size());
		
		for(int i=0;i<pf.getCostcoMenuBtn().size();i++) {
			//HighLighter.getColor(driver, pf.getCostcoMenuBtn().get(i), "white");
			
			System.out.println(pf.getCostcoMenuBtn().get(i).getText());
			
		}
		
	
				//8 >If the deal was there, then mouse over it and read all options
				//mouse hover= Actions class= moveToElement()
				for(int i=0;i<pf.getCostcoMenuBtn().size();i++) {//1st loop
					if(pf.getCostcoMenuBtn().get(i).getText().contains("Deals")) {//true
						//Highlighter.getColor(driver, pf.getCostcoMenuBtn().get(i), "red");
						Actions ac = new Actions(driver);
						ac.moveToElement(pf.getCostcoMenuBtn().get(i)).perform();
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						System.out.println("Deal options count = "+pf.getDealOptions().size());
						//Read name of All deal options==> loop
						for(int j=0;j<pf.getDealOptions().size();j++) {//2nd loop
						//	HighLighter.getColor(driver, pf.getDealOptions().get(j), "green");
							System.out.println(pf.getDealOptions().get(j).getText());
						}
						
					}
					
				}
				
				
				
		sf.assertAll();	
	
	
	}
	
	public static void main(String[] args) {
		
		CostcoAutomation.productHandle();
		
	}
	}


