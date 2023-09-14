package testrunner.tests;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import testrunner.base.TestBase;


public class SearchWiki extends TestBase{
	  @Test
	  void shouldSearchWiki() {
	    page.navigate("https://www.wikipedia.org/");
	    page.locator("input[name=\"search\"]").click();
	    page.locator("input[name=\"search\"]").fill("playwright");
	    page.locator("input[name=\"search\"]").press("Enter");
	    assertEquals("https://en.wikipedia.org/wiki/Playwright", page.url());
	  }
}
