package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.ProjectBase;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends ProjectBase {

	@Test(groups = { "smoke" }, description = "user logout after successfull login", priority = 0)
	public void userLogoutFromWebPage() throws IOException {

		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickRememberCheckbox()
				.clickSignInButton();
		boolean isDashboardDisplayed = loginpage.isDashboardDisplayed();
		Assert.assertTrue(isDashboardDisplayed, Messages.ELEMENTNOTFOUND);
		// logout
		HomePage homePage = new HomePage(driver);
		homePage.clickOnAdminImageIconOnHomePage().clickOnLogoutOption();
		boolean isSigninPageDisplayedOnLogout = homePage.isSigninPageDisplayedOnLogout();
		Assert.assertTrue(isSigninPageDisplayedOnLogout, Messages.LOGINPAGENOTDISPLAYED);

	}

}
