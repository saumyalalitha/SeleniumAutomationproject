package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//img[@class='img-circle']")
	private WebElement adminImageIconOnHomePage;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	private WebElement logoutOption;
	@FindBy(xpath = "//p[text() = 'Sign in to start your session']")
	private WebElement signinPageDisplayedOnLogout;


	public HomePage clickOnAdminImageIconOnHomePage() {
		adminImageIconOnHomePage.click();
		return this;
	}

	public LoginPage clickOnLogoutOption() {

		logoutOption.click();
		return new LoginPage(driver);
	}

	public boolean isSigninPageDisplayedOnLogout() {

		return signinPageDisplayedOnLogout.isDisplayed();

	}

}
