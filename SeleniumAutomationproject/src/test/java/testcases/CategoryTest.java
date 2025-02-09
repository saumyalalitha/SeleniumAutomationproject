package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;
import constants.Constants;
import constants.Messages;
import pages.CategoryPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class CategoryTest extends Base {

	@Test(description = "Add a new category to the Category Menu", priority = 1)
	public void addingNewCatogoryInCategoryPage() throws IOException {
		// login
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickRememberCheckbox()
				.clickSignInButton();
		boolean isDashboardDisplayed = loginpage.isDashboardDisplayed();
		Assert.assertTrue(isDashboardDisplayed, Messages.CREDENTIALERROR);
		// add new category
		String categoryName = ExcelUtility.readStringData(1, 0, "Category");
		String uploadImage = Constants.TESTIMAGEFILE;
		CategoryPage categorypage = new CategoryPage(driver);
		categorypage.clickCategoryMenuItem().clicknewCategoryButton().enterValueinEnterCategoryField(categoryName)
				.clickSelectGroupsFiled().imageUpload(uploadImage).clickSaveButton();
		boolean isSuccessMessageDisplayed = categorypage.successMessageDisplayed();
		Assert.assertTrue(isSuccessMessageDisplayed, Messages.CATEGORYERROR);

	}

	@Test(description = "Edit an existing Category from the category List", priority = 2)
	public void editExistingCategoryFromCategoryListPage() throws IOException {
		// login
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickRememberCheckbox()
				.clickSignInButton();
		boolean isDashboardDisplayed = loginpage.isDashboardDisplayed();
		Assert.assertTrue(isDashboardDisplayed, Messages.CREDENTIALERROR);
		// edit
		String newCategoryNameForEdit = ExcelUtility.readStringData(2, 0, "Category");
		String newImageUploadToEditcategory = Constants.TESTIMAGETOEDITCATEGORY;
		CategoryPage category = new CategoryPage(driver);
		category.clickCategoryMenuItem().clickEditButtonForSecondCategoryInCategoryList();
		category.checkUploadedImageVisibilityAndDeleteExistingImage();
		boolean isImageDeletedSuccessmessageDisplayed = category.isImageDeletedSuccessMessageDisplayed();
		Assert.assertTrue(isImageDeletedSuccessmessageDisplayed, Messages.IMAGENOTFOUND);
		category.enterValueinEnterCategoryField(newCategoryNameForEdit).imageUpload(newImageUploadToEditcategory)
				.clickUpdateButtonToCompleteEditcategory();
		// category.imageUpload(newImageUploadToEditcategory);
		// category.clickUpdateButtonToCompleteEditcategory();
		boolean isCategoryUpdatedSuccessMessageDisplayed = category.isCategoryUpdatedSuccessMessageDisplayed();
		Assert.assertTrue(isCategoryUpdatedSuccessMessageDisplayed, Messages.CATEGORYNOTUPDATED);

	}

}
