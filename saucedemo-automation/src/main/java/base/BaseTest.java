package base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Constants;

public class BaseTest implements Constants {

	public static WebDriver driver;

	@BeforeMethod
	public static void setupDriver() {
		driver = WebDriverManager.chromedriver().create();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(Constants.url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

	public void waitForVisible(WebElement elementName, long time) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
			wait.until(ExpectedConditions.visibilityOf(elementName));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
