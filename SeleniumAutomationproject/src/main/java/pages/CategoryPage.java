package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

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

	@FindBy(xpath = "//tbody//tr[2]//td//a[@class='btn btn-sm btn btn-primary btncss']")
	private WebElement editButtonForSecondCategoryIncategoryList;
	@FindBy(xpath = "//img[@src='https://groceryapp.uniqassosiates.com/public/uploads/small/1737595101_7d4613668b98bdcf161f.png\']")
	private WebElement imageUploadedIsDisplayed;
	@FindBy(xpath = "//a//span[@class='fas fa-trash-alt']")
	private WebElement deleteAlreadyUploadedImageToEditCategory;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement imageDeletedSuccessMessage;
	@FindBy(xpath = "//button[text() = 'Update']")
	private WebElement updateButtonToEditCategory;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement categoryUpdatedSuccessMessage;

	public CategoryPage clickCategoryMenuItem() {

		categorymenu.click();
		return this;

	}

	public void clicknewCategoryButton() {

		newButton.click();

	}

	public void enterValueinEnterCategoryField(String categoryName) {
		enterCategoryField.clear();
		enterCategoryField.sendKeys(categoryName);
	}

	public void clickSelectGroupsFiled() {
		selectGroupsField.click();

	}

	public void imageUpload(String imagePath) {
		chooseFileButton.sendKeys(imagePath);
	}

	public CategoryPage clickSaveButton() {
		saveButton.click();
		return this;
	}

	public boolean successMessageDisplayed() {
		return isSuccessMessageDisplayed.isDisplayed();
	}

	public void clickEditButtonForSecondCategoryInCategoryList() {
		editButtonForSecondCategoryIncategoryList.click();

	}

	public void checkUploadedImageVisibilityAndDeleteExistingImage() {
		//deleteAlreadyUploadedImageToEditCategory.click();
		PageUtility.confirmAlert(deleteAlreadyUploadedImageToEditCategory);
		//driver.switchTo().alert();
		//System.out.println(driver.switchTo().alert().getText());
		//driver.switchTo().alert().accept();
	}

	public boolean isImageDeletedSuccessMessageDisplayed() {
		return imageDeletedSuccessMessage.isDisplayed();
	}

	public CategoryPage clickUpdateButtonToCompleteEditcategory() {
		updateButtonToEditCategory.click();
		return this;

	}

	public boolean isCategoryUpdatedSuccessMessageDisplayed() {
		return categoryUpdatedSuccessMessage.isDisplayed();
	}

}
