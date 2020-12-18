package api;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class TestNG {
  WebDriver driver;
  
  @BeforeClass
  public void beforeClass() {
	  //mo trinh duyet
	  driver = new FirefoxDriver();
	  driver.get("https://google.com/");
  }
  
  @Test
  public void TC_01_Login_With_Empty_Email() {
	  
  }
  
  @Test
  public void TC_01_Login_With_Invalid_Email() {
	  
  }
  
  @Test
  public void TC_01_Login_With_Incorect_Email() {
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
