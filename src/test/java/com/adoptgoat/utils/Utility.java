package com.adoptgoat.utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.adoptgoat.library.ActionActivities;
	
public class Utility {

	@SuppressWarnings("deprecation")
	public static WebElement checkElementClick(WebDriver driver, By locator) {

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(55, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS).ignoring(Throwable.class);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		return driver.findElement(locator);
	}

	@SuppressWarnings("deprecation")
	public static List<WebElement> checkElementList(WebDriver driver, By locator) {

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(55, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS).ignoring(Throwable.class);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		return driver.findElements(locator);
	}

	public static void wait(int tSeconds) {
		tSeconds = tSeconds * 1000;
		try {
			Thread.sleep(tSeconds);
		} catch (InterruptedException e) {
		}
	}

	public static void clickAction(WebDriver driver, By locator) {
		checkElementClick(driver, locator).click();
		wait(1);
	}

	public static void sendKeysAction(WebDriver driver, By locator, String stringToPass) {
		checkElementClick(driver, locator).sendKeys(stringToPass);
	}

	public static void mouseHoverThenClick(WebDriver driver, By locator1, By locator2) {
		ActionActivities.mouseHoverAndClick(driver, locator1, locator2);
	}

	// AC - Using Submit to click the object
	public static void clickActionSubmit(WebDriver driver, By locator) {
		checkElementClick(driver, locator).submit();
		wait(1);
	}

	public static void Waitforobjectvisible(WebDriver driver, By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5000);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((locator)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clearAction(EventFiringWebDriver driver, By locator) {
		checkElementClick(driver, locator).clear();
		wait(1);
	}
}
