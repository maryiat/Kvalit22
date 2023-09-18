package testrunner.tests.automationcamp;
import org.junit.jupiter.api.Test;

import testrunner.base.TestBase;


public class Navigation extends TestBase{
	
	  @Test
	  void goBackAndForce() {
		  
		  String baseUrl = "https://play1.automationcamp.ir/";
		  String loginUrl = "https://play1.automationcamp.ir/login.html";
		  
		  page.navigate(baseUrl);
		  page.navigate(loginUrl);
		  
		  page.goBack();
		  page.goForward();
		  page.reload();

	  }
}
