package com.pageclasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Landingpage {
	WebDriver driver;
	WebDriverWait wait;
	
	public By test = By.id("");
	
	public Landingpage (WebDriver driver) {
		this.driver = driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	}
	
	//Actions
	
	public void test1() {
		
	}

}
