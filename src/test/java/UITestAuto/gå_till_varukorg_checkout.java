package UITestAuto;

import static org.junit.Assert.assertEquals;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class gå_till_varukorg_checkout {
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
    
    
        //lägga till i varukorg
        tab.locator("#add_to_cart").click();
        
        
        //gå till varukorg
        tab.locator("#render_cart_menu").click();
        
        //kassa/checkout med inloggning
        tab.waitForSelector("#button_checkout").click();
        
        //checkout med paypal utan inloggning
        tab.locator("#buttons-container").click(); 
        
        
        browser.close();
        
    }
}
