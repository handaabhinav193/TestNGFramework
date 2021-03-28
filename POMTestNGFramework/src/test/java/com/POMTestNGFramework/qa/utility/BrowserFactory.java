package com.POMTestNGFramework.qa.utility;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	public static WebDriver startApplication(WebDriver driver, String appURL, String browser) {
		switch(browser) {
		case "Chrome":
			System.out.println();
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"Drivers"+File.separator+"chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "Firefox":
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+File.separator+"Drivers"+File.separator+"geckodriver.exe");
			driver  = new FirefoxDriver();
			break;
		case "IE":
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+File.separator+"Drivers"+File.separator+"IEDriverServer.exe");
			driver  = new InternetExplorerDriver();
			break;
			default:
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"Drivers"+File.separator+"chromedriver.exe");
				driver = new ChromeDriver();
				
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		if(appURL.equals("qa")) {
			System.out.println("QA ENV");
			driver.get(Constants.appQAURL);
		}else {
			System.out.println("STAGE ENV");
			driver.get(Constants.appStageURL);
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void closeApplication(WebDriver driver) {
		driver.close();
	}

}
