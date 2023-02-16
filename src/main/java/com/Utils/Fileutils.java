package com.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Fileutils {
	/**
	 * Use this method to get the locators from OR.properties file. Pass the key of Locator that you want
	 *  @param locator key of locator
	 * @return value of locator
	 */
public static String getLocator(String locator){
	String baseDir=System.getProperty("user.dir"); //CWD or PWD
	String locatorValue="";
	try {
		FileInputStream fis =new FileInputStream(baseDir+"/src/main/resources/OR.properties");
		Properties prop=new Properties();
		prop.load(fis);
		locatorValue=prop.getProperty(locator);
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		catch(IOException e) {
			
		}
	return locatorValue;
	}

	
}



