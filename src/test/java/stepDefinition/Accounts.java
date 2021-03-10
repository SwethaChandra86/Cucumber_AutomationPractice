package stepDefinition;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;


public class Accounts {
	
	LoginPage loginpage=new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountspage;
	
	@Given("user is already logged into application")
	public void user_is_already_logged_into_application(DataTable dataTable) {
		List<Map<String,String>> credlist=dataTable.asMaps();
		String usernametologin=credlist.get(0).get("username");
		String passwordtologin=credlist.get(0).get("password");
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountspage=loginpage.doLogin(usernametologin, passwordtologin);
	}

	@Given("user is on accounts page")
	public void user_is_on_accounts_page() {
		String title=accountspage.getAccountsPageTitle();
		System.out.println(title);
	}

	@Then("user get accounts section count")
	public void user_get_accounts_section_count(DataTable sectionstable) {
		List<String> expectedaccountslist=sectionstable.asList();
		System.out.println("expectedaccountslist "+expectedaccountslist);
		List<String> actualaccountslist=accountspage.AccountsSectionList();
		System.out.println("actualaccountslist "+actualaccountslist);
		Assert.assertTrue(actualaccountslist.containsAll(expectedaccountslist));
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer sectioncount) {
	  Assert.assertTrue(accountspage.AccountsSectionCount()==sectioncount);
	}


}
