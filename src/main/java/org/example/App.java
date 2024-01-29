package org.example;

import com.microsoft.playwright.*;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class App {
    public static void main(String[] args) {
//        try (Playwright playwright = Playwright.create()) {
//            Browser browser = playwright.chromium().launch();
//            Page page = browser.newPage();
//            page.navigate("http://playwright.dev");
//            System.out.println(page.title());
//        }
//        try (Playwright playwright = Playwright.create()) {
////            Browser browser = playwright.webkit().launch();
//            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
//            Page page = browser.newPage();
//            page.navigate("https://playwright.dev/");
//            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example1.png")));
//            
//            
//        }
    	try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
//            Page page = browser.newPage();
//            Browser browser = playwright.chromium().launch();


            page.navigate("https://nejm.org");
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));

            // Expect a title "to contain" a substring.
            assertThat(page).hasTitle(Pattern.compile("The New England Journal of Medicine"));

            // create a locator
 //         Locator getStarted = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Get Started"));
//            Locator getSignIn = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign In"));

            // Expect an attribute "to be strictly equal" to the value.
//            assertThat(getSignIn).hasAttribute("href", "/sign-in?articleView=free&amp;uri=%2F");

            // Click the get started link.
//            getSignIn.click();

            // Expects page to have a heading with the name of Installation.
            assertThat(page.getByRole(AriaRole.HEADING,
               new Page.GetByRoleOptions().setName("Sign In"))).isVisible();
        }
    }
}