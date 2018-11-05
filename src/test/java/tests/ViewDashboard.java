package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ViewDashboard extends TestBase{

	@Test(priority=0)
	@Given("^I the user is logged in$")
	public void i_the_user_is_logged_in() throws Throwable {
		/*	JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//select[@id='dropDownSwitcher']"));
		js.executeScript("arguments[0].setAttribute('style', 'display: true;')",element);
		Select ss = new Select(driver.findElement(By.xpath("//select[@id='dropDownSwitcher']")));
		ss.selectByValue("develop");
		WebElement development = driver.findElement(By.xpath("//a[@data-mode='dev']"));
		development.click();
		driver.get("https://simplicity.wf-de.vodafone.com/meinvodafone/account/");*/
		driver.get("https://www.vodafone.de/meinvodafone/account");
	}

	@Test(priority=1)
	@When("^I  go to dashboard$")
	public void i_go_to_dashboard() throws Throwable {
		WebElement usrnameTxtbox = driver.findElement(By.xpath("//input[@id='txtUsername']"));
		usrnameTxtbox.sendKeys("Vodafone Kay 02B");
		WebElement pswrdTextbox = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		pswrdTextbox.sendKeys("GerKonPu1999");
		WebElement lgnBtn = driver.findElement(By.xpath("//button[@class='btn login-btn']"));
		lgnBtn.click();
		WebElement goToDashboard = driver.findElement(By.xpath("//a[@id='transaction-link']"));
		goToDashboard.click();
	}

	@Test(priority=2)
	@Then("^I  The user shall view his contracts and subscribers$")
	public void i_The_user_shall_view_his_contracts_and_subscribers() throws Throwable {
		System.out.println(driver.getCurrentUrl());
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.vodafone.de/meinvodafone/services/");
	}

}
