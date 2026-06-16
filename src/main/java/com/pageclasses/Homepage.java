package com.pageclasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {

	private WebDriver driver;
	private WebDriverWait wait;

	// Locator
	public By Login = By.cssSelector("span.subtitle.white");

	
	public Homepage (WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	public void waitForHomePage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Login));
    }
	
	//Actions
	public void waitForLoginPage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Login));
	}

	public void clickOnLoginButton() {
		driver.findElement(Login).click();
	}
}
