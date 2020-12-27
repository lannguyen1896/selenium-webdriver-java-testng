package api;

import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.GetText;

import org.testng.annotations.BeforeClass;

import java.sql.Driver;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_06_Excercise {
	WebDriver driver;
	String userID;
	String password;
	String loginPageUrl, customerId, email;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/v4");
		loginPageUrl = driver.getCurrentUrl();
		email = generateEmail();

	}

	@Test
	public void TC_01_Register() {
		driver.findElement(By.xpath("//a[text()='here']")).click();
		driver.findElement(By.name("emailid")).sendKeys("autotmation@gmail.com");
		driver.findElement(By.name("btnLogin")).click();
		userID= driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();

	}
	
	@Test
	public void TC_02_Login() {
		driver.get(loginPageUrl);
		driver.findElement(By.name("uid")).sendKeys(userID);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//marquee[@class='heading3']")).getText(), "Welcome To Manager's Page of Guru99 Bank");
			
	}
	
	@Test
	public void TC_03_New_Customer() throws InterruptedException {
		//Add new
		driver.findElement(By.xpath("//a[text()='New Customer']")).click();
		driver.findElement(By.name("name")).sendKeys("Donald Trump");
		driver.findElement(By.name("dob")).sendKeys("04/05/1958");
		driver.findElement(By.name("addr")).sendKeys("912 Village Center");
		driver.findElement(By.name("city")).sendKeys("Saint Louis");
		driver.findElement(By.name("state")).sendKeys("Missouri");
		driver.findElement(By.name("pinno")).sendKeys("631433");
		driver.findElement(By.name("telephoneno")).sendKeys("3148386567");
		driver.findElement(By.name("emailid")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.name("sub")).click();
		Thread.sleep(10000);
		
		//verify information
		Assert.assertEquals(driver.findElement(By.className("heading3")).getText(), "Customer Registered Successfully!!!");
		
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(), "Donald Trump");
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText(), "1958-04-05");
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), "912 Village Center");
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), "Saint Louis");
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(), "Missouri");
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(), "631433");
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(), "3148386567");
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(), email);
		customerId = driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText();
		
	}
	public String generateEmail() {
		Random rand = new Random();
		return "donald" + rand.nextInt(9999) + "@github.io";
	}
	
	@Test
	public void TC_04_Edit_Customer() {
		
	}
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
