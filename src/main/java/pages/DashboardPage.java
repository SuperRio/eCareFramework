package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DashboardPage extends PageBase{

	public DashboardPage(WebDriver driver) {
		super(driver);
	}	
	public void detectCookieDdl ()
	{
		JavascriptExecutor js = (JavascriptExecutor) drv;
		WebElement element = drv.findElement(By.xpath("//select[@id='dropDownSwitcher']"));
		js.executeScript("arguments[0].setAttribute('style', 'display: true;')",element);
		Select ss = new Select(drv.findElement(By.xpath("//select[@id='dropDownSwitcher']")));
		ss.selectByValue("develop");
	}
	
	@FindBy(xpath = "//a[@data-mode='dev']")
	public static WebElement developmentStubsBtn;
	public void clickOnDevelopmentStubs()
	{
		developmentStubsBtn.click();
	}
	
	@FindBy(xpath = "//input[@id='txtUsername']")
	public static WebElement usernameLgn;
	
	@FindBy(xpath = "//input[@id='txtPassword']")
	public static WebElement passwordLgn;
	
	@FindBy(xpath = "//button[@class='btn login-btn']")
	public static WebElement loginBtn;
	
	public void LoginSt(String username, String password)
	{
		usernameLgn.sendKeys(username);
		passwordLgn.sendKeys(password);
		loginBtn.click();
	}
	
	@FindBy(xpath = "//a[@id='transaction-link']")
	public static WebElement goToDashboard;
	
	public void ClickToGoToDashboard()
	{
		goToDashboard.click();
	}
	
	
	
}
