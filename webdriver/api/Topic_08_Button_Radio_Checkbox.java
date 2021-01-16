package api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_08_Button_Radio_Checkbox {
  WebDriver driver;
  JavascriptExecutor jsExecutor;
  By loginButton = By.cssSelector(".fhs-btn-login");
  By loginUsername = By.cssSelector("#login_username");
  By loginPassword = By.cssSelector("#login_password");
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  
	  jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
  }
  
  @Test
  public void TC_01_Button() throws InterruptedException {
	  driver.get("https://www.fahasa.com/customer/account/create");
	  driver.findElement(By.cssSelector(".popup-login-tab-login")).click();
	  
	  //disable field
	  Assert.assertFalse(isElementEnabled(loginButton));
	  driver.findElement(loginUsername).sendKeys("dam@gmail.com");
	  driver.findElement(loginPassword).sendKeys("123456");
	  Thread.sleep(2000);
	  
	//enabled field
	  Assert.assertTrue(isElementEnabled(loginButton));
	  driver.navigate().refresh();
	  driver.findElement(By.cssSelector(".popup-login-tab-login")).click();
	  removeDisableAttributeByJS(loginButton);
	  Thread.sleep(5000);
	  
	  //enable field
	  Assert.assertTrue(isElementEnabled(loginButton));
	  driver.findElement(loginButton).click();
	  Thread.sleep(2000);
	  Assert.assertEquals(driver.findElement(By.xpath("//div[@class='fhs-input-box checked-error']//div[@class='fhs-input-alert']")).getText(), "Thông tin này không thể để trống");
	  Assert.assertEquals(driver.findElement(By.xpath("//div[@class='fhs-input-box fhs-input-display checked-error']//div[@class='fhs-input-alert']")).getText(), "Thông tin này không thể để trống");
  }

  
  public boolean isElementEnabled(By by) {
	  if(driver.findElement(by).isEnabled()){
		  System.out.println("Element is enable");
		  return true;
	  }else {
		  System.out.println("Element is disable");
		  return false;
	  }	  
  }
  
  public void removeDisableAttributeByJS(By by) {
	  WebElement element = driver.findElement(by);
	  jsExecutor.executeScript("arguments[0].removeAttribute('disabled')", element);
  }
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
