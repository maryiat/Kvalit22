

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginTest extends TestBase {

	@Test
	void loginAsAdmin() {
		//Setup
		
		//Navigation
		System.out.println("Opening automation camp page.");
		String loginUrl = "https://play1.automationcamp.ir/login.html";
		page.navigate(loginUrl);
		
		//Locate elements
		System.out.println("Locating elements on automation camp page.");

		Locator usernameInput = page.getByPlaceholder("Username");
		Locator passwordInput = page.getByPlaceholder("Password");
		Locator loginButton = page.getByRole(AriaRole.BUTTON, 
				new Page.GetByRoleOptions().setName("Log in"));
		Locator header = page.getByText("Dinesh's Pizza House");

		//Interact with elements
		System.out.println("Fill user name and password.");

		usernameInput.fill("admin");
		passwordInput.fill("admin");
		loginButton.click();
		
		//Assert result
		System.out.println("Assert that header is visible.");

		assertThat(header).isVisible();
	}
	
	@Test
	void failedTest() {
		assertTrue(false);
	}
}


