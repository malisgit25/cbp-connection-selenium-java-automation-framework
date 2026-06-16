package com.cbp.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pageclasses.ScreenShotPage;
import com.aventstack.extentreports.Status;
import com.cbp.basetest.BaseTest;
import com.cbp.utilities.DataDrivernUtility;
import com.pageclasses.Homepage;
import com.pageclasses.Landingpage;
import com.pageclasses.LoginPage;

public class LoginTest extends BaseTest {

	@DataProvider(name = "getdata")
	public Object[][] getdata() {
		return DataDrivernUtility.getdata("logindata");
	}

	@Test(dataProvider = "getdata", description = "Logitest")
	public void Login(String username, String password) {
		ScreenShotPage screenshot = new ScreenShotPage(getDriver());
		
		Homepage homepage = new Homepage(getDriver());
		LoginPage login = new LoginPage(getDriver());
		Landingpage landingpage = new Landingpage(getDriver());
		
		//==============================================
		//				1) Home page
		//===============================================
		
		homepage.waitForHomePage();
		screenshot.HomePageScreenShot();
		homepage.clickOnLoginButton();
		test.log(Status.INFO, "Click on login button");
		login.waitForLoginPage();
		screenshot.LoginPageScreenShot();
		
		//==============================================
		//				2) Login page
		//===============================================
		
		login.EnterUserName(username);
		test.log(Status.INFO, "Enter Username");
		
		login.EnterPassword(password);
		test.log(Status.INFO, "Enter Password");
		
		login.ClickOnLoginButton();
		test.log(Status.INFO, "Click on Login button");
		
		
		
		//=============================================== 
		//				Assertion
		//===============================================
		Assert.assertTrue(getDriver().getCurrentUrl().contains("search")); //replace the search srting by actual application value string
		Assert.assertEquals(getDriver().getTitle(), "Dashboard - Home"); // Note: use whatever assertion is application based on the application
		//==============================================
		//				3) Landing page
		//===============================================
		
		
				

		

	}

}
