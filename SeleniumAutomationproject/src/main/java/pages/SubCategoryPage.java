package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;
import utilities.WaitUtility;

public class SubCategoryPage {
	public WebDriver driver;

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a//p[text() = 'Sub Category']")
	private WebElement subcategoryMenu;
	@FindBy(xpath = " //a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath = "//select[@class='form-control selectpicker']")
	private WebElement selectDropdownField;
	@FindBy(xpath = "//input[@id='subcategory']")
	private WebElement newSubcategoryName;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement chooseFileButton;
	@FindBy(xpath = "//button[text() = 'Save']")
	private WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successMessageForNewSubcategoryDisplayed;
	@FindBy(xpath = "//tbody//tr[1]//a[@class='btn btn-sm btn btn-danger btncss']")
	private WebElement deleteExistingSubcategoryTableRow;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement deletedSuccessMessageDisplayed;

	public SubCategoryPage clickSubcategoryMenu() {
		WaitUtility.waitUntillElementToBeClickable(driver, subcategoryMenu);
		subcategoryMenu.click();
		return this;

	}

	public SubCategoryPage clickNewButtonInSubcategory() {

		newButton.click();
		return this;

	}

	public SubCategoryPage selectDropdownOptionToAddNewSubcategory(String value) {
		PageUtility.selectByVisibletext(selectDropdownField, value);
		return this;

	}

	public SubCategoryPage enterNewSubcategoryNameinSubcategoryField(String subcategoryName) {

		newSubcategoryName.sendKeys(subcategoryName);
		return this;
	}

	public SubCategoryPage imageUploadNewSubcategory(String imagePath) {

		chooseFileButton.sendKeys(imagePath);
		return this;
	}

	public SubCategoryPage clickSaveButtonInAddSubcategory() {

		saveButton.click();
		return this;

	}

	public boolean isSuccessMessageForNewSubcategoryDisplayed() {

		return successMessageForNewSubcategoryDisplayed.isDisplayed();

	}

	public SubCategoryPage clickDeleteIconForFirstSubcategoryInTable() {
		PageUtility.confirmAlert(driver, deleteExistingSubcategoryTableRow);
		return this;
	}

	public boolean isSubcategoryDeletedSuccessMessageDisplayed() {
		WaitUtility.waitUntillVisibilityOfElement(driver, deletedSuccessMessageDisplayed);
		return deletedSuccessMessageDisplayed.isDisplayed();
	}
}
