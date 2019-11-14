package training.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import training.selenium.base.BasePage;

public class HomePage extends BasePage {
	
	WebElement ele;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public LoginPage clickLoginLink() {
		ele = getElement(By.cssSelector
				("div._2C627IN_Sg2vlpE_2qeZHu header._3XuQAGvE6TbpApvVUQ5XPU:nth-child(1) "
						+ "nav.YQpG_ImtBuIaHUORtN11R:nth-child(3) "
						+ "ul:nth-child(2) li.xC29iLDJOfZeDm_x5o7DH:nth-child(1) > a:nth-child(1)"),3);
		ele.click();
		
		return new LoginPage(driver);
	}
	
	

}
