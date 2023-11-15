package com.sportyshoes.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sportyshoes.base.BaseTest;

public class CartPage extends BaseTest {

	JavascriptExecutor executor = (JavascriptExecutor) driver;

	@FindBy(xpath = "//a[@id='cart101']")
	WebElement addToCartBtn;

	@FindBy(xpath = "//div[@class='alert alert-success']")
	WebElement successMessage;

	@FindBy(xpath = "//a[text()='Home']")
	WebElement homeBtn;

	@FindBy(xpath = "//a[text()='Cart']")
	WebElement cartBtn;

	@FindBy(xpath = "//a[@id='place-order']")
	WebElement placeOrderBtn;

	public CartPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		// driver can now work with your elements and methods of this class
	}

	public void add_To_Cart() {
		
		
		executor.executeScript("arguments[0].click();", addToCartBtn);

	}

	public void print_successMessage() {
		String message = successMessage.getText();
		System.out.println(message);
	}

	public void click_home() {

		executor.executeScript("arguments[0].click();", homeBtn);

	}

	public void click_Cart() {
		executor.executeScript("arguments[0].click();", cartBtn);

	}

	public void click_PlaceOrder() {

		executor.executeScript("arguments[0].click();", placeOrderBtn);

	}

}
