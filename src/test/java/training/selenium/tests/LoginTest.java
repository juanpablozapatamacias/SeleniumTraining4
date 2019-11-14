package training.selenium.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import training.selenium.base.BasePage;
import training.selenium.pageobjects.HomePage;
import training.selenium.pageobjects.LoginPage;
import training.selenium.pageobjects.TaskPage;

public class LoginTest extends BasePage{
	
	@BeforeTest
	public void setup() {
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/firefox/geckodriver");
		
		driver = super.getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to("https://todoist.com");
	}
	
	@Test
	public void loginTest() {
		HomePage home = new HomePage(driver);
		
		LoginPage login = home.clickLoginLink();
		login.switchToFrame();
		login.typeUserName("javier.yanez@wizeline.com");
		login.typePassword("WizelineAcademy");
		
		
		TaskPage task = login.clickLogin();
		login.switchToOriginal();
		
		Assert.assertTrue(task.accessToTask(), "Invalid Login or not available");
	}
	
	@AfterTest
	public void afterDown() {
		driver.quit();
		driver = null;
	}

}
