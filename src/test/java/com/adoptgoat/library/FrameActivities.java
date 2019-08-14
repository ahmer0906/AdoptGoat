package com.adoptgoat.library;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.adoptgoat.utils.Utility;

public class FrameActivities {

	public void switchToFrameByName(EventFiringWebDriver driver, String nameOrID) {
		Utility.wait(2);
		driver.switchTo().frame(nameOrID);
		Utility.wait(4);
	}

	public void switchToDefaultContent(EventFiringWebDriver driver) {
		driver.switchTo().defaultContent();
		Utility.wait(2);
	}
}
