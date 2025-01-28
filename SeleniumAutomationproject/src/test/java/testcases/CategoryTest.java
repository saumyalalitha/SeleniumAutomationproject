package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.ProjectBase;
import constants.Constants;
import constants.Messages;
import pages.CategoryPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class CategoryTest extends ProjectBase{
	
	@Test(description = "Add a new category to the Category Menu", priority = 1)
	public void addNewCatogory() throws IOException
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
		//add new category
		String categoryName = ExcelUtility.readStringData(2, 0, "Category");
		String uploadImage = Constants.TESTIMAGEFILE;
		CategoryPage categorypage = new CategoryPage(driver);
		categorypage.clickCategoryMenuItem();
		categorypage.clicknewCategoryButton();
		categorypage.enterValueinEnterCategoryField(categoryName);
		categorypage.clickSelectGroupsFiled();
		categorypage.imageUpload(uploadImage);
		categorypage.clickSaveButton();
		boolean isSuccessMessageDisplayed = categorypage.successMessageDisplayed();
		Assert.assertTrue(isSuccessMessageDisplayed, Messages.SUCCESSMESSAGENOTFOUND);
	   		
	}
	

}
