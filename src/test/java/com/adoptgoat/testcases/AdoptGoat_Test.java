/*
 * 
 * @author ahmer
 * 
 */

package com.adoptgoat.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.adoptgoat.factory.BrowserFactory;
import com.adoptgoat.factory.DataProviderFactory;
import com.adoptgoat.pages.AdoptionConfirmation_Page;
import com.adoptgoat.pages.AdoptorDetails_Page;

public class AdoptGoat_Test extends BrowserFactory {

	AdoptorDetails_Page oAdoptorDetails_Page;
	AdoptionConfirmation_Page oAdopAdoptionConfirmation_Page;
	
	@BeforeMethod
	public void beforeEveryTest() {
		driver.get(DataProviderFactory.getConfigProperty().getValue("AppURL"));
	}
	
	@Test(description = "Test to verify Happy path scenario")
	public void adoptGoatHappyPathTest(){
		String sheetName = "AdoptorDetails_Happy";
		oAdoptorDetails_Page = new AdoptorDetails_Page(driver);
		oAdopAdoptionConfirmation_Page = new AdoptionConfirmation_Page(driver);
		
		oAdoptorDetails_Page.firstName(sheetName);
		oAdoptorDetails_Page.lastName(sheetName);
		oAdoptorDetails_Page.emailAddress(sheetName);
		oAdoptorDetails_Page.address(sheetName);
		oAdoptorDetails_Page.optionalAddress(sheetName);
		oAdoptorDetails_Page.country(sheetName);
		oAdoptorDetails_Page.countryState(sheetName);
		oAdoptorDetails_Page.zipCode(sheetName);
		oAdoptorDetails_Page.adoptionDetail();
		oAdoptorDetails_Page.commentSection(sheetName);
		oAdoptorDetails_Page.submission();
		oAdopAdoptionConfirmation_Page.verifyAdoptConfirmation();
	}
	
	@Test(description = "Test to verify Invalid Emaill Address scenario")
	public void adoptGoatNegativeTest(){
		String sheetName = "AdoptorDetails_Negative";
		oAdoptorDetails_Page = new AdoptorDetails_Page(driver);
		
		oAdoptorDetails_Page.firstName(sheetName);
		oAdoptorDetails_Page.lastName(sheetName);
		oAdoptorDetails_Page.emailAddress(sheetName);
		oAdoptorDetails_Page.address(sheetName);
		oAdoptorDetails_Page.optionalAddress(sheetName);
		oAdoptorDetails_Page.country(sheetName);
		oAdoptorDetails_Page.countryState(sheetName);
		oAdoptorDetails_Page.zipCode(sheetName);
		oAdoptorDetails_Page.adoptionDetail();
		oAdoptorDetails_Page.commentSection(sheetName);
		oAdoptorDetails_Page.submission();
		oAdoptorDetails_Page.verifyInvalidEmailAddress();
	}
}
