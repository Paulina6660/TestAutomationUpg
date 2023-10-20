package UITestAuto;

import static org.junit.Assert.assertEquals;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class lägga_till_produkt_till_varukorg {
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
        
        
        //lägga till i varukorg från hover "quick buy"
        tab.locator("#products > li:nth-child(1)").first().hover();
        
       	tab.locator("#products > li:nth-child(1) > div.product-overlay > div.full-width.float-left > button.tiny.quick-buy-button.button.text-align-center.quick-buy-button").scrollIntoViewIfNeeded();
        tab.waitForTimeout(1000);
        
        tab.evaluate("() => document.querySelector('#products > li:nth-child(1) > div.product-overlay > div.full-width.float-left > button.tiny.quick-buy-button.button.text-align-center.quick-buy-button').click()");
        tab.waitForTimeout(1000);

        tab.waitForSelector("#add_to_cart").click(); 
         
        
        //välja produkt
        tab.locator("#products > li:nth-child(1)").first().hover();
        tab.locator("#products > li:nth-child(1) > div.product-overlay > div.full-width.float-left > button.tiny.tiny-details.button.text-align-center").click();
        
        
        //lägga till i varukorg
        tab.locator("#add_to_cart").click();
        

        browser.close();
        
   }
}