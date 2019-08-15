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

import com.adoptgoat.dataprovider.ExcelDataProvider;
import com.adoptgoat.library.ActionActivities;
import com.adoptgoat.utils.Utility;

public class AdoptorDetails_Page {
	
	WebDriver driver;
	ExcelDataProvider oExcelDataProvider;
	
	By FirstName = By.id("firstName");
	By LastName = By.id("lastName");
	By EmailAddress = By.id("email");
	By WrongEmailAddressMessage = By.xpath("//*[contains(text(),'valid email')]");
	By Address = By.id("address");
	By OptionalAddress = By.id("address2");
	By Country = By.id("country");
	By State = By.id("state");
	By Zipcode = By.id("zip");
	By AdoptionDetails = By.xpath("//*[contains(text(),'love goats')]");
	By Comments = By.xpath("//textarea");
	By SubmitNow = By.xpath("//button[text()='Adopt Now']");
	
	public AdoptorDetails_Page(WebDriver driver) {
		this.driver = driver;
		oExcelDataProvider = new ExcelDataProvider("./Data/Data.xlsx");
	}
	
	public void firstName(String sheetName){
		Utility.clickAction(driver, FirstName);
		Utility.sendKeysAction(driver, FirstName, oExcelDataProvider.getCellData(sheetName, 2, 2));
		Reporter.log("First Name filled in form", true);
	}
	
	public void lastName(String sheetName){
		Utility.sendKeysAction(driver, LastName, oExcelDataProvider.getCellData(sheetName, 2, 3));
		Reporter.log("Last Name filled", true);
	}
	
	public void emailAddress(String sheetName){
		Utility.sendKeysAction(driver, EmailAddress, oExcelDataProvider.getCellData(sheetName, 2, 4));
	}
	
	public void address(String sheetName){
		Utility.sendKeysAction(driver, Address, oExcelDataProvider.getCellData(sheetName, 2, 5));
		Reporter.log("Address submitted", true);
	}
	
	public void optionalAddress(String sheetName){
		Utility.sendKeysAction(driver, OptionalAddress, oExcelDataProvider.getCellData(sheetName, 2, 6));
		Reporter.log("Options address submitted ", true);
	}
	
	public void country(String sheetName){
		ActionActivities.selectByVisibleText(driver, Country, oExcelDataProvider.getCellData(sheetName, 2, 7));
		Reporter.log("Country selected as "+oExcelDataProvider.getCellData(sheetName, 2, 7), true);
	}
	
	public void countryState(String sheetName){
		ActionActivities.selectByVisibleText(driver, State, oExcelDataProvider.getCellData(sheetName, 2, 8));
		Reporter.log("State selected as "+oExcelDataProvider.getCellData(sheetName, 2, 8),true);
	}
	
	public void zipCode(String sheetName){
		Utility.sendKeysAction(driver, Zipcode, oExcelDataProvider.getCellData(sheetName, 2, 9));
		Reporter.log("Zipcode filled",true);
	}
	
	public void adoptionDetail(){
		Utility.clickAction(driver, AdoptionDetails);
		Reporter.log("Selection of Adoption details",true);
	}
	
	public void commentSection(String sheetName){
		Utility.sendKeysAction(driver, Comments, oExcelDataProvider.getCellData(sheetName, 2, 10));
		Reporter.log("Submission of comments",true);
	}
	
	public void submission(){
		Utility.clickAction(driver, SubmitNow);
		Reporter.log("Submission of form",true);
	}
	
	public void verifyInvalidEmailAddress(){
		Assert.assertTrue(Utility.checkElementClick(driver, WrongEmailAddressMessage).isDisplayed());
		Reporter.log("Verified invalid Email Address message",true);
	}
}