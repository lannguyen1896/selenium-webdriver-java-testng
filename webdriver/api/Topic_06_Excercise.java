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
	String loginPageUrl, customerId;
	String name, dob, addr, city, state, pinno, phone, email;
	String editname, editdob, editaddr, editcity, editstate, editpinno, editphone, editemail;
	By nameBy = By.name("name");
	By dobBy = By.name("dob");
	By cityBy = By.name("city");
	By stateBy = By.name("state");
	By addrBy = By.name("addr");
	By pinnoBy = By.name("pinno");
	By phoneBy = By.name("telephoneno");
	By emailBy = By.name("emailid");
	By passwordBy = By.name("password");

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/v4");
		loginPageUrl = driver.getCurrentUrl();
		
		email = generateEmail();
		name = "Donald Trump";
		dob = "1958-04-05";
		addr ="912 Village Center" ;
		city = "Saint Louis";
		state = "Missouri";
		pinno = "631433";
		phone = "3148386567";
		
		editemail = generateEmail();
		editname = "Jessica Trump";
		editdob = "1958-10-12";
		editaddr ="912 Village  ABC Center" ;
		editcity = "Tokyo";
		editstate = "Missouri New Legend";
		editpinno = "234733";
		editphone = "315666567";

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
		//Thread.sleep(10000);
		
		//verify information
		Assert.assertEquals(driver.findElement(By.className("heading3")).getText(), "Customer Registered Successfully!!!");
		
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(), name);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText(), dob);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), addr);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), city);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(), pinno);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(), phone);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(), email);
		customerId = driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText();
		
	}
	public String generateEmail() {
		Random rand = new Random();
		return "donald" + rand.nextInt(9999) + "@github.io";
	}
	
	@Test
	public void TC_04_Edit_Customer() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Edit Customer']")).click();
		
		driver.findElement(By.name("cusid")).sendKeys(customerId);
		driver.findElement(By.name("AccSubmit")).click();
		
		//verify
		Assert.assertEquals(driver.findElement(nameBy).getAttribute("value"), name);
		Assert.assertEquals(driver.findElement(dobBy).getAttribute("value"), dob);
		Assert.assertEquals(driver.findElement(addrBy).getAttribute("value"), addr);
		Assert.assertEquals(driver.findElement(cityBy).getAttribute("value"), city);
		Assert.assertEquals(driver.findElement(stateBy).getAttribute("value"), state);
		Assert.assertEquals(driver.findElement(pinnoBy).getAttribute("value"), pinno);
		Assert.assertEquals(driver.findElement(phoneBy).getAttribute("value"), phone);
		Assert.assertEquals(driver.findElement(emailBy).getAttribute("value"), email);
		
		driver.findElement(addrBy).clear();
		driver.findElement(By.name("addr")).sendKeys(editaddr);
		driver.findElement(cityBy).clear();
		driver.findElement(By.name("city")).sendKeys(editcity);
		driver.findElement(stateBy).clear();
		driver.findElement(By.name("state")).sendKeys(editstate);
		driver.findElement(pinnoBy).clear();
		driver.findElement(By.name("pinno")).sendKeys(editpinno);
		driver.findElement(phoneBy).clear();
		driver.findElement(By.name("telephoneno")).sendKeys(editphone);
		driver.findElement(emailBy).clear();
		driver.findElement(By.name("emailid")).sendKeys(email);
		driver.findElement(By.name("sub")).click();
		
        Assert.assertEquals(driver.findElement(By.className("heading3")).getText(), "Customer details updated Successfully!!!");
		
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText(), customerId);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(), name);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText(), dob);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), editaddr);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), editcity);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(), editstate);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(), editpinno);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(), editphone);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(), editemail);
	}
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
