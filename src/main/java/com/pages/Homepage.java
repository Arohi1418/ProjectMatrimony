package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.keywordDriven.Keywords;

public class Homepage {
	
	public Homepage() {
		 PageFactory.initElements(Keywords.driver,this);
	}
	@FindBy(css="button.select-signin")
	public WebElement Signin;
	public void clickOnSignIn() {
		Signin.click();
	}
	@FindBy(css="input[id=\"join_neu_email_field\"]")
	public WebElement EmailId;
	public void enterTextInemailField() {
		EmailId.sendKeys("chaudhari.shital18@gmail.com");
	}
	@FindBy(css="input#join_neu_password_field")
	public WebElement password;
	public void enterPassWord() {
		password.sendKeys("Arohi14@");
	}
	@FindBy(css="button[value=\"sign-in\"]")
	public WebElement signButton;
	public void againClickOnSignButton() {
		signButton.click();
	}
	
	
	@FindBy(xpath = "//li[@class=\"top-nav-item wt-pb-xs-2 wt-mr-xs-2 wt-display-flex-xs wt-align-items-center\"]")
	public  List<WebElement> homepageMenueList;
	
   @FindBy(xpath= "//span[contains(text(),'Clothing & Shoes')]")                                                 
	public WebElement clothingAndshoes;
   
   public void hoverOnClothingAndShoes() {
	  Keywords.hoverOnWebElement(clothingAndshoes); 
   }
  /* public Homepage(){
	   PageFactory.initElements(Keywords.driver,Homepage.class);
	   }*/

	public  List<String> getHomepageMenueListTitles() {
		List<String> allMenueTitles = new ArrayList<String>();
		for (WebElement menue : homepageMenueList){
			allMenueTitles.add(menue.getText());
		}
		return allMenueTitles;

	}

	
}
