package training.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import training.selenium.base.BasePage;

public class LoginPage extends BasePage {
	
	WebElement ele;

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void switchToFrame() {
		ele = super.getElement(By.cssSelector("div._2C627IN_Sg2vlpE_2qeZHu header._3XuQAGvE6TbpApvVUQ5XPU:nth-child(1) "
				+ "div._27zBsJUFFsnEnq4IZO_JG3.Tlm_jmq4KQPXR-OWZwX2f:nth-child(5) "
				+ "div.bLSYAwjddhP-wu-W6MjnX div:nth-child(2) "
				+ "div._1HmTwkhhsNGhi5p8bcdMcg > iframe._3ga5XTxZEFAiG-Q7KQfQnT"), 3);
		
		driver.switchTo().frame(ele);
	}
	
	public void switchToOriginal() {
		driver.switchTo().defaultContent();
	}
	
	public void typeUserName(String user) {
		ele = super.getElement(By.cssSelector("#email"), 10);
		ele.sendKeys(user);
	}
	
	public void typePassword(String pass) {
		ele = super.getElement(By.cssSelector("#password"), 10);
		ele.sendKeys(pass);
	}
	
	public TaskPage clickLogin() {
		ele = super.getElement(By.cssSelector("body:nth-child(2) "
				+ "div.login_singup_form.content:nth-child(1) "
				+ "form:nth-child(4) > button.submit_btn.ist_button.ist_button_red.sel_login:nth-child(10)"), 3);
		ele.click();
		
		return new TaskPage(driver);
	}
}
