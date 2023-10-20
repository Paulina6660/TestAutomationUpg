package UITestAuto;

import static org.junit.Assert.assertEquals;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class Navigera_till_sida {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
		Page tab = browser.newPage();
		
		//navigera till hemsida
		tab.navigate("https://www.crazy-factory.com/sv/");
		String title = tab.title();
        assertEquals("Crazy Factory | Världens största piercingbutik online", title);
        
        //acceptera cookies om de kommer upp
        try {
            tab.waitForSelector("#cookie-popup", new Page.WaitForSelectorOptions().setTimeout(3000));
            tab.click("#cookie-accept-button");
            
        } catch (PlaywrightException e) {}
        
        
        browser.close();

	}

}
