package api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_10_Interaction {
  WebDriver driver;
  Actions action;
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  action = new Actions(driver);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  
  @Test
  public void TC_01_Right_Click() {
	  driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
	  action.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).perform();
	  
	  //verify Quit not contains (visible/hover status)
	  Assert.assertTrue(driver.findElement(By.xpath("//li[contains(@class,'context-menu-item')" + 
	  "and not(contains(@class,'context-menu-hover'))" + "and not(contains(@class,'context-menu-visible'))]")).isDisplayed());
	  
	  //Hover to Quit
	  action.moveToElement(driver.findElement(By.xpath("//span[text()='Quit']"))).perform();
	  
	  //Click to Quit
	  driver.findElement(By.xpath("//span[text()='Quit']")).click();
	  
	  //verify alert
	  Assert.assertEquals(driver.switchTo().alert().getText(), "clicked: quit");
	  driver.switchTo().alert().accept();
  }
  
  @Test
  public void TC_02_Drag_And_Drop() {
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
