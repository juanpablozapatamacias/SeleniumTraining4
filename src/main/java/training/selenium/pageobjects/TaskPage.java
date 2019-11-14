package training.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import training.selenium.base.BasePage;

public class TaskPage extends BasePage {
	
	WebElement ele;

	public TaskPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean accessToTask() {
		ele = getElement(By.cssSelector("div.main_content div:nth-child(1) "
				+ "div.section_day:nth-child(1) "
				+ "div:nth-child(1) h2.section_header > a:nth-child(1)"),15);
		
		if(ele.isDisplayed()) return true;
		
		return false;
	}
}
