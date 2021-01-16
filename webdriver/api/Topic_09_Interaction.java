package api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_09_Interaction {
	WebDriver driver;
	Actions action;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Hover_Mouse() {
		driver.get("https://tiki.vn/");

		// Verified button Login is undisplayed
		Assert.assertFalse(driver.findElement(By.xpath("//button[text()='Đăng nhập']")).isDisplayed());

		WebElement shortcutAccount = driver.findElement(
				By.xpath("//span[@class='Userstyle__ItemText-sc-6e6am-2 bKCghQ']//span[text()='Tài khoản']"));
		action.moveToElement(shortcutAccount).perform();
		sleepInSecond(4);

		// Verified button Login is displayed
		Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Đăng nhập']")).isDisplayed());

	}
	
	@Test
	public void TC_02_Click_and_Hold() {
		driver.get("https://jqueryui.com/resources/demos/tooltip/default.html");
		action.moveToElement(driver.findElement(By.id("age"))).perform();
		sleepInSecond(3);
		
		//verified text is displayed
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='ui-tooltip-content']")).getText(), "We ask for your age only for statistical purposes.");
		
	}
	
	@Test
	public void TC_03_Double_Click() {
		driver.get("https://hn.telio.vn/");
		action.moveToElement(driver.findElement(By.xpath("//nav[@class='navigation cdz-fix-left']//span[text()='Đồ uống']"))).perform();
		action.click(driver.findElement(By.xpath("//nav[@class='navigation cdz-fix-left']//a[text()='Bia']"))).perform();
		
		//verify
		Assert.assertEquals(driver.findElement(By.xpath("//h1[@id='page-title-heading']//span[@class='base']")).getText(), "BIA");
	}
	
	@Test
	public void TC_04_Click_And_Hold() {
		driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");
		
		//Create 1 list elements
		List<WebElement> allNumber = driver.findElements(By.xpath("//ol[@id='selectable']//li"));
		System.out.println(allNumber.size());
		//0-11: index
		//1-12: value
		action.clickAndHold(allNumber.get(0)).moveToElement(allNumber.get(10)).release().perform();
		sleepInSecond(1);	
		List<WebElement> allNumberSelected = driver.findElements(By.xpath("//ol[@id='selectable']/li[contains(@class,'ui-selected')]"));
		System.out.println("Number selected: "+ allNumberSelected.size());
	}
	
	@Test
	public void TC_05_Click_And_Hold_Random() {
driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");
		
		//Create 1 list elements
		List<WebElement> allNumber = driver.findElements(By.xpath("//ol[@id='selectable']//li"));
		System.out.println(allNumber.size());
		
		//Nhan phim Ctrl xuong
		action.keyDown(Keys.CONTROL).perform();
		
		//click vao cac so 1 3 6 12
		action.click(allNumber.get(0));
		action.click(allNumber.get(2));
		action.click(allNumber.get(5));
		action.click(allNumber.get(11));
		action.perform();
		sleepInSecond(3);
		
		//nha phim Ctrl
		action.keyUp(Keys.CONTROL).perform();
		List<WebElement> allNumberSelected = driver.findElements(By.xpath("//ol[@id='selectable']/li[contains(@class,'ui-selected')]"));
		System.out.println("Number selected: "+ allNumberSelected.size());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
