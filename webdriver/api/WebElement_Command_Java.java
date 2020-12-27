package api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class WebElement_Command_Java {
  WebDriver driver;
  
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
  }
  @Test
  public void TC_01_Element_Displayed() throws InterruptedException {
	  driver.get("https://automationfc.github.io/basic-form/index.html");
	  
	  //Email textbox
	  if(driver.findElement(By.id("mail")).isDisplayed() && driver.findElement(By.id("mail")).isEnabled() ) {
		  System.out.println("Element is displayed.");
		  driver.findElement(By.id("mail")).sendKeys("Automation Testing");
	  }else {
		  System.out.println("Element isn't displayed");
	  }
	  Thread.sleep(3000);
	  
	  //Education textarea
	  if(driver.findElement(By.id("edu")).isDisplayed()) {
		  System.out.println("Element is displayed.");
		  driver.findElement(By.id("edu")).sendKeys("Automation Testing");
	  }else {
		  System.out.println("Element isn't displayed");
	  }
	  Thread.sleep(3000);
	  
	  //Age
	  if(driver.findElement(By.id("under_18")).isDisplayed()) {
		  System.out.println("Element is displayed.");
		  driver.findElement(By.id("under_18")).click();
	  }else {
		  System.out.println("Element isn't displayed");
	  }
	  Thread.sleep(3000);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
