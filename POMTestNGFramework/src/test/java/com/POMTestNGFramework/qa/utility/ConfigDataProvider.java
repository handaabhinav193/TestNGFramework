package com.POMTestNGFramework.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	Properties prop;

	public ConfigDataProvider() {

		File src = new File(
				System.getProperty("user.dir") + File.separator + "Config" + File.separator + "qa.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("FILE NOT FOUND");
		}
	}

	public String getUsername() {
		return prop.getProperty("qaUserName");
	}

	public String getPassword() {
		return prop.getProperty("qaPassword");
	}

}
