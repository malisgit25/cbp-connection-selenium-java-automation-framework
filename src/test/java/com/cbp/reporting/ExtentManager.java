package com.cbp.reporting;

import java.io.File;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.cbp.basetest.BaseTest;

public class ExtentManager {

	private static ExtentReports extent;
	protected static Logger log = LogManager.getLogger(ExtentManager.class);

	public static synchronized ExtentReports createInstance() {
		if (extent == null) {
			/*
			 * Date d = new Date(); String fileName = "Extent_" + d.toString().replace(":",
			 * "_").replace(" ", "_") + ".html"; ExtentSparkReporter htmlReporter = new
			 * ExtentSparkReporter( System.getProperty("user.dir") + "/docs/reports/" +
			 * fileName);
			 */	
			
			String reportPath = System.getProperty("user.dir") + "/docs/reports/index.html";

	        // Create folder automatically
	        File reportFile = new File(reportPath);
	        File parentDir = reportFile.getParentFile();

	        if (!parentDir.exists()) {
	            parentDir.mkdirs();
	        }

	        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportPath);
			htmlReporter.config().setTheme(Theme.STANDARD);
			htmlReporter.config().setEncoding("utf-8");
			htmlReporter.config().setReportName("Automation Test Report");
			htmlReporter.config().setDocumentTitle("Test Execution Result");

			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			
			extent.setSystemInfo("Automation Tester", "Mohammad");
			extent.setSystemInfo("Organization", "Test");
			extent.setSystemInfo("Build no", "Automation System 1.0.0");

			log.info("ExtentReports instance created: " + reportPath);
		}
		return extent;
	}

	// Base64 screenshot for thread safety
	public static String captureScreenshotAsBase64() {
		return ((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
}
