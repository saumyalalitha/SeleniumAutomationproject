package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.ProjectBase;
import constants.Messages;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTestCase extends ProjectBase {

	@Test(groups = { "smoke" }, description = "user login with valid username and valid password", priority = 0)
	public void userLoginWithValidUsernameandValidPassword() throws IOException {

		
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickRememberCheckbox();
		loginpage.clickSignInButton();
		boolean isDashboardDisplayed = loginpage.isDashboardDisplayed();
		Assert.assertTrue(isDashboardDisplayed, Messages.ELEMENTNOTFOUND);

	}

	@Test(description = "user login with valid username and invalid password", priority = 1)
	public void userLoginWithValidUsernameandInvalidPassword() throws IOException {
		String username = ExcelUtility.readStringData(2, 0, "Login");
		String password = ExcelUtility.readStringData(2, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickRememberCheckbox();
		loginpage.clickSignInButton();
		boolean isAlertboxErrorMessageDisplayed = loginpage.isAlertboxErrorMessageDisplayed();
		Assert.assertTrue(isAlertboxErrorMessageDisplayed, Messages.ELEMENTNOTFOUND);

	}

	@Test(groups = { "smoke" }, description = "user login with invalid username and valid password", priority = -1) // grouping
	public void userLoginWithInvalidUsernameandValidPassword() throws IOException {
		String username = ExcelUtility.readStringData(3, 0, "Login");
		String password = ExcelUtility.readStringData(3, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickRememberCheckbox();
		loginpage.clickSignInButton();
		boolean isAlertboxErrorMessageDisplayed = loginpage.isAlertboxErrorMessageDisplayed();
		Assert.assertTrue(isAlertboxErrorMessageDisplayed, Messages.ELEMENTNOTFOUND);

	}

	@Test(description = "user login with invalid username and invalid password", priority = 2) // give priority
	public void userLoginWithInvalidUsernameandInvalidPassword() throws IOException {
		String username = ExcelUtility.readStringData(4, 0, "Login");
		String password = ExcelUtility.readStringData(4, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickRememberCheckbox();
		loginpage.clickSignInButton();
		boolean isAlertboxErrorMessageDisplayed = loginpage.isAlertboxErrorMessageDisplayed();
		Assert.assertTrue(isAlertboxErrorMessageDisplayed, Messages.ELEMENTNOTFOUND);

	}
}
