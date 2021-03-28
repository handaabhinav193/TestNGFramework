package com.POMTestNGFramework.qa.utility;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.annotations.ITestAnnotation;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class SuiteListener implements ITestListener, IAnnotationTransformer{
	
	public WebDriver driver;
	
	
    @Override		
    public void onFinish(ITestContext iTestResult) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onStart(ITestContext iTestResult) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailure(ITestResult iTestResult) {					
       String fileName = System.getProperty("user.dir")+File.separator+"Screenshots"+File.separator+iTestResult.getMethod().getMethodName();
       File f;
       if(System.getProperty("environment").equals("qa")) {
    	   f = (File) ((TakesScreenshot) BrowserFactory.startApplication(driver, Constants.appQAURL, System.getProperty("browserName"))).getScreenshotAs(OutputType.FILE);
       }else {
    	   f = (File) ((TakesScreenshot) BrowserFactory.startApplication(driver, Constants.appStageURL, System.getProperty("browserName"))).getScreenshotAs(OutputType.FILE);
       }
       
       try {
    	   FileUtils.copyFile(f, new File(fileName+".png"));
       }catch(Exception e) {
    	   e.printStackTrace();
       }
        		
    }		

    @Override		
    public void onTestSkipped(ITestResult iTestResult) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestStart(ITestResult iTestResult) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestSuccess(ITestResult iTestResult) {					
        // TODO Auto-generated method stub				
        		
    }
    
    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
    	iTestAnnotation.setRetryAnalyzer(RetryAnalyser.class);
    }
}		
