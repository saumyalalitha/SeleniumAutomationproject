package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;
import constants.Messages;
import pages.LoginPage;
import pages.ManageUsersPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageUsersTest extends Base {

	@Test(description = "Add a New user using Manage Users Menu", priority = 1)
	public void addnewUserInManageUserModule() throws IOException {
		// login
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickRememberCheckbox()
				.clickSignInButton();
		boolean isDashboardDisplayed = loginpage.isDashboardDisplayed();
		Assert.assertTrue(isDashboardDisplayed, Messages.CREDENTIALERROR);
		// add new user
		FakerUtility faker = new FakerUtility();
		String fakeUsernameForNewUser = faker.generateNewUserName();
		String fakePasswordForNewUser = faker.generateNewPassword();
		String dropdownValueForUserType = ExcelUtility.readStringData(1, 2, "ManageUsers");
		ManageUsersPage manageUser = new ManageUsersPage(driver);
		manageUser.clickAdminUsersMenu();
		manageUser.clickManageUsersDropdownOption().clickOnNewButton()
				.enterUsernameInUsernameField(fakeUsernameForNewUser)
				.enterPasswordInPasswordField(fakePasswordForNewUser)
				.selectValueFromUserTypedropdownField(dropdownValueForUserType).clickSaveButton();
		boolean isUserCreatedSuccessMessageDisplayed = manageUser.isUserCreatedSuccessMessageDisplayed();
		Assert.assertTrue(isUserCreatedSuccessMessageDisplayed, Messages.USERALREADYEXISTS);

	}

}
