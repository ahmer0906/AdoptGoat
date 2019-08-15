package com.adoptgoat.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BrowserFactory {
	protected WebDriver driver;

	/*
	 * 
	 */
	@BeforeTest
	@Parameters({"browser"})
	public void startBrowser(String browser) {
		switch (browser.toUpperCase()) {
		case "CHROME":
			if (System.getProperty("os.name").toLowerCase().contains("win"))
				System.setProperty("webdriver.chrome.driver",
						DataProviderFactory.getConfigProperty().getValue("WinChromeDriver"));
			else if (System.getProperty("os.name").toLowerCase().contains("unix")
					|| System.getProperty("os.name").toLowerCase().contains("linux"))
				System.setProperty("webdriver.chrome.driver",
						DataProviderFactory.getConfigProperty().getValue("LinuxChromeDriver"));
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--disable-infobars");
			driver = new ChromeDriver(opt);
			browserSetting(driver);
			break;

		case "FIREFOX":
			if (System.getProperty("os.name").toLowerCase().contains("win"))
				System.setProperty("webdriver.gecko.driver",
						DataProviderFactory.getConfigProperty().getValue("WinGeckoDriver"));
			else if (System.getProperty("os.name").toLowerCase().contains("unix")
					|| System.getProperty("os.name").toLowerCase().contains("linux"))
				System.setProperty("webdriver.gecko.driver",
						DataProviderFactory.getConfigProperty().getValue("LinuxGeckoDriver"));
			driver = new FirefoxDriver();
			browserSetting(driver);
			break;

		case "IE":
			System.setProperty("webdriver.ie.driver", DataProviderFactory.getConfigProperty().getValue("IEDriver"));
			driver = new InternetExplorerDriver();
			browserSetting(driver);
			break;

		default:
			Reporter.log("Browser name provided is " + browser + ". And it doesn't seems to be correct...",true);
			Reporter.log("So not proceeding further, shutting down the JVM !!!",true);
			System.exit(0);
		}
		browserSetting(driver);
	}

	/*
	 * 
	 */
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

	/*
	 * 
	 */
	private void browserSetting(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}
}
