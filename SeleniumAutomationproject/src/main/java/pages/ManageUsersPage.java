package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageUsersPage {
	public WebDriver driver;

	public ManageUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-users']")
	private WebElement adminUsersMenu;
	@FindBy(xpath = "//p[text() = 'Manage Users']")
	private WebElement manageUsersDropDownOption;
	@FindBy(xpath = "//a[text() = ' New']")
	private WebElement newButton;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement usernameField;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement userTypedropdownField;
	@FindBy(xpath = "//button//i[@class='fa fa-save']")
	private WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement userCreatedSuccessMessage;

	public HomePage clickAdminUsersMenu() {
		WaitUtility.waitUntillElementToBeClickable(driver, adminUsersMenu);
		adminUsersMenu.click();
		return new HomePage(driver);
	}

	public ManageUsersPage clickManageUsersDropdownOption() {
		manageUsersDropDownOption.click();
		return this;

	}

	public ManageUsersPage clickOnNewButton() {
		newButton.click();
		return this;

	}

	public ManageUsersPage enterUsernameInUsernameField(String userName) {
		usernameField.clear();
		usernameField.sendKeys(userName);
		return this;

	}

	public ManageUsersPage enterPasswordInPasswordField(String password) {
		passwordField.clear();
		passwordField.sendKeys(password);
		return this;
	}

	public ManageUsersPage selectValueFromUserTypedropdownField(String value) {
		PageUtility.selectByVisibletext(userTypedropdownField, value);
		return this;
	}

	public ManageUsersPage clickSaveButton() {
		saveButton.click();
		return this;
	}

	public boolean isUserCreatedSuccessMessageDisplayed() {
		return userCreatedSuccessMessage.isDisplayed();
	}

}
