package com.POMTestNGFramework.qa.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportGeneration {

	public static ExtentReports report;
	public static ExtentTest logger;

	public ReportGeneration() {
		/**
		 * ExtentHtmlReporter is only available in 4.0.0 dependency. It is used to
		 * define the path of the automation report where it would be stored.
		 * 
		 * ExtentReports: For Generating reports
		 * 
		 */
		ExtentHtmlReporter automationReportPath = new ExtentHtmlReporter(new File(Constants.testExecutionReportPath));
		report = new ExtentReports();
		// For attaching the report the defined path
		report.attachReporter(automationReportPath);
	}

	public static String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
		String strDate = formatter.format(date);
		return strDate;
	}
}
