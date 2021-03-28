package com.POMTestNGFramework.qa.steps;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.POMTestNGFramework.qa.pages.LoginPage;
import com.POMTestNGFramework.qa.utility.SuiteListener;

/**
 * Once Listener Class(SuiteListener.java) has been defined it is declared on top of Test Class
*/
//@Listeners(SuiteListener.class) 
public class LoginTest extends AbstractBaseClass{

	@Test
	public void login() {
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		Assert.assertTrue(lp.loginApplication(config.getUsername(), config.getPassword()));
	}
	
	@Test
	public void logout() {
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		Assert.assertTrue(lp.logout());
	}

}
