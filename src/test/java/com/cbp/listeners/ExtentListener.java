package com.cbp.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.cbp.basetest.BaseTest;
import com.cbp.reporting.ExtentManager;

public class ExtentListener implements ITestListener {

	private static ExtentReports extent = BaseTest.extent;

	
	@Override
	public void onTestStart(ITestResult result) {

		ExtentTest extentTest = extent
				.createTest(result.getTestClass().getName() + " - " + result.getMethod().getMethodName());

		BaseTest.setTest(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		if (BaseTest.getTest() == null)
			return;

		BaseTest.getTest().log(Status.PASS,
				MarkupHelper.createLabel(result.getMethod().getMethodName() + " PASSED", ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {

		if (BaseTest.getTest() == null)
			return;

		BaseTest.getTest().fail(result.getThrowable());

		try {

			String base64 = ExtentManager.captureScreenshotAsBase64();

			BaseTest.getTest().fail("Screenshot of Failure",
					MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());

		} catch (Exception e) {

			BaseTest.getTest().warning("Screenshot capture failed: " + e.getMessage());
		}

		BaseTest.getTest().log(Status.FAIL, MarkupHelper.createLabel("TEST CASE FAILED", ExtentColor.RED));
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		if (BaseTest.getTest() == null)
			return;

		BaseTest.getTest().log(Status.SKIP, MarkupHelper.createLabel("TEST CASE SKIPPED", ExtentColor.YELLOW));
	}

	@Override
	public void onFinish(ITestContext context) {
		if (extent != null) {
			extent.flush();
		}
	}
}