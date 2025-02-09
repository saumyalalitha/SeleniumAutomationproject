package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;
import constants.Constants;
import constants.Messages;
import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;

public class SubcategoryTest extends Base {

	@Test(description = "Add a new Subcategory to the Subcategory Menu", priority = 1)
	public void addingNewSubcategoryInSubcategoryPage() throws IOException {
		// login
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickRememberCheckbox()
				.clickSignInButton();
		boolean isDashboardDisplayed = loginpage.isDashboardDisplayed();
		Assert.assertTrue(isDashboardDisplayed, Messages.CREDENTIALERROR);
		// add new subcategory
		String newSubcategoryName = ExcelUtility.readStringData(1, 0, "Subcategory");
		String uploadImageForSubcategory = Constants.TESTIMAGEFORSUBCATEGORY;
		String dropdownValueForSubcategory = ExcelUtility.readStringData(1, 1, "Subcategory");
		SubCategoryPage subcategoryPage = new SubCategoryPage(driver);
		subcategoryPage.clickSubcategoryMenu().clickNewButtonInSubcategory()
				.selectDropdownOptionToAddNewSubcategory(dropdownValueForSubcategory)
				.enterNewSubcategoryNameinSubcategoryField(newSubcategoryName)
				.imageUploadNewSubcategory(uploadImageForSubcategory).clickSaveButtonInAddSubcategory();
		boolean isSuccessMessageForNewSubcategoryDisplayed = subcategoryPage
				.isSuccessMessageForNewSubcategoryDisplayed();
		Assert.assertTrue(isSuccessMessageForNewSubcategoryDisplayed, Messages.SUBCATEGORYERROR);
	}

	@Test(groups = { "smoke" }, description = "Delete first subcategory listed in the Subcategory List", priority = 0)
	public void deleteExistingSubcategoryFromSubcategoryList() throws IOException {
		// login
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickRememberCheckbox()
				.clickSignInButton();
		boolean isDashboardDisplayed = loginpage.isDashboardDisplayed();
		Assert.assertTrue(isDashboardDisplayed, Messages.CREDENTIALERROR);
		// delete subcategory
		SubCategoryPage subcategoryPage = new SubCategoryPage(driver);
		subcategoryPage.clickSubcategoryMenu().clickDeleteIconForFirstSubcategoryInTable();
		boolean isSubcategoryDeletedSuccessMessageDisplayed = subcategoryPage
				.isSubcategoryDeletedSuccessMessageDisplayed();
		Assert.assertTrue(isSubcategoryDeletedSuccessMessageDisplayed, Messages.SUBCATEGORYDELETEERROR);

	}
}
