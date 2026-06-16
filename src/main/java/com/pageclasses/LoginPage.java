package com.pageclasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	WebDriverWait wait;

	// Locators
	private By Username = By.id("username");
	private By Password = By.id("password");
	private By Login = By.cssSelector("button[name='login']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait= new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void waitForLoginPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Username));
    }
	
	// Actions
	
	public void EnterUserName(String username ) {
		driver.findElement(Username).sendKeys(username);
		
	}
	
	public void EnterPassword(String password) {
		driver.findElement(Password).sendKeys(password);
		
	}
	
	public void ClickOnLoginButton() {
		wait.until(ExpectedConditions.elementToBeClickable(Login)).click();
		
		
	}

}
