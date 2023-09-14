package extras;
import com.microsoft.playwright.*;
import java.util.Random;
import java.nio.file.Paths;

public class BasicTest {
	//NB: it's a plain old simple java main method
    public static void main(String[] args) {
    	//Create Playwright environment
        try (Playwright playwright = Playwright.create()) {
        	
        	//Create a browser instance which by default is running in headless mode
        	//For demonstration purposes using slow motion setting
        	
            Browser browser = //playwright.chromium().launch();
        	playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(5000));
            
            //Create an instance of Page class and navigate to a specified web address using this object
            Page page = browser.newPage();
            page.navigate("http://playwright.dev");
            
            //Catch page title and display it in the terminal / command line 
            System.out.println("Page title: " + page.title());
            
            //Take a screenshot of web page under test 
            Random rand = new Random();
            int random = rand.nextInt(100000);
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example_" + random + ".png")));
        }
    }
}