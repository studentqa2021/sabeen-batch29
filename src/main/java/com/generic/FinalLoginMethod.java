package com.generic;

import java.time.Duration;

import javax.management.openmbean.OpenMBeanAttributeInfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.drivermanager.DriverManager;
import com.selenium.pagefactory.SeleniumPageFactory;
import com.util.Constant;
import com.util.SeleniumWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FinalLoginMethod {
	public void getFinalLogin(){
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get(Constant.URL);
		
		driver.findElement(By.xpath("(//*[@class='authorization-link'])[1]")).click();
		
		driver.findElement(By.xpath("//*[@id='email']")).click();
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(Constant.user);
		
		driver.findElement(By.xpath("(//*[@id='pass'])[1]")).click();
		driver.findElement(By.xpath("(//*[@id='pass'])[1]")).sendKeys(Constant.pass);
		
		driver.findElement(By.xpath("(//*[@name='send'])[1]")).click();
		
		
		
	}
	
	public static void main(String[] args) {
		FinalLoginMethod obj = new FinalLoginMethod();
		obj.getFinalLogin();
	}

}









