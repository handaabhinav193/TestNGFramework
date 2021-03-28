package com.POMTestNGFramework.qa.utility;

import java.io.File;

public interface Constants {
	
	//public String browserName = "Chrome";
	public String appQAURL ="https://freecrm.com/";
	public String appStageURL ="https://freecrm.com/";
	public String testExecutionReportPath = System.getProperty("user.dir")+File.separator+"Reports"+File.separator+"XactlyProject_Report_"+ReportGeneration.getCurrentDate()+".html";

}
