package org.example;

import static org.junit.Assert.*;

import java.nio.file.Paths;
import java.sql.Time;
import java.util.regex.Pattern;
import org.example.ConfigFileReader;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginSearchTestonChrome {

	public Playwright playwright;
	public Page p1;
	ConfigFileReader configFileReader = new ConfigFileReader();

	@BeforeTest
	public void setup() {
		playwright = Playwright.create();
		LaunchOptions lp = new LaunchOptions();
//		lp.setChannel("chrome"); // chrome
		lp.setChannel(configFileReader.getBrowser()); // chrome
		lp.setHeadless(false);
		lp.setSlowMo(50);
		Browser browser = playwright.chromium().launch(lp);
		BrowserContext brcx1 = browser.newContext(new Browser.NewContextOptions().setViewportSize(1280, 720));
		p1 = brcx1.newPage();
		System.out.println("CHROME - INSIDE BEFORE TEST SETUP");
//		Browser browser= playwright.chromium().launch(executable_path='/opt/path_to_bin');
//		browser = playwrights.chromium.launch(executable_path='/opt/path_to_bin');
//		p.chromium.launch_persistent_context(user_dir, headless=False)
//		playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));

//		p1.navigate("https://nejm.org");

	}

	@Test(priority = 1)
	public void login() throws InterruptedException {
		System.out.println("CHROME - INSIDE LOGIN TEST ");
//		p1.navigate("https://catalyst.nejm.org");
		p1.navigate(configFileReader.getApplicationUrl());
//		p1.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("chromeLaunched.png")));
		assertThat(p1.getByTitle(configFileReader.getTitle()));
		Locator getSignin = p1.locator("header").getByRole(AriaRole.LINK,
				new Locator.GetByRoleOptions().setName("Sign In"));
		assertThat(getSignin).isVisible();
		getSignin.click();
		Locator locateSignin = p1.locator("header").getByRole(AriaRole.HEADING,
				new Locator.GetByRoleOptions().setName("Sign In"));
		locateSignin.isVisible();
		Locator fillSignInEmailAddress = p1.locator("form").getByRole(AriaRole.TEXTBOX,
				new Locator.GetByRoleOptions().setName("Email Address"));
		fillSignInEmailAddress.fill(configFileReader.getUserName());
		Locator fillSignInEmailPassword = p1.locator("form").getByRole(AriaRole.TEXTBOX,
				new Locator.GetByRoleOptions().setName("Password"));
		fillSignInEmailPassword.fill(configFileReader.getPassword());
		Locator clickSignIn = p1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In"));
		clickSignIn.click();
		Locator signedUserLink = p1.locator("a").filter(new Locator.FilterOptions().setHasText(configFileReader.getSignedUserName()))
				.first();
		signedUserLink.isVisible();
		Thread.sleep(2000);
//		Locator searchButton = p1.locator("xpath=//button[@aria-label='Search']");// p1.getByRole(AriaRole.BUTTON);
//		searchButton.isEnabled();
//		searchButton.click();
//		p1.locator("xpath=//button[@aria-label='Search']").click();
//	    Thread.sleep(2000);
//	    p1.locator("xpath=//form[contains(@class, 'search')]/div/input[@name='q']").focus();//.fill("covid");
////	    p1.locator("xpath=//form[contains(@class, 'search')]/div/input[@name='q']").click();
//	    p1.locator("xpath=//form[contains(@class, 'search')]/div/input[@name='q']").fill("covid");
//	    Locator keywordSearchTextbox=
//
//	    Locator keywordSearchTextbox=p1.getByPlaceholder("Enter keyword, author, title or citation");//p1.locator("css=.ng-quick-search_allField");
//	    keywordSearchTextbox.focus();
//	    keywordSearchTextbox.fill("covid");
//	    Thread.sleep(3000);
//	    Locator keywordSearchSubmit= p1.locator("css=.ng-quick-search_textBtn");
//	    keywordSearchSubmit.click();
//	     Thread.sleep(2000);
//	     p1.getByText("Sign In").isVisible();
//	     p1.getByText("Sign In").click();
//	     p1.locator("a.signin-header").click();
//	     System.out.println("Title of the page: " + p1.getByTitle("/The New England Journal of Medicine/"));
//	     page.locator('svg[aria-label="Comment"]').nth(1);
		// Expect a title "to contain" a substring.
//         assertThat(p1).hasTitle(Pattern.compile("The New England Journal of Medicine"));
//         assertThat(p1.locator("button=Sign In")).isVisible();
//         Locator getSignin = p1.locator("text=Sign In");
//	     Thread.sleep(5000);
//         assertThat(getSignin).hasAttribute("href", "/sign-in?articleView=free&uri=%2F");
//         Locator getSignin = p1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In"));
//         Thread.sleep(2000);

//         Thread.sleep(2000);

//	     Thread.sleep(2000);
//	     p1.navigate("https://www.nejm.org/sign-in?articleView=free&uri=%2F");
//         if(getSignin.isVisible())
//         {
//        	 getSignin.click();
//         }

//         p1.locator("form").filter(new Locator.FilterOptions().setHasText("Sign In")).getByPlaceholder("Email Address").click();
//		 p1.locator("form").filter(new Locator.FilterOptions().setHasText("Sign In")).getByPlaceholder("Email Address").fill("Onegod@111");

//		 Thread.sleep(3000);
//		 assertThat(p1.getByText("Satendra Pratap Singh")).isVisible();

//		 Thread.sleep(2000);		 
//         Locator clickSignin = p1.locator("button").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Sign In"));
//         clickSignin.isVisible();
//         clickSignin.click();
		// p1.locator(g).click();
//		 p1.locator("form").filter(new Locator.FilterOptions().setHasText("Login")).getByPlaceholder("Email Address").click();
//		 p1.locator("form").filter(new Locator.FilterOptions().setHasText("Login")).getByPlaceholder("Email Address").fill("Onegod@111");
//		 p1.getByPlaceholder("Password").click();
//		 p1.getByPlaceholder("Password").fill("Onegod@111");
//		 p1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
//		 assertThat(p1.locator("b")).containsText("XYZ");
	}

//	@Test (priority=2)
//	public void Search()
//	{
//		System.out.println("CHROME - INSIDE SEARCH TEST");
//
//		p1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Products")).click(); //need to add
//		p1.waitForTimeout(5000);  
//		p1.getByPlaceholder("Search Product").click();
//		p1.getByPlaceholder("Search Product").fill("GRAPHIC DESIGN MEN T SHIRT");
//		p1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("")).click();
//		 assertThat(p1.locator("body")).containsText("GRAPHIC DESIGN MEN T SHIRT - BLUE");  // Assertion after search
//	      
//		
//	   
//	}

	@AfterTest
	public void teardown() {
		System.out.println("CHROME - INSIDE AFTER TEST TEARDOWN");
		p1.context().browser().close();

	}

}