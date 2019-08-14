package com.adoptgoat.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.adoptgoat.reusability.GenericFunctions;

public class Helper {
	
	public String takeScreenshot(WebDriver driver) {
		
		String screenshotstr = "/Screenshots/"+GenericFunctions.currentDateTime()+".png";
		String destinationPath = System.getProperty("user.dir") + screenshotstr ;
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File(destinationPath));
		} catch (IOException e) {
			System.out.println("Error happened while saving screenshot");
		}
		
		return "../" + screenshotstr;
	}
	
	public void scrollToView(WebDriver driver, By locator) {
		Utility.wait(2);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("argument[0].scrollIntoView(true);", Utility.checkElementClick(driver, locator));
		Utility.wait(2);
	}
}
