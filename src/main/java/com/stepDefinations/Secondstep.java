package com.stepDefinations;

import com.keywordDriven.Keywords;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Secondstep {
 @Given("click on for profile dropdown list")
 public void varifyDropDownForProfile(){
	 Keywords.SelectDropDownListByVisibleText("css", "div[class=\"col-lg-6 col-md-auto col-6\"]:nth-child(1) label+select", "SISTER");
 }
 @And ("click on gender dropdown list")
 public void varifyDropdownforgender() {
	 Keywords.SelectDropDownListByVisibleText("css", "div[class=\"col-lg-6 col-md-auto col-6\"]:nth-child(2) label+select", "MALE");
 }
 @Then("enter text on first name field")
 public void vatifyfirstnamefield() {
	 Keywords.enterText("css", "input[placeholder=\"First name\"]", "Snehal");
 }
 @Then("enter text on last name field")
 public void vatifylastnamefield() {
	Keywords.enterText("css", "input[name=\"lastName\"]", "Patil"); 
	 
	 }
 @And ("enter mobile number")
 public void varifyMobileNofield() throws InterruptedException {
	 Keywords.enterText("css", "input[name=\"mobile01\"]", "9146986526");
	 
 }
 /*@Then("clear on date of birth")
 public void verifyDateOfBirth() throws InterruptedException {
	 Thread.sleep(3000);
	 Keywords.clearOnElement("css", "div[class=\"react-date-picker__inputGroup\"]");
 }*/
 @Then("enter email on email field")
 public void varifyEmailField() throws InterruptedException {
	 Thread.sleep(3000);
	 Keywords.enterText("xpath", "//input[@name=\"email\"]", "def@abyssmail.com");
 }
 @Then("enter password on password field")
 public void varifyPasswordField() {
	 Keywords.enterText("css", "input[name=\"password\"]", "abc@1234");
 }
 @Then("click on register profile")
 public void varifyregistration() {
	 Keywords.clickOn("css", "button[class=\"registerSubmit btn btn-danger btn-lg\"]");
 }
 @Then("")
 
 
 
 
 
 
 
}
