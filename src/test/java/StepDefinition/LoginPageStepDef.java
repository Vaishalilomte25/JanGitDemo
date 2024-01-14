package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;


public class LoginPageStepDef {
	WebDriver driver;
	@Given("user open orange hrm url")
	public void user_open_orange_hrm_url() {
	    driver = new EdgeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@When("user enter valid user and valid password")
	public void user_enter_valid_user_and_valid_password() {
	    driver.findElement(By.name("username")).sendKeys("Admin");
	    driver.findElement(By.name("password")).sendKeys("admin123");
	    driver.findElement(By.xpath("//button[text()=' Login ']")).click();
	    }

	@Then("user on home page and valid home page logo")
	public void user_on_home_page_and_valid_home_page_logo() {
	   
	   String actualTitle = driver.getTitle();

		Assert.assertEquals(actualTitle, "OrangeHRM");
		
		System.out.println(actualTitle);
	   
	}
}
