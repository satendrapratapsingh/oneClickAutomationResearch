package org.example;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.nio.file.Paths;
import org.example.ConfigFileReader;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.options.AriaRole;

public class LoginSearchTestonFirefox {

	public Playwright playwright;
	public Page p1;
	ConfigFileReader configFileReader = new ConfigFileReader();
	
	@BeforeTest
	public void setup()
	{
		playwright = Playwright.create();
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("firefox"); // msedge
		lp.setHeadless(true);
		lp.setSlowMo(50);
		Browser browser = playwright.firefox().launch(lp);
		BrowserContext brcx1 = browser.newContext(new Browser.NewContextOptions().setViewportSize(1280, 720));
		p1 = brcx1.newPage();
//		p1.navigate("https://catalyst.nejm.org");
//		p1.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("firefoxLaunched.png")));
		System.out.println("FF - INSIDE BEFORE TEST SETUP");
	}
	
	@Test (priority=1)
	public void login() throws InterruptedException
	{   
		System.out.println("FF - INSIDE LOGIN TEST ");
		p1.navigate(configFileReader.getApplicationUrl());
//		p1.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("firefoxLaunched.png")));
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
//		 p1.navigate("https://automationexercise.com/login");
//		 p1.locator("form").filter(new Locator.FilterOptions().setHasText("Login")).getByPlaceholder("Email Address").click();
//		 p1.locator("form").filter(new Locator.FilterOptions().setHasText("Login")).getByPlaceholder("Email Address").fill("Onegod@111");
//		 p1.getByPlaceholder("Password").click(); 
//		 p1.getByPlaceholder("Password").fill("Onegod@111");
//		 p1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
//		 assertThat(p1.locator("b")).containsText("Mohd Aamir");
//	      
	}
//	
//	@Test (priority=2)
//	public void Search()
//	{
//		System.out.println("FF - INSIDE SEARCH TEST");
//
//		p1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Products")).click();
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
	public void teardown()
	{
		System.out.println("FF - INSIDE AFTER TEST TEARDOWN");
		p1.context().browser().close();
		
	}
	
	
	
	
}

