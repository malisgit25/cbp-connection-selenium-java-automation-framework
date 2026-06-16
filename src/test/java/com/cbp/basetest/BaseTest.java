package com.cbp.basetest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.cbp.listeners.ExtentListener;
import com.cbp.reporting.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(ExtentListener.class)
public class BaseTest {

	protected static WebDriver driver;
	public static ExtentReports extent = ExtentManager.createInstance();
	protected static ExtentTest test;
	protected static Properties config = new Properties();

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setTest(ExtentTest extentTest) {
        test = extentTest;
    }

    public static ExtentTest getTest() {
        return test;
    }
	@BeforeMethod(alwaysRun = true)
	public void setup() {

		if (config.isEmpty()) {
			try (FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/Properties/config.properties")) {

				config.load(fis);

			} catch (IOException e) {
				throw new RuntimeException("Unable to load config.properties", e);
			}
		}

		String browser = config.getProperty("browser").trim().toLowerCase();

		// Browser launch
		switch (browser) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			throw new RuntimeException("Unsupported browser: " + browser);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(config.getProperty("url"));
	}

	/*
	 * @AfterMethod(alwaysRun = true) public void tearDown() {
	 * 
	 * if (driver != null) { driver.quit(); driver = null; } }
	 */
}