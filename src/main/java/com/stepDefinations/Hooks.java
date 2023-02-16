package com.stepDefinations;

import com.keywordDriven.Keywords;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
   @Before
   public void setup() {
	   String env=System.getProperty("env");
		System.out.println("Environment:"+env);
       Keywords.openBrowser("chrome");
	   Keywords.launchUrl("https://ashtvivah.com/");
	   Keywords.maximizeBrowser();
	   
   }
   @After
   public void tearDown() {
	   Keywords.tearDown();
   }
}
