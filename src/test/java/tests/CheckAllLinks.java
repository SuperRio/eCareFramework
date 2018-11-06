package tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckAllLinks extends TestBase{
	public void testCities()
	{
		WebElement s = driver.findElement(By.className("js video no-videoautoplay"));
		List<WebElement> lists = s.findElements(By.tagName("option"));
		for (int i = 0 ; i < lists.size() ; i++ ) 
		{
			WebElement element = lists.get(i);
			String url = element.getAttribute("value"); 
			VerifyLink(url);
		}
	}	
	
	public static void VerifyLink(String urlLink) 
	{
		try {
			URL link = new URL(urlLink);
			HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
			httpConn.setConnectTimeout(2000);
			httpConn.connect();

			if(httpConn.getResponseCode() == 200 || httpConn.getResponseCode() == 202 || httpConn.getResponseCode() == 302) 
			{
				System.out.println(urlLink+" - "+httpConn.getResponseMessage());
			}
			else  {
				System.out.println(urlLink+" - "+httpConn.getResponseMessage());
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
