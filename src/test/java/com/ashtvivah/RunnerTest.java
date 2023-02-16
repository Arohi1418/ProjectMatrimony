package com.ashtvivah;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/Features",glue="com/stepDefinations")
public class RunnerTest extends AbstractTestNGCucumberTests{
      
}
