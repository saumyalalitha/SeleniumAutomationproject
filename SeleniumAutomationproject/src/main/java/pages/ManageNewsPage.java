package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	public void clickManageNewsMenuItem()
	{
		manageNewsMenuItem.click();
	}
	
	public void clickAddNewsButton()
	{
		addNewsButton.click();
	}
	
	public void enterNewsInNewsField()
	{
		enterTheNewsField.sendKeys("Test Data");
	}
	
	public void clickSearchButton()
	{
		searchButton.click();
	}
	
	public void enterSearchInputInSearchField(String searchInput) {
		enterSearchInput.sendKeys(searchInput);
	}
	public void clickSubmitSearchbutton() {
		submitSearchButton.click();
		
	}

}
