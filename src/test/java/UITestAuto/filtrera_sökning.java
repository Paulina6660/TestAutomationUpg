package UITestAuto;

import static org.junit.Assert.assertEquals;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class filtrera_sökning {
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
		Page tab = browser.newPage();
		
		//navigera till hemsida
		tab.navigate("https://www.crazy-factory.com/sv/");
		String title = tab.title();
        assertEquals("Crazy Factory | Världens största piercingbutik online", title);     
  
	
	    //sökning
        tab.locator("#search input[placeholder='Sök']").click();
        tab.locator("#search input[placeholder='Sök']").fill("stjärna");
        tab.locator("#search input[type='submit']").click();
        
        
        //filtrera kategori
        tab.locator("#products_listing_container >> text=Näspiercingar").click();
        
        //filtrera enligt pris
      //  tab.locator(".sbSelector sorting-selector >> text=Popularitet").click();
      //  tab.locator("//a[@class='sbFocus'][normalize-space()='Pris']").click();
        
        browser.close();

	}
}
