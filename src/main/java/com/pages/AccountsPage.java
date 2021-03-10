package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	
	WebDriver driver;
	private By Accountssection=By.cssSelector("div#center_column span");
	
	public AccountsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public int AccountsSectionCount()
	{
		return driver.findElements(Accountssection).size();
	}
	
	public ArrayList<String> AccountsSectionList()
	{
		ArrayList<String> accountslist=new ArrayList<String>();
		List<WebElement> list= driver.findElements(Accountssection);
		for(WebElement name:list)
		{
			String text=name.getText();
			System.out.println(text);
			accountslist.add(text);
		}
		return accountslist;
	}
	
	public String getAccountsPageTitle()
	{
		return driver.getTitle();
	}
	

}
