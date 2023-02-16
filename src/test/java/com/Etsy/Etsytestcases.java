package com.Etsy;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
@Test
public class Etsytestcases {
	public void addToBasket() throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.etsy.com");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()=\"Gifts\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@type=\"submit\"])[1]")).sendKeys("PinkandWhiteAbstractEpoxyResinWallClockForHomeDecor");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h3[contains(text(),'PinkandWhiteAbstractEpoxyResinWallClockForHomeDecor')]"))
				.click();
		driver.get(
		"https://www.etsy.com/in-en/listing/1253473866/pinkandwhiteabstractepoxyresinwallclockf?click_key=c7864a827661b5af8daf3dbe1c9c3b1b028ccc5d%3A1253473866&click_sum=6cf48925&external=1&ref=finds_l-5&pro=1&frs=1");
		ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs1.get(1));
		WebElement list = driver.findElement(By.xpath("//select[@id=\"variation-selector-0\"]"));

		Select size = new Select(list);
		size.selectByIndex(2);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Add to basket')]")).click();
		String expectedTitle = "Buy Pinkandwhiteabstractepoxyresinwallclockforhomedecor Online in India - Etsy";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);

		driver.switchTo().window(tabs1.get(1));
		driver.findElement(By.xpath("//span[@id=\"catnav-primary-link-10923\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"//h3[contains(text(),\"OFF-WHITE X FORCE1 LOW, Custom Sneakers, Sneakers For Women, Men's Shoes\")]"))
				.click();
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs1.get(2));
		driver.findElement(By.xpath("//textarea[@id=\"listing-page-personalization-textarea\"]")).sendKeys("black");
		driver.findElement(By.xpath("//button[contains(text(),' Add to basket')]")).click();
		String expectedTitle1 = "Etsy - Shopping basket";
		String actualTitle1 = driver.getTitle();
		Assert.assertEquals(actualTitle1, expectedTitle1);
	}
	
	
	

}
