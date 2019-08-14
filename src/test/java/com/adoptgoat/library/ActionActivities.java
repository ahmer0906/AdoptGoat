package com.adoptgoat.library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.adoptgoat.utils.Utility;

public class ActionActivities {

	public static void moveToElementForClick(WebDriver driver, By locator) {
		new Actions(driver).moveToElement(Utility.checkElementClick(driver, locator)).pause(1000).click().build()
				.perform();
	}

	public static void mouseHoverAndClick(WebDriver driver, By locator1, By locator2) {
		new Actions(driver).moveToElement(Utility.checkElementClick(driver, locator1)).build().perform();
		Utility.wait(8);
		Utility.checkElementClick(driver, locator2).click();
	}

	public static void selectByVisibleText(WebDriver driver, By locator, String dropdownValue) {
		new Select(Utility.checkElementClick(driver, locator)).selectByVisibleText(dropdownValue);
	}
}
