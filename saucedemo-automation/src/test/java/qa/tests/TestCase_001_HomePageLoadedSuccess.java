package qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.HomePageElements;

public class TestCase_001_HomePageLoadedSuccess extends BaseTest {
	
	@Test
	public void homePageLoadedSuccessfully() {
		WebElement ele=BaseTest.driver.findElement(By.xpath(HomePageElements.homePageHeading));
		String homepageHeading=ele.getText();
		AssertJUnit.assertEquals(homepageHeading,"Swag Labs");
	}

}
