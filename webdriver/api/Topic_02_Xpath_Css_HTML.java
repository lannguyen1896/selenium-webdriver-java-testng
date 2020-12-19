package api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Topic_02_Xpath_Css_HTML {
	WebDriver driver;
	
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get("https://alada.vn/tai-khoan/dang-ky.html");
  }
  @Test
  public void TC_01_ValidateCurrentUrl() throws InterruptedException {
	  driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
	  Thread.sleep(1000);
	  //Nhap vao txt Ho Ten
	  driver.findElement(By.cssSelector("input[name='textfirstname']")).sendKeys("Automation FC");
	  Thread.sleep(1000);
	  //Nhap vao txt Password
	  driver.findElement(By.id("txtPassword")).sendKeys("12345678");
	  Thread.sleep(1000);
  }
  
  @Test
  public void TC_02_ValidatePageTitle() {
	  
  }
  
  @Test
  public void TC_03_LoginFormDisplayed() {
	  
  }
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
