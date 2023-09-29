package pizzaapp.test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.junit.jupiter.api.Test;

import pizzaapp.pages.LoginPage;
import pizzaapp.pages.RegisterPage;
import pizzaapp.testbase.TestBase;


public class RegisterTest extends TestBase{
	@Test
	void loginAsAdmin() {
		LoginPage loginPage = new LoginPage(page);
		
		loginPage.openLoginPage();
		loginPage.openLoginPage();
		
		assertThat(page).hasTitle("Register!");
		
		RegisterPage registerPage = new RegisterPage(page);
		registerPage.registerNewUser();
		
		assertThat(page).hasTitle("Confirmation!");
	}
}
