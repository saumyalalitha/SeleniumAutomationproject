package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.ProjectBase;
import constants.Messages;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends ProjectBase {
	
	@Test(description = "Search a News in the Manage news Menu item")
	public void addNews() throws IOException
	{
		//login
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickRememberCheckbox();
		loginpage.clickSignInButton();
		boolean isDashboardDisplayed = loginpage.isDashboardDisplayed();
		Assert.assertTrue(isDashboardDisplayed, Messages.ELEMENTNOTFOUND);
		//search News
		String inputSearch = ExcelUtility.readStringData(1, 0, "NewsSearch");
		ManageNewsPage manageNews = new ManageNewsPage(driver);
		manageNews.clickManageNewsMenuItem();
		//manageNews.clickAddNewsButton();
		manageNews.clickSearchButton();
		manageNews.enterSearchInputInSearchField(inputSearch);
		manageNews.clickSubmitSearchbutton();
		
		
		
		
	}
		

}
