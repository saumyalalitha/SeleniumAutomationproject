package utilities;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class PageUtility {

	public static void confirmAlert(WebDriver driver, WebElement element) {
		element.click();
		driver.switchTo().alert();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}

	public static void rightClickMouseAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).build().perform();
	}

	public static void dragAndDropMouseAction(WebDriver driver, WebElement draggableElement,
			WebElement droppableElement) {
		Actions act = new Actions(driver);
		act.dragAndDrop(draggableElement, droppableElement).build().perform();
	}

	public static void mouseHoverAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}

	public static void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);

	}

	public static String selectByVisibletext(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
		WebElement selectedElement = select.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public static void selectByValue(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByValue(text);
	}

	public static void handlingCheckBox(WebDriver driver, WebElement element) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchFieldException.class);
		fluentWait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public static void handlingRadioButtons(WebElement element) {
		element.click();
		boolean isRadioButtonSelected = element.isSelected();
		System.out.println(isRadioButtonSelected);
	}

}
