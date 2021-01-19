package api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_11_Popup {
  WebDriver driver;
  WebDriverWait explicitWait;
  
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  explicitWait = new WebDriverWait(driver, 10);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
  }
 
  public void TC_01_Fixed_Popup() {
	  driver.get("https://zingpoll.com/");
	  driver.findElement(By.id("Loginform")).click();
	  
	  //cho cho 1 element duoc hien thi ra
	  explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='loginForm']")));
	  Assert.assertTrue(driver.findElement(By.xpath("//form[@id='loginForm']")).isDisplayed());
	  
	  driver.findElement(By.xpath("//div[@id='Login']//button[@class='close']")).click();
	  
	  //cho cho 1 element khong con hien thi
	  explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//form[@id='loginForm']")));
	  Assert.assertFalse(driver.findElement(By.xpath("//form[@id='loginForm']")).isDisplayed());
	  
  }
  
  @Test
  public void TC_02_Fixed_Popup() {
	  driver.get("https://bni.vn");
	  
	  //cho cho 1 element duoc hien thi ra
	  explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='sgpb-popup-dialog-main-div']")));
	  Assert.assertTrue(driver.findElement(By.xpath("//div[@id='sgpb-popup-dialog-main-div']")).isDisplayed());
	  
	 // driver.findElement(By.xpath("//input[@value='JOIN WITH US']")).click();
	  
	  //cho 1 element co the click hay khong
	  explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='Close']")));
	  
	  driver.findElement(By.xpath("//img[@alt='Close']")).click();
	  
	//cho cho 1 element duoc hien thi ra
	  explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='sgpb-popup-dialog-main-div']")));
	  Assert.assertFalse(driver.findElement(By.xpath("//div[@id='sgpb-popup-dialog-main-div']")).isDisplayed());
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
