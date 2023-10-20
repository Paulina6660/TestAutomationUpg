package UITestAuto;

import static org.junit.Assert.assertEquals;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class filter_på_vald_produkt {
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
        tab.locator("#search input[placeholder='Sök']").fill("örhängen");
        tab.keyboard().press("Enter");
        
        
        //välja produkt
        tab.locator("#products > li:nth-child(1)").first().hover();
        tab.locator("#products > li:nth-child(1) > div.product-overlay > div.full-width.float-left > button.tiny.tiny-details.button.text-align-center").click();

        
        //välja specifika filter på en produkt
        tab.locator("text=6 mm : 31,90 kr").first().click();
        tab.locator("#render_variation_selector img").first().click();
        
        
       browser.close();   
        
	}    
}
