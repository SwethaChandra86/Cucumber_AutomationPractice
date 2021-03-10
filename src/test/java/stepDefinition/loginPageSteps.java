package stepDefinition;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.*;


public class loginPageSteps {

	private LoginPage loginpage=new LoginPage(DriverFactory.getDriver());
	private static String title;

	@Given("user is on login page")
	public void user_is_on_login_page() {

		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {

		title=loginpage.getTitleofpage();
		System.out.println(title);

	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {	

		Assert.assertTrue(title.contains(expectedTitleName));

	}

	@Then("forgot password link should be displayed")
	public void forgot_password_link_should_be_displayed() {

		Assert.assertTrue(loginpage.forgotPwdLink());

	}

	@When("enters username {string}")
	public void enters_username(String username) {

		loginpage.userName(username);

	}

	@When("enters password {string}")
	public void enters_password(String pwd) {

		loginpage.password(pwd);

	}

	@When("clicks on login button")
	public void clicks_on_login_button() {

		loginpage.loginButton();
	}


	@Then("the title of page should be {string}")
	public void the_title_of_page_should_be(String homePageTitle) {

		Assert.assertTrue(title.contains(homePageTitle));

	}



}
