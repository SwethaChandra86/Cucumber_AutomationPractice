package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	WebDriver driver;
	public static ThreadLocal<WebDriver> tldriver=new ThreadLocal<WebDriver>();
	
	/*this method used to initialize thread local driver on the basis of given browser value
	@param browser
	@return tldriver */

	public WebDriver init_browser(String browser)
	{
		System.out.println("browser type is "+browser);
		if(browser.contentEquals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			tldriver.set(driver);
		}
		else
			if(browser.contentEquals("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				tldriver.set(driver);
			}
			else
			{
				System.out.println("please send correct browser value "+browser);
			}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();


	}
	public static WebDriver getDriver()
	{
		return tldriver.get();
	}


}
