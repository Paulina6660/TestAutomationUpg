package UITestAuto;

import static org.junit.Assert.assertEquals;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class mer_filter_inkl_kategoriTab {
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
		Page tab = browser.newPage();
		
		//navigera till hemsida
		tab.navigate("https://www.crazy-factory.com/sv/");
		String title = tab.title();
        assertEquals("Crazy Factory | Världens största piercingbutik online", title);
        
	
	    //välja kategori tab
	    tab.locator("#topbarMenu > nav > div.background-color-wrap > div:nth-child(2) > div > ul > li:nth-child(2)").first().hover();
	    tab.locator("div.ab-test-switching-menu-a div:nth-child(2) ul:nth-child(1) li:nth-child(1) a:nth-child(1) span:nth-child(1)").click();
	   
	    //filter färg blå
	    tab.locator("//aside[@class='small-15 medium-4 large-3 column']//li[@title='blå']").click();
	    
	    //filter öppna storleksmeny & val
	    tab.locator("//aside[contains(@class,'small-15 medium-4 large-3 column')]//span[contains(@class,'small_boxes')]").click();
	    tab.locator("//div[contains(@data-status,'open')]//span[contains(@class,'filter_name')][normalize-space()='10']").click();
	    
	    
	    browser.close();
	
   }
}
