package cucumberframework.stepFiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Login {
	WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		this.driver=new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
	}
	
	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		this.driver.manage().deleteAllCookies();
		this.driver.quit();
		this.driver=null;
	}
	
	@Given("^User is on the udemy home page$")
	public void user_is_on_the_udemy_home_page() throws Throwable {
	   System.out.println("Method1");
	   driver.get("http://www.stackoverflow.com");
	}

	@And("^clicks on the login button$")
	public void clicks_on_the_login_button() throws Throwable {
		System.out.println("Method2");
		Thread.sleep(6000);
		WebElement we = driver.findElement(By.xpath("//a[@href='https://stackoverflow.com/users/login?ssrc=head&returnurl=https%3a%2f%2fstackoverflow.com%2f']"));
		
		Thread.sleep(3000);
		we.click();
		
	}

	@When("^user enters valid username and password$")
	public void user_enters_valid_username_and_password() throws Throwable {
		System.out.println("Method3");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Enter username");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Enter password");
		
	}

	@And("^clicks Login$")
	public void clicks_Login() throws Throwable {
		System.out.println("Method4");
		Thread.sleep(6000);
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,450)", "");
		driver.findElement(By.id("submit-button")).click();

	}

	@SuppressWarnings("deprecation")
	@Then("^user should be successfully logged in$")
	public void user_should_be_successfully_logged_in() throws Throwable {
		System.out.println("Method5");
		Thread.sleep(3000);
		WebElement Loginname = 	driver.findElement(By.xpath("//a[@href='/questions/ask']"));
	Assert.assertEquals(true, Loginname.isDisplayed());
	}
}
