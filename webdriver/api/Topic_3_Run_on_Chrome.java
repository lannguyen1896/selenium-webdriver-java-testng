package api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Topic_3_Run_on_Chrome {
	WebDriver driver;

	@Test
	public void Test_on_Firefox() {
		// Selenium 2.53.1
		// FireFox 47.0.2
		// No need geckodriver
		driver = new FirefoxDriver();
		System.out.println(driver.toString());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://facebook.com");
		driver.quit();
	}

	@Test
	public void Test_on_Chrome() {
		// Selenium 2.53.1
		// Chrome latest
		// chromedriver lastest

		// Window
		// absolute path
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\Lann\\git\\selenium-webdriver-java-testng\\browserDriver\\chromedriver.exe");

		// relative path
		System.setProperty("webdriver.chrome.driver", ".\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://facebook.com");
		driver.quit();

	}

}
