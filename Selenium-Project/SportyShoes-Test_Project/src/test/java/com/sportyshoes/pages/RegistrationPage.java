package com.sportyshoes.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sportyshoes.base.BaseTest;

public class RegistrationPage extends BaseTest {

	
	@FindBy(xpath="//input[@id='name']")
	WebElement nameField;
	
	
	@FindBy(xpath="//input[@id='email']")
	WebElement emailField;
	
	
	@FindBy(xpath="//input[@id='password']")
	WebElement passwordField;
	
	
	@FindBy(xpath="//button[text()='Register']")
	WebElement registerButton;
	
	public void giveName(String name) {
		nameField.sendKeys(name);
	}
	
	public void giveEmail(String email) {
		emailField.sendKeys(email);
	}
	
	public void givePassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void click_Submit() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", registerButton);	
		
	}
	
	public RegistrationPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		// driver can now work with your elements and methods of this class
	}
	
}
