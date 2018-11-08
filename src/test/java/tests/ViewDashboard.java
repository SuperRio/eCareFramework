package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DashboardPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ViewDashboard extends TestBase{
	DashboardPage dashboardPage;

	@Test(priority=0)
	@Given("^I the user is logged in$")
	public void i_the_user_is_logged_in() throws Throwable {
		dashboardPage = new DashboardPage(driver);
		//dashboard.detectCookieDdl();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//select[@id='dropDownSwitcher']"));
		js.executeScript("arguments[0].setAttribute('style', 'display: true;')",element);
		Select ss = new Select(driver.findElement(By.xpath("//select[@id='dropDownSwitcher']")));
		ss.selectByValue("develop");
		dashboardPage.clickOnDevelopmentStubs();
		driver.get("https://simplicity.wf-de.vodafone.com/meinvodafone/account/");
		// if you want to go to SIT environment use the below link
		//driver.get("https://www.vodafone.de/meinvodafone/account");
	}

	@Test(priority=1)
	@When("^I  go to dashboard$")
	public void i_go_to_dashboard() throws Throwable {
		String username = "marie";
		String password = "marie";
		dashboardPage.LoginSt(username, password);
		dashboardPage.ClickToGoToDashboard();
	}

	@Test(priority=2)
	@Then("^I  The user shall view his contracts and subscribers$")
	public void i_The_user_shall_view_his_contracts_and_subscribers() throws Throwable {
		System.out.println(driver.getCurrentUrl());
		Assert.assertEquals(driver.getCurrentUrl(), "https://simplicity.wf-de.vodafone.com/meinvodafone/services/");
		String mobile = driver.findElement(By.xpath("//a[@id='dashboard:mobile']")).getAttribute("accordion-id");
		System.out.println(mobile);
		Assert.assertEquals(mobile, "dashboard:mobile");
	}

}
