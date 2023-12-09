package org.playw.pageobject;

//import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;


@Singleton
public class WikiPage {
    @Inject
    public Page page;

    public void xxx() {
        page.locator("input[name=\"search\"]").click();
        page.locator("input[name=\"search\"]").fill("playwright");
        page.locator("input[name=\"search\"]").press("Enter");
    }
}
