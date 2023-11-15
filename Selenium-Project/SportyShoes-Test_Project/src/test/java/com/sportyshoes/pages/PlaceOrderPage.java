package com.sportyshoes.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sportyshoes.base.BaseTest;

public class PlaceOrderPage extends BaseTest {
	
	
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	WebElement successMessage;
	
	public PlaceOrderPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		// driver can now work with your elements and methods of this class
	}
	
	public void Print_success_Message() {
		String mesg=successMessage.getText();
		System.out.println(mesg);
	}
	
}
