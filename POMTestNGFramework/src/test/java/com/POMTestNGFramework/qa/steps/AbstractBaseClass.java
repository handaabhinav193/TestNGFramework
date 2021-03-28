package com.POMTestNGFramework.qa.steps;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.POMTestNGFramework.qa.utility.BrowserFactory;
import com.POMTestNGFramework.qa.utility.ReportGeneration;
import com.POMTestNGFramework.qa.utility.ConfigDataProvider;
import com.POMTestNGFramework.qa.utility.Constants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class AbstractBaseClass {

	public WebDriver driver;
	public ConfigDataProvider config;

	public ExtentReports report;
	public ExtentTest logger;
	public ReportGeneration generateReport;

	@BeforeSuite
	public void dataSetUp() {
		Reporter.log("Reporting Class");

		config = new ConfigDataProvider();
		generateReport = new ReportGeneration();
	}

	@Parameters({"browserName","environment"})
	@BeforeClass
	public void startTestSession(String browser, String env) {
		// driver = BrowserFactory.startApplication(driver, Constants.appURL, Constants.browserName);
		driver = BrowserFactory.startApplication(driver, env, browser);
	}

	@AfterClass
	public void closeTestSession() {
		BrowserFactory.closeApplication(driver);
	}

	@AfterMethod
	public void reporting() {
		ReportGeneration.report.flush();
	}

}
