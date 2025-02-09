package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;
import constants.Messages;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {

	@Test(description = "Search a News in the Manage news Menu item", priority = 0)
	public void searchNewsInManageNewsModule() throws IOException {
		// login
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickRememberCheckbox()
				.clickSignInButton();
		boolean isDashboardDisplayed = loginpage.isDashboardDisplayed();
		Assert.assertTrue(isDashboardDisplayed, Messages.CREDENTIALERROR);
		// search News and validate the search result
		String inputSearch = ExcelUtility.readStringData(2, 0, "NewsSearch");
		ManageNewsPage manageNewsPage = new ManageNewsPage(driver);
		manageNewsPage.clickManageNewsMenuItem().clickSearchButton().enterSearchInputInSearchField(inputSearch)
				.clickSubmitSearchbutton();
		boolean isSearchResultDisplayed = manageNewsPage.isSearchResultTableDisplayed();
		Assert.assertTrue(isSearchResultDisplayed, Messages.SEARCHRESULTTABLENOTFOUND);
		boolean isSearchResultMatchingInput = manageNewsPage.istRowcellContentMatchingInput(inputSearch);
		Assert.assertTrue(isSearchResultMatchingInput, Messages.SEARCHRESULTNOTMATCHING);
	}

}
