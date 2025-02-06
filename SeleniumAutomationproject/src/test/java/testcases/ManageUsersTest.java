package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.ProjectBase;
import constants.Messages;
import pages.LoginPage;
import pages.ManageUsersPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageUsersTest extends ProjectBase {

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
		// String usernameToAddUser = ExcelUtility.readStringData(1, 0, "ManageUsers");
		// String passwordToAddUser = ExcelUtility.readStringData(1, 1, "ManageUsers");
		FakerUtility faker = new FakerUtility();
		String fakeUsernameForNewUser = faker.generateNewUserName();
		String fakePasswordForNewUser = faker.generateNewPassword();
		ManageUsersPage manageUser = new ManageUsersPage(driver);
		manageUser.clickAdminUsersMenu();
		manageUser.clickManageUsersDropdownOption().clickOnNewButton()
				.enterUsernameInUsernameField(fakeUsernameForNewUser)
				.enterPasswordInPasswordField(fakePasswordForNewUser).selectValueFromUserTypedropdownField()
				.clickSaveButton();
		boolean isUserCreatedSuccessMessageDisplayed = manageUser.isUserCreatedSuccessMessageDisplayed();
		Assert.assertTrue(isUserCreatedSuccessMessageDisplayed, Messages.USERALREADYEXISTS);

	}

}
