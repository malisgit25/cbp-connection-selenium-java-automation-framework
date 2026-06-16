package com.cbp.utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtility {

	public static void capturescreenshot(WebDriver driver, String screenshootName) {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./Screenshots/" + screenshootName + ".png"));

		} catch (Exception e) {

			System.out.println("Exception occured" + e.getMessage());
		}

	}

}
