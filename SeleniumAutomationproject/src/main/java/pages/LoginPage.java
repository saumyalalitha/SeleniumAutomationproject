package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernameField;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//input[@id='remember']//parent::div[@class='icheck-dark']")
	private WebElement remember;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	private WebElement signinButton;
	@FindBy(xpath = "//p[text()=\"Dashboard\"]")
	private WebElement dashboard;
	@FindBy(xpath = "//h5[text()=\" Alert!\"]")
	private WebElement alertBoxErrorMessage;

	public LoginPage enterUsernameOnUsernameField(String username) {

		usernameField.sendKeys(username);
		return this;

	}

	public LoginPage enterPasswordOnPasswordField(String password) {

		passwordField.sendKeys(password);
		return this;

	}

	public LoginPage clickRememberCheckbox() {

		remember.click();
		return this;

	}

	public HomePage clickSignInButton() {

		signinButton.click();
		return new HomePage(driver);

	}

	public boolean isDashboardDisplayed() {

		return dashboard.isDisplayed();

	}

	public boolean isAlertboxErrorMessageDisplayed() {

		return alertBoxErrorMessage.isDisplayed();

	}

}
