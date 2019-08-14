/*
 * 
 * @author ahmer
 * 
 */

package com.adoptgoat.testcases;

import org.testng.annotations.Test;

import com.adoptgoat.factory.BrowserFactory;
import com.adoptgoat.pages.AdoptorDetails_Page;

public class AdoptGoat_Test extends BrowserFactory {

	AdoptorDetails_Page oAdoptorDetails_Page;
	
	@Test
	public void adoptGoatHappyPathTest(){
		oAdoptorDetails_Page = new AdoptorDetails_Page(driver);
		oAdoptorDetails_Page.firstName();
		oAdoptorDetails_Page.lastName();
		oAdoptorDetails_Page.emailAddress();
		oAdoptorDetails_Page.address();
		oAdoptorDetails_Page.optionalAddress();
		oAdoptorDetails_Page.country();
		oAdoptorDetails_Page.countryState();
		oAdoptorDetails_Page.zipCode();
		oAdoptorDetails_Page.adoptionDetail();
		oAdoptorDetails_Page.commenstSection();
		oAdoptorDetails_Page.submission();
		
	}
	
	@Test
	public void adoptGoatHappyTest(){
		
		
	}
}
