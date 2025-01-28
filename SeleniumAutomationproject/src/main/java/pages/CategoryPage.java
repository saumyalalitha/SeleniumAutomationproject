package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {

	public WebDriver driver;

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a//p[text()='Category']")
	private WebElement categorymenu;

	@FindBy(xpath = "//a[@class=\"btn btn-rounded btn-danger\"]")
	private WebElement newButton;

	@FindBy(xpath = "//h1[@class=\"m-0 text-dark\"]")
	private WebElement isAddCategoryPageDisplayed;

	@FindBy(xpath = "//input[@id='category']")
	private WebElement enterCategoryField;

	@FindBy(xpath = "//li[@id='134-selectable']")
	private WebElement selectGroupsField;
	
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement chooseFileButton;
	
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement saveButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement isSuccessMessageDisplayed;
	
	public void clickCategoryMenuItem() {

		categorymenu.click();

	}

	public void clicknewCategoryButton() {

		newButton.click();

	}

	public void enterValueinEnterCategoryField(String categoryName) {
		enterCategoryField.sendKeys(categoryName);
	}

	public void clickSelectGroupsFiled() {
		selectGroupsField.click();

	}
	
	public void imageUpload(String imagePath)
	{
		chooseFileButton.sendKeys(imagePath);
	}
	
	public void clickSaveButton()
	{
		saveButton.click();
	}
	
	public boolean successMessageDisplayed()
	{
		return isSuccessMessageDisplayed.isDisplayed();
	}
	
	
	
	

}
