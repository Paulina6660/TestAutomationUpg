package UITestAuto;

import static org.junit.Assert.assertEquals;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class sökning {

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
            
        } catch (PlaywrightException e) {
            System.out.println("Cookies popup not found. Skipping...");

        }
        
        
        //sök
        tab.locator("#search input[placeholder='Sök']").click();
        tab.locator("#search input[placeholder='Sök']").fill("stjärna");
        tab.locator("#search input[type='submit']").click();
        
        //ny sökning
        tab.locator("#search input[placeholder='Sök']").click();
        tab.locator("#search input[placeholder='Sök']").fill("örhängen");
        tab.keyboard().press("Enter");


        browser.close();
        
        
    }

}