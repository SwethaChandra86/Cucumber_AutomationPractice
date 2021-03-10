package TestRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src\\test\\resources\\Appfeatures"},
		glue={"stepDefinition","appHooks"},
		plugin={"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},monochrome=true,publish = true
		)
public class MyTestRunner {
	
	
	

}
