package com.util;

import java.io.File;
import java.io.IOException;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	public static String getScreenShot (WebDriver driver, String ScreenShotName) {
		
		File folder = new File ("./target/Screen shot");//where and name
		if(!folder.exists()) {//no folder there
		folder.mkdir();
	}
	TakesScreenshot ts = (TakesScreenshot) driver; //type casting
	File screenShotfile = ts.getScreenshotAs(OutputType.FILE);
	String destination = "./target//Screen shot //"+ScreenShotName + ".png";
	try {
		FileUtils.copyFile(screenShotfile,  new File (destination));
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	return destination;
	}

}