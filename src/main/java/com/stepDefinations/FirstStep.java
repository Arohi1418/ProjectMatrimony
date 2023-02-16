package com.stepDefinations;

import java.awt.Window;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Utils.Fileutils;
import com.Utils.Locator;
import com.keywordDriven.Keywords;
import com.pages.Homepage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FirstStep {
	
  
	
	@Given("open browser")
	public void openBrowser() {
		Keywords.openBrowser("Chrome");
	}

	@When("user enters app url")
	public void launchurl() {
		Keywords.launchUrl("https://www.etsy.com/");
	}

	@Then("maximize browser")
	public void maximizeBrowser() {
		Keywords.maximizeBrowser();
	}

	@Then("verify registration of user")
	public void verifyRegistration() throws InterruptedException {
		Keywords.clickOn("css",
				"button[class=\"wt-btn wt-btn--secondary wt-btn--small inline-overlay-trigger register-header-action select-register\"]");
		Thread.sleep(3000);
        Keywords.enterText("css", "input#join_neu_email_field", "chaudhari.shital18@gmail.com");
        Keywords.enterText("css", "input#join_neu_first_name_field","Shital");
        Keywords.enterText("css", "input#join_neu_password_field", "Arohi14@");
        Keywords.clickOn("css", "button[value=\"register\"]");
        
	}

	@Then("click on sign-in button")
	public void clickonsignbutton() throws InterruptedException {
		Homepage hmpg=new Homepage();
	hmpg.clickOnSignIn();
		Thread.sleep(3000);
	}

	
	@And("enter text in email field")
	public void enterTextInemailField() {
		Homepage hmpg=new Homepage();
		hmpg.enterTextInemailField();
	}

	@Then("enter text in passward field")
	public void enterTextInPassward() {
		Homepage hmpg=new Homepage();
	     hmpg.enterPassWord();
	}

	@Then("again click on sign-in button")
	public void clickOnSignIn() {
		Homepage hmpg=new Homepage();
		hmpg.againClickOnSignButton();
	}
	@Then("verify page title")
	public void verifyPageTitle() {
		String actualTitle=Keywords.driver.getTitle();
		String expectedtitle="Etsy India - Shop for handmade, vintage, custom, and unique gifts for everyone";
		Assert.assertEquals(actualTitle, expectedtitle);
	}

	@Then("search for")
	public void verifySearchFinctionality() {
		Keywords.enterText("css", "input[data-id=\"search-query\"]", "kids toys");
		Keywords.clickOn("css", "button[value=\"Search\"]");
		String actualtitle = Keywords.driver.getTitle();
		String expectedtitle = "Kids toys - Etsy IN";
		Assert.assertEquals(actualtitle, expectedtitle);
	}

	@Then("verify main menu")
	public void verifyMainMenu() {
		//List<String> mainmenues = Keywords.getTexts("css", Fileutils.getLocator("homepage.mainmenues_list"));
		//List<String> mainmenues = Keywords.getTexts("xpath", Fileutils.getLocator("homepage.mainmenues_list"));
		//List<String> mainmenues=Keywords.getTexts("xpath",Locator.homepage_accessories_list);
		Homepage hmpg=new Homepage(); //you can create but pagefactory should be in constructor
	
		List <String> mainmenues=hmpg.getHomepageMenueListTitles();
		System.out.println(mainmenues);
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("Sellers' Sales Hub");
		expected.add("Jewellery & Accessories");
		expected.add("Clothing & Shoes");
		expected.add("Home & Living");
		expected.add("Wedding & Party");
		expected.add("Toys & Entertainment");
		expected.add("Art & Collectibles");
		expected.add("Craft Supplies");
		expected.add("Gifts");
		Assert.assertEquals(mainmenues, expected);

	}
	@And("verify add to basket")
	public void verifyaddtobasket() throws InterruptedException {
		Keywords.clickOn("css", "li.top-nav-item:nth-child(9)");
		Keywords.enterText("css", "input#global-enhancements-search-query", "wall clock");
		Keywords.clickOn("css", "button[value=\"Search\"]");
		Keywords.clickOn("css", "div[data-listing-id=\"707277401\"]");
		Set<String> windows=Keywords.driver.getWindowHandles();
		ArrayList <String>windows1=new ArrayList<String>(windows);
		Keywords.driver.switchTo().window(windows1.get(1));
	    Keywords.SelectDropDownListByVisibleText1( "select#variation-selector-0","Blue");
	    Thread.sleep(3000);
		Keywords.clickOn("css", "div[data-add-to-cart-button]");
		Thread.sleep(3000);
		//Keywords.clickOn("css", "a[data-selector=\"post-atc-overlay-go-to-cart-button\"]");
		
		Keywords.driver.switchTo().window(windows1.get(0));
		Keywords.clearOnElement("css", "input#global-enhancements-search-query");
		Keywords.enterText("css", "input#global-enhancements-search-query", "red dress child");
		Keywords.clickOn("css", "button[value=\"Search\"]");
		Thread.sleep(3000);
		Keywords.clickOn("css", "div[data-palette-listing-id=\"171144094\"]");
		Thread.sleep(3000);
		
		//Keywords.driver.switchTo().window(windows1.get(1));
		//Keywords.driver.switchTo().window(windows1.get());
		Keywords.launchUrl("https://www.etsy.com/in-en/listing/171144094/the-chloe-red-lace-dress-flower-girl?click_key=4e8659ebcd1fb4a435f1bf60e0318873f1ecf51c%3A171144094&click_sum=7e6e7862&ref=search2_top_narrowing_intent_modules_top_rated-1");
		Thread.sleep(3000);
		Keywords.SelectDropDownListByIndex("select#variation-selector-0", 2);
	    Thread.sleep(3000);
		Keywords.clickOn("css","div[data-add-to-cart-button]");
		//Thread.sleep(3000);
		//Keywords.clickOn();*/
		
		
		
		
	}

}
