package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	//By Locators or Object Repository

	private By emailid=By.id("email");
	private By password=By.id("passwd");
	private By signinbutton=By.id("SubmitLogin");
	private By forgotPwd=By.linkText("Forgot your password");

	//constructor of page class

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}

	//page actions: features of page in the form of methods

	public String getTitleofpage()
	{
		return driver.getTitle();
	}

	public boolean forgotPwdLink()
	{
		return driver.findElement(forgotPwd).isDisplayed();
	}

	public void userName(String username)
	{
		driver.findElement(emailid).sendKeys(username);
	}

	public void password(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
	}

	public void loginButton()
	{
		driver.findElement(signinbutton).click();
	}
	
	public AccountsPage doLogin(String username,String pwd)
	{
		driver.findElement(emailid).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signinbutton).click();
		System.out.println("logged with "+username+" and "+pwd);
		return new AccountsPage(driver);
	}


}
