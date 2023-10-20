package UITestAuto;

import static org.junit.Assert.assertEquals;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext.WaitForPageOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class Logga_in {
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
  
            tab.waitForSelector("[role='button'[name='cookie_banner_button blue_button']").click();
            
        } catch (PlaywrightException e) {
        	System.out.println("Cookies popup not found. Skipping...");
        }
        
        //logga in

		tab.waitForSelector("[data-testid='profile-menu-overlay-button']").click();

        tab.locator("#signin_content input[placeholder='Epostadress']").click();
        tab.locator("#signin_content input[placeholder='Epostadress']").fill("test123@gmail.com");

        tab.locator("#signin_content input[placeholder='Lösenord']").click();
        tab.locator("#signin_content input[placeholder='Lösenord']").fill("abc123");

		tab.click("//button[normalize-space()='LOGGA IN']");
        
               
        browser.close();

	}

}
