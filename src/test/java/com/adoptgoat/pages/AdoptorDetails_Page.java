/*
 * 
 * @author ahmer
 * 
 */

package com.adoptgoat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.adoptgoat.library.ActionActivities;
import com.adoptgoat.utils.Utility;

public class AdoptorDetails_Page {
	
	WebDriver driver;
	
	By FirstName = By.xpath("");
	By LastName = By.xpath("");
	By EmailAddress =  By.xpath("");
	By Address = By.xpath("");
	By OptionalAddress = By.xpath("");
	By Country = By.xpath("");
	By State = By.xpath("");
	By Zipcode = By.xpath("");
	By AdoptionDetails = By.xpath("//*[contains(text(),'love goats')]");
	By Comments = By.xpath("//textarea");
	By SubmitNow = By.xpath("//button[text()='Adopt Now']");
	
	public AdoptorDetails_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	public void firstName(){
		Utility.sendKeysAction(driver, FirstName, "Firstname");
	}
	
	public void lastName(){
		Utility.sendKeysAction(driver, LastName, "Lastname");
	}
	
	public void emailAddress(){
		Utility.sendKeysAction(driver, EmailAddress, "email@address.com");
	}
	
	public void address(){
		Utility.sendKeysAction(driver, Address, "Address Line");
	}
	
	public void optionalAddress(){
		Utility.sendKeysAction(driver, OptionalAddress, "Optional Address");
	}
	
	public void country(){
		ActionActivities.selectByVisibleText(driver, Country, "");
	}
	
	public void countryState(){
		ActionActivities.selectByVisibleText(driver, State, "");
	}
	
	public void zipCode(){
		Utility.sendKeysAction(driver, Zipcode, "");
	}
	
	public void adoptionDetail(){
		Utility.clickAction(driver, AdoptionDetails);
	}
	
	public void commenstSection(){
		Utility.sendKeysAction(driver, Comments, "");
	}
	
	public void submission(){
		Utility.clickAction(driver, SubmitNow);
	}
	
}