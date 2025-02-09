package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class ManageNewsPage {

	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text() = 'Manage News']")
	private WebElement manageNewsMenuItem;
	@FindBy(xpath = "//a[@class= 'btn btn-rounded btn-danger']")
	private WebElement addNewsButton;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement enterTheNewsField;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	@FindBy(xpath = "//input[@class='form-control']")
	private WebElement enterSearchInput;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	private WebElement submitSearchButton;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']")
	private WebElement searchResultTable;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr")
	List<WebElement> tablerows;

	public ManageNewsPage clickManageNewsMenuItem() {
		WaitUtility.waitUntillElementToBeClickable(driver, manageNewsMenuItem);
		manageNewsMenuItem.click();
		return this;
	}

	public ManageNewsPage clickAddNewsButton() {
		addNewsButton.click();
		return this;
	}

	public ManageNewsPage clickSearchButton() {
		searchButton.click();
		return this;
	}

	public ManageNewsPage enterSearchInputInSearchField(String searchInput) {
		enterSearchInput.sendKeys(searchInput);
		return this;
	}

	public ManageNewsPage clickSubmitSearchbutton() {
		submitSearchButton.click();
		return this;

	}

	public boolean isSearchResultTableDisplayed() {

		return searchResultTable.isDisplayed();

	}

	public boolean istRowcellContentMatchingInput(String searchInput) {
		for (WebElement option : tablerows) {
			String text = option.getText();
			if (text.contains(searchInput)) {
				System.out.println(text);
				return true;
			}
		}

		return false;
	}

	public void searchResultValidation(String searchinput) {
		searchResultTable.getText();

	}

}
