package com.sportyshoes.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sportyshoes.base.BaseTest;

public class LoginPage extends BaseTest{

	
	
	@FindBy(xpath="//button[text()='Login']")
	WebElement login;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logout;
	
	
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	
	
	public LoginPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		// driver can now work with your elements and methods of this class
	}
	
	public void logout() {
		logout.click();
	}
	
	public void click_login() {
		login.click();
	}
	
	public void give_email(String email_value) {
		email.sendKeys(email_value);
	}
	
	public void give_password(String password_value ) {
		password.sendKeys(password_value);
	}
	
	
}
