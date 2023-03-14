package qa.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.HomePageElements;
import pageObjects.LoginPageElements;

public class TestClass_002_LoginSuccess extends BaseTest{
	
	@Test
	public void loginSuccess() {
		BaseTest.driver.findElement(By.xpath(HomePageElements.username)).sendKeys("standard_user");
		BaseTest.driver.findElement(By.xpath(HomePageElements.pwd)).sendKeys("secret_sauce");
		BaseTest.driver.findElement(By.xpath(HomePageElements.loginbtn)).click();
		String successLoginHeadings=BaseTest.driver.findElement(By.xpath(LoginPageElements.loginPageSuccessHeadingText)).getText();
		assertEquals(successLoginHeadings,"Products");
	}

	
}
