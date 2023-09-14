package extras;
import com.microsoft.playwright.*;
import java.nio.file.Paths;

public class TracingExample {
    public static void main(String[] args) {
    	//Create Playwright environment
        try (Playwright playwright = Playwright.create()) {
        	
        	Browser browser = playwright.chromium().launch();
        	BrowserContext context = browser.newContext();

        	// Start tracing before creating / navigating a page.
        	context.tracing().start(new Tracing.StartOptions()
        	  .setScreenshots(true)
        	  .setSnapshots(true)
        	  .setSources(true));

        	Page page = context.newPage();
        	page.navigate("https://playwright.dev");

        	// Stop tracing and export it into a zip archive.
        	context.tracing().stop(new Tracing.StopOptions()
        	  .setPath(Paths.get("trace.zip")));
        }
    }
}