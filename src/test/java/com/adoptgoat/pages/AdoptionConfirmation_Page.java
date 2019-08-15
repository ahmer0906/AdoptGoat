/*
 * 
 * @author ahmer
 * 
 */

package com.adoptgoat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.adoptgoat.utils.Utility;

public class AdoptionConfirmation_Page {
	
	WebDriver driver;
	
	By AdoptionConfirmMessage = By.xpath("//h2");
	
	public AdoptionConfirmation_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	public void verifyAdoptConfirmation(){
		Assert.assertTrue(Utility.checkElementClick(driver, AdoptionConfirmMessage).isDisplayed());
		Reporter.log("Adoption form has been submitted successfully", true);
	}
	
}