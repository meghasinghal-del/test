package test_definition;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_Steps01 {
	public static WebDriver driver;
	@Given("^user is on home page$")
	public void user_is_on_home_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	       driver.get("http://demowebshop.tricentis.com/");
	       driver.manage().window().maximize();
	       assertEquals("Demo Web Shop", driver.getTitle());
	    }
	

	@Given("^Click on Login link$")
	public void click_on_Login_link() throws Throwable {
		driver.findElement(By.linkText("Log in")).click();
	     assertEquals("Demo Web Shop. Login", driver.getTitle());
	}

	@When("^When enters email and password and click login$")
	public void when_enters_email_and_password_and_click_login(DataTable arg1) throws Throwable {
		
		List<Map<String, String>> list = arg1.asMaps(String.class, String.class);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).get("email"));
			driver.findElement(By.name("Email")).sendKeys(list.get(i).get("email"));
			System.out.println(list.get(i).get("password"));
			driver.findElement(By.name("Password")).sendKeys(list.get(i).get("password"));
		
	       driver.findElement(By.linkText("Log in")).click();
	}
	}

	@Then("^Users logged in successfully$")
	public void users_logged_in_successfully() throws Throwable {
		 System.out.println(" login was successful ");

	       driver.close(); 

		      
	}


}
