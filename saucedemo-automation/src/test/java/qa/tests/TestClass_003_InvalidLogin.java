package qa.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.HomePageElements;
import pageObjects.LoginPageElements;

public class TestClass_003_InvalidLogin extends BaseTest{
	
	@Test
	public void loginFail() {
		BaseTest.driver.findElement(By.xpath(HomePageElements.username)).sendKeys("standard_user");
		BaseTest.driver.findElement(By.xpath(HomePageElements.pwd)).sendKeys("secret_sauce1");
		BaseTest.driver.findElement(By.xpath(HomePageElements.loginbtn)).click();
		WebDriverWait wait=new WebDriverWait(BaseTest.driver,Duration.ofSeconds(30));
		WebElement invalidLoginmsg=BaseTest.driver.findElement(By.xpath(HomePageElements.invalidLoginMsg));
		waitForVisible(invalidLoginmsg,20);
		String invalidLoginmsgText=invalidLoginmsg.getText();
		AssertJUnit.assertEquals(invalidLoginmsgText,"Epic sadface: Username and password do not match any user in this service");
	}

	
}
