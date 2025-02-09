package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import constants.Messages;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

	@Test(groups = {
			"smoke" }, description = "user login with valid username and valid password", priority = 0, retryAnalyzer = retry.RetryClass.class)
	public void userLoginWithValidUsernameandValidPassword() throws IOException {

		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		// chaining
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickRememberCheckbox()
				.clickSignInButton();
		boolean isDashboardDisplayed = loginpage.isDashboardDisplayed();
		Assert.assertTrue(isDashboardDisplayed, Messages.CREDENTIALERROR);

	}

	@Test(description = "user login with valid username and invalid password", priority = 1, dataProvider = "LoginProvider") // dataprovider
	public void userLoginWithValidUsernameandInvalidPassword(String username, String password) throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickRememberCheckbox()
				.clickSignInButton();
		boolean isAlertboxErrorMessageDisplayed = loginpage.isAlertboxErrorMessageDisplayed();
		Assert.assertTrue(isAlertboxErrorMessageDisplayed, Messages.PASSWORDCREDENTIALERROR);

	}

	@Test(groups = { "smoke" }, description = "user login with invalid username and valid password", priority = -1) // grouping
	public void userLoginWithInvalidUsernameandValidPassword() throws IOException {
		String username = ExcelUtility.readStringData(3, 0, "Login");
		String password = ExcelUtility.readStringData(3, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickRememberCheckbox()
				.clickSignInButton();
		boolean isAlertboxErrorMessageDisplayed = loginpage.isAlertboxErrorMessageDisplayed();
		Assert.assertTrue(isAlertboxErrorMessageDisplayed, Messages.USERNAMECREDENTIALERROR);

	}

	@Test(description = "user login with invalid username and invalid password", priority = 2) // give priority
	public void userLoginWithInvalidUsernameandInvalidPassword() throws IOException {
		String username = ExcelUtility.readStringData(4, 0, "Login");
		String password = ExcelUtility.readStringData(4, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickRememberCheckbox()
				.clickSignInButton();
		boolean isAlertboxErrorMessageDisplayed = loginpage.isAlertboxErrorMessageDisplayed();
		Assert.assertTrue(isAlertboxErrorMessageDisplayed, Messages.INVALIDCREDENTIALERROR);

	}

	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromDataprovider() throws IOException {
		return new Object[][] { new Object[] { "admin1", "admin234" }, new Object[] { "sumi", "test1234" },
				new Object[] { ExcelUtility.readStringData(5, 0, "Login"),
						ExcelUtility.readStringData(5, 1, "Login") } };
	}
}
