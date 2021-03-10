package appHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.*;

public class ApplicationHooks {
	
	private DriverFactory driverfactory;
	private WebDriver driver;
	private ConfigReader ConfigReader;
	Properties prop;
	
	@Before(order=0)
	public void getProperty()
	{
		ConfigReader=new ConfigReader();
		prop=ConfigReader.init_prop();
	}
	

	@Before(order=1)
	public void launchBrowser()
	{
		String browsername=prop.getProperty("browser");
		driverfactory=new DriverFactory();
		driver=driverfactory.init_browser(browsername);
	}
	
	@After(order=0)
	public void quitBrowser()
	{
		driver.quit();
	}
	
	@After(order=1)
	
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			String screenShotName=scenario.getName().replaceAll(" ", "_");
			TakesScreenshot screenshot=(TakesScreenshot)driver;
			byte[] sourcepath=screenshot.getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath, "image/png", screenShotName);
			
		}
		
		
	}

}
