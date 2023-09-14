package testrunner.tests;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Locator;

import testrunner.base.TestBase;


public class CreateToDoList extends TestBase{
	  @Test
	  void addTodoItem() {
		  
		  //Pre-requisite: open web page
		  page.navigate("https://demo.playwright.dev/todomvc/");
		  
		  //Test steps: create a todo item
		  Locator toDoInput = page.getByPlaceholder("What needs to be done?");
		  toDoInput.click();
		  toDoInput.fill("clean table");
		  toDoInput.press("Enter");
	      
	      //Assert that actions resulted in some changes on the web page: verify that a todo item was added
	      Locator toDoItem = page.getByTestId("todo-title");
	      assertThat(toDoItem).containsText("clean table fdajkdfkjlödlöfdkjsa");
	  }
}
