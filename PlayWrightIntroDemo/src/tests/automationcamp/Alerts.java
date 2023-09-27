package tests.automationcamp;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import tests.base.TestBase;

public class Alerts extends TestBase {
	
	@Test
	void alertVerification() {
		String demoUrl = "http://autopract.com/selenium/alert5/";
		page.navigate(demoUrl);
		
		//Dialog listener
		page.onDialog(dialog -> {
			System.out.println(dialog.message());
		    dialog.accept();
		    });
		
		Locator popupButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Trigger an Alert") );
		popupButton.click();
		
		Locator successMessage = page.getByText("You clicked on Ok button.");
		assertThat(successMessage).isVisible();
	}
}
