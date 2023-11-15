package com.sportyshoes.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sportyshoes.base.BaseTest;

public class HomePage extends BaseTest {
	
	@FindBy(xpath = "//a[contains(@href,'register')]")
	WebElement registerLink;
	
	public HomePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		// driver can now work with your elements and methods of this class
	}
	
	
	public void click_register_link() throws InterruptedException {
		Thread.sleep(10000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", registerLink);		
	}
}
