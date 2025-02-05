package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.ProjectBase;
import constants.Constants;
import constants.Messages;
import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;

public class SubcategoryTest extends ProjectBase {

	@Test(description = "Add a new Subcategory to the Subcategory Menu", priority = 1)
	public void addNewSubcategory() throws IOException {
		// login
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickRememberCheckbox()
				.clickSignInButton();
		boolean isDashboardDisplayed = loginpage.isDashboardDisplayed();
		Assert.assertTrue(isDashboardDisplayed, Messages.ELEMENTNOTFOUND);
		// add new subcategory
		SubCategoryPage subcategoryPage = new SubCategoryPage(driver);
		subcategoryPage.clickSubcategoryMenu().clickNewButtonInSubcategory();
		subcategoryPage.selectDropdownOptionToAddNewSubcategory();
		String newSubcategoryName = ExcelUtility.readStringData(1, 0, "Subcategory");
		String uploadImageForSubcategory = Constants.TESTIMAGEFORSUBCATEGORY;
		subcategoryPage.enterNewSubcategoryNameinSubcategoryField(newSubcategoryName);
		subcategoryPage.imageUploadNewSubcategory(uploadImageForSubcategory);
		subcategoryPage.clickSaveButtonInAddSubcategory();
		boolean isSuccessMessageForNewSubcategoryDisplayed = subcategoryPage
				.isSuccessMessageForNewSubcategoryDisplayed();
		Assert.assertTrue(isSuccessMessageForNewSubcategoryDisplayed, Messages.SUCCESSMESSAGENOTFOUND);
	}

	@Test(description = "Delete first subcategory listed in the Subcategory List", priority = 0)
	public void deleteExistingSubcategoryFromList() throws IOException {
		// login
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickRememberCheckbox()
				.clickSignInButton();
		boolean isDashboardDisplayed = loginpage.isDashboardDisplayed();
		Assert.assertTrue(isDashboardDisplayed, Messages.ELEMENTNOTFOUND);
		// delete subcategory
		SubCategoryPage subcategoryPage = new SubCategoryPage(driver);
		subcategoryPage.clickSubcategoryMenu().clickDeleteIconForFirstSubcategoryInTable();
		boolean isSubcategoryDeletedSuccessMessageDisplayed = subcategoryPage
				.isSubcategoryDeletedSuccessMessageDisplayed();
		Assert.assertTrue(isSubcategoryDeletedSuccessMessageDisplayed, Messages.SUCCESSMESSAGENOTFOUND);

	}
}
