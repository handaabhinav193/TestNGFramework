package com.POMTestNGFramework.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.POMTestNGFramework.qa.utility.ReportGeneration;

public class LoginPage{
	
	WebDriver driver;
		
	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}
	
	@FindBy(how=How.XPATH, using="//span[text()='Log In']/parent::a")
	public WebElement loginBtn;
	
	@FindBy(how=How.XPATH, using="//input[@name='email']")
	public WebElement userTextBox;
	
	@FindBy(how=How.XPATH, using="//input[@name='password']")
	public WebElement passTextBox;
	
	@FindBy(how=How.XPATH, using="//div[text()='Login']")
	public WebElement finalloginBtn;
	
	@FindBy(how=How.XPATH, using="//div[@class='right menu']/span[1]")
	public WebElement profileOwner;
	
	public boolean loginApplication(String appUserName, String appPassword) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginBtn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		userTextBox.sendKeys(appUserName);
		passTextBox.sendKeys(appPassword);
		finalloginBtn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(profileOwner.getText().equals("Abhinav Handa")) {
			ReportGeneration.logger = ReportGeneration.report.createTest("APPLICATION LOGIN");
			ReportGeneration.logger.pass("LOGIN PASS");
			return true;	
		}else {
			ReportGeneration.logger.pass("LOGIN FAIL");
			return false;
		}
	}
	
	public boolean logout() {
		ReportGeneration.logger = ReportGeneration.report.createTest("APPLICATION LOGOUT");
		ReportGeneration.logger.fail("LOGOUT FAIL");
		return true;
	}

}
