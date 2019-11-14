package training.selenium.base;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public WebDriver driver;
	int attempts = 0;
	public WebElement ele = null;
	
	public BasePage() {}
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		if (driver == null)
			driver = new FirefoxDriver();
		
		return driver;
	}
	
	public WebDriverWait wait(int secs) {
		return new WebDriverWait(driver, secs);
	}
	
	public WebElement getElement(By by, int secs) {
		while (attempts < 2) {
			try {
				ele = wait(secs)
						.ignoring(TimeoutException.class, NoSuchElementException.class)
						.until(ExpectedConditions.visibilityOfElementLocated(by));
				
				return ele;
						
			}
			catch(StaleElementReferenceException se) {}
		}
		return null;
	}
	
	
}
