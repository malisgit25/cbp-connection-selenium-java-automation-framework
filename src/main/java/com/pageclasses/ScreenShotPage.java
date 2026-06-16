package com.pageclasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import com.gdit.utilities.ScreenShotUtility;

public class ScreenShotPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	public ScreenShotPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	private void waitForStableDOM() {

		wait.until(d -> ((JavascriptExecutor) d)
                .executeScript("return document.readyState")
                .equals("complete"));
	}	
	
	public void HomePageScreenShot() {
		waitForStableDOM();
		ScreenShotUtility.capturescreenshot(driver, "01-HomePage");
		System.out.println("Screenshot - 01- HomePage");
	}

	public void LoginPageScreenShot() {
		waitForStableDOM();
		ScreenShotUtility.capturescreenshot(driver, "02-LoginPage");
		System.out.println("Screenshot - 02- LoginPage");
	}

	public void LandingPageScreenShot() {
		waitForStableDOM();
		ScreenShotUtility.capturescreenshot(driver, "03-LandingPage");
		System.out.println("Screenshot - 03- LandingPage");
	}

}
