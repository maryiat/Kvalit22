package tests.automationcamp;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import tests.base.TestBase;

public class LocatorTechniques extends TestBase {

	@Test
	void locatorChaining() {
		String loginUrl = "https://play1.automationcamp.ir/login.html";
		page.navigate(loginUrl);
		
		Locator passwordInput = page.getByPlaceholder("Password");
		Locator usernameInput = page.getByPlaceholder("Username").
				and(page.getByRole(AriaRole.TEXTBOX));
		Locator loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in"));
		Locator header = page.getByText("Dinesh's Pizza House");

		usernameInput.fill("admin");
		passwordInput.fill("admin");
		loginButton.click();
		
		assertThat(header).isVisible();
	}
	
	@Test
	void verifyListItemCount() {
		
		String demoUrl = "https://testpages.eviltester.com/styled/webdriver-example-page";
		page.navigate(demoUrl);
		
		Locator atmServicesList = page.getByRole(AriaRole.LISTITEM);
		
		assertThat(atmServicesList).hasCount(3);
	}
	
	@Test
	void verifyListItemContents() {
		
		String demoUrl = "https://testpages.eviltester.com/styled/webdriver-example-page";
		page.navigate(demoUrl);
		
		Locator demoList = page.getByRole(AriaRole.LISTITEM);
		
		assertThat(demoList).hasText(new String[] {"List Item 1", "List Item 2", "List Item 3"});
	}
	
	@Test
	void filterByText() {
		
		String demoUrl = "https://testpages.eviltester.com/styled/index.html";
		page.navigate(demoUrl);
		
		Locator demoList = page.getByRole(AriaRole.LISTITEM);
		
		Locator listLink = demoList.filter(new Locator.FilterOptions().setHasText("Basic Web Page Example"));
		assertThat(listLink).hasCount(1);
	}
	
	@Test
	void findChildElement() {
		
		String demoUrl = "https://testpages.eviltester.com/styled/index.html";
		page.navigate(demoUrl);
		
		Locator demoList = page.getByRole(AriaRole.LISTITEM);
		
		Locator listLink = demoList.filter(new Locator.FilterOptions().setHasText("Basic Web Page Example"));
		listLink.getByRole(AriaRole.LINK).click();
		
		assertThat(page).hasURL("https://testpages.eviltester.com/styled/basic-web-page-test.html");
	}
	
}
