package pizzaapp.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class RegisterPage {

	private final Locator firstNameInput;
	private final Locator lastNameInput;
	private final Locator emailInput;
	private final Locator passwordInput;
	private final Locator confirmPasswordInput;
	private final Locator termsCheckbox;
	private final Locator registerButton;

	public RegisterPage(Page page) {
		this.firstNameInput = page.getByPlaceholder("First Name");
		this.lastNameInput = page.getByPlaceholder("Last Name");
		this.emailInput = page.getByPlaceholder("Email");
		this.passwordInput = page.getByPlaceholder("Password", new Page.GetByPlaceholderOptions().setExact(true));
		this.confirmPasswordInput = page.getByPlaceholder("Confirm Password");
		this.termsCheckbox = page.getByRole(AriaRole.CHECKBOX);
		this.registerButton = page.getByRole(AriaRole.BUTTON);
	}

	public void registerNewUser() {
		firstNameInput.fill("name");
		lastNameInput.fill("last name");
		emailInput.fill("my@email.com");
		passwordInput.fill("password");
		confirmPasswordInput.fill("password");
		termsCheckbox.check();
		registerButton.click();
	}
}
