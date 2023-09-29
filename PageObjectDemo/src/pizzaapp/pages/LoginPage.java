package pizzaapp.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage {

	private final Page page;

	Locator usernameInput;
	Locator passwordInput;
	Locator loginButton;

	public LoginPage(Page page) {
		this.page = page;
		this.usernameInput = page.getByPlaceholder("Username");
		this.passwordInput = page.getByPlaceholder("Password");
		this.loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in"));
	}

	public void openLoginPage() {
		String loginUrl = "https://play1.automationcamp.ir/login.html";
		page.navigate(loginUrl);
	}

	public void login(String userName, String password) {
		usernameInput.fill(userName);
		passwordInput.fill(password);
		loginButton.click();
	}

}
