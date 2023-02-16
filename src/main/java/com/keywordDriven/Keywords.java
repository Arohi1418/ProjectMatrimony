package com.keywordDriven;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class Keywords {

	public static RemoteWebDriver driver;
	public static ChromeOptions options = new ChromeOptions();

	public static void openBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		} else if (browserName.equalsIgnoreCase("IntenetExplorer")) {
			driver = new InternetExplorerDriver();
		} else if (browserName.equalsIgnoreCase("MicrosoftEdge")) {
			driver = new EdgeDriver();
		} else {
			System.err.println("Invalid browser name" + browserName);
		}

	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static void waitforElement(By element) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(30));
		wait.pollingEvery(Duration.ofMillis(1000));
		wait.ignoring(NoSuchElementException.class);

	}

	public void mouseHover(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.build();
		actions.perform();
	}

	public static void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public static void hoverOnWebElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();

	}

	public static void clickOn(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}

	public static void sendKeys(String xpath, String keys) {
		driver.findElement(By.xpath(xpath)).sendKeys(keys);
	}

	public static void tearDown() {
		driver.quit();
	}

	public static void SelectDropDownListByIndex(String css, int index) {
		WebElement webelement = driver.findElement(By.cssSelector(css));
		Select select = new Select(webelement);
		select.selectByIndex(index);
	}

	public static void SelectDropDownListByIndex1(String xpath, int index) {
		WebElement webelement = driver.findElement(By.xpath(xpath));
		Select select = new Select(webelement);
		select.selectByIndex(index);
	}

	public static void SelectDropDownListByVisibleText(String locatorType, String locatorValue, String text) {
		WebElement element;
		if (locatorType.equalsIgnoreCase("id")) {
			element = driver.findElement(By.id(locatorValue));
			Select select = new Select(element);
			select.selectByVisibleText(text);
		} 
		else if (locatorType.equalsIgnoreCase("className")) {
			element = driver.findElement(By.className(locatorValue));
			Select select = new Select(element);
			select.selectByVisibleText(text);
		}

		else if (locatorType.equalsIgnoreCase("name")) {
			element = driver.findElement(By.name(locatorValue));
			Select select = new Select(element);
			select.selectByVisibleText(text);

		} else if (locatorType.equalsIgnoreCase("partialLinkTex")) {
			element = driver.findElement(By.partialLinkText(locatorValue));
			Select select = new Select(element);
			select.selectByVisibleText(text);

		} else if (locatorType.equalsIgnoreCase("linkText")) {
			element = driver.findElement(By.linkText(locatorValue));
			Select select = new Select(element);
			select.selectByVisibleText(text);

		} else if (locatorType.equalsIgnoreCase("tagName")) {
			element = driver.findElement(By.tagName(locatorValue));
			Select select = new Select(element);
			select.selectByVisibleText(text);

		} else if (locatorType.equalsIgnoreCase("xpath")) {
			element = driver.findElement(By.xpath(locatorValue));
			Select select = new Select(element);
			select.selectByVisibleText(text);

		} else if (locatorType.equalsIgnoreCase("css")) {
			element = driver.findElement(By.cssSelector(locatorValue));
			Select select = new Select(element);
			select.selectByVisibleText(text);

		}

	}

	public static void SelectDropDownListByVisibleText1(String css, String text1) {
		WebElement webelement1 = driver.findElement(By.cssSelector(css));
		Select select1 = new Select(webelement1);
		select1.selectByVisibleText(text1);

	}

	public static String getText(WebElement element) {
		return element.getText();

	}

	public static String getText(String locatorType, String locatorValue) {
		return getWebElement(locatorType, locatorValue).getTagName();
	}

	public static List<String> getTexts(String locatorType, String locatorValue) {
		List<String> texts = new ArrayList<String>();
		List<WebElement> elements = new ArrayList<WebElement>();

		if (locatorType.equalsIgnoreCase("id"))
			elements = driver.findElements(By.id(locatorValue));
		else if (locatorType.equalsIgnoreCase("className"))
			elements = driver.findElements(By.className(locatorValue));
		else if (locatorType.equalsIgnoreCase("name"))
			elements = driver.findElements(By.name(locatorValue));
		else if (locatorType.equalsIgnoreCase("tagName"))
			elements = driver.findElements(By.tagName(locatorValue));
		else if (locatorType.equalsIgnoreCase("partialLinkText"))
			elements = driver.findElements(By.partialLinkText(locatorValue));
		else if (locatorType.equalsIgnoreCase("linkText"))
			elements = driver.findElements(By.linkText(locatorValue));
		else if (locatorType.equalsIgnoreCase("xpath"))
			elements = driver.findElements(By.xpath(locatorValue));
		else if (locatorType.equalsIgnoreCase("css"))
			elements = driver.findElements(By.cssSelector(locatorValue));
		else
			return null;

		for (WebElement element : elements) {
			texts.add(element.getText());
		}
		return texts;

	}

	public static void enterText(String locatorType, String locatorValue, String textToEnter) {
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
	}

	public static WebElement getWebElement(String locatorType, String locatorValue) {
		if (locatorType.equalsIgnoreCase("id"))
			return driver.findElement(By.id(locatorValue));
		else if (locatorType.equalsIgnoreCase("className"))
			return driver.findElement(By.className(locatorValue));
		else if (locatorType.equalsIgnoreCase("name"))
			return driver.findElement(By.name(locatorValue));
		else if (locatorType.equalsIgnoreCase("partialLinkTex"))
			return driver.findElement(By.partialLinkText(locatorValue));
		else if (locatorType.equalsIgnoreCase("linkText"))
			return driver.findElement(By.linkText(locatorValue));
		else if (locatorType.equalsIgnoreCase("tagName"))
			return driver.findElement(By.tagName(locatorValue));
		else if (locatorType.equalsIgnoreCase("xpath"))
			return driver.findElement(By.xpath(locatorValue));
		else if (locatorType.equalsIgnoreCase("css"))
			return driver.findElement(By.cssSelector(locatorValue));
		else
			return null;

	}

	public static void handleNotification() {
		ChromeOptions options = new ChromeOptions();
		ChromeDriver driver = new ChromeDriver(options);
		options.addArguments("--allow-notifications");

	}

	public static void clearOnElement(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).clear();
	}

	public static void scrollWindow(int pixels) {
		driver.executeScript("window.scrollBy(0,arguments[0])", pixels);
	}

}
