package org.playw.tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.playw.pageobject.WikiPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class TestExample {

    @Inject
    WikiPage wiki;

    @Inject
    Playwright playwright;

    @Inject
    Browser browser;

    @Inject
    BrowserContext context;

    @Inject
    Page page;

    @Test
    void shouldClickButton() {
        page.navigate("data:text/html,<script>var result;</script><button onclick='result=\"Clicked\"'>Go</button>");
        page.locator("button").click();
        assertEquals("Clicked", page.evaluate("result"));
    }

    @Test
    void shouldCheckTheBox() {
        page.setContent("<input id='checkbox' type='checkbox'></input>");
        page.locator("input").check();
        assertTrue((Boolean) page.evaluate("() => window['checkbox'].checked"));
    }

    @Test
    void shouldSearchWiki() {
        page.navigate("https://www.wikipedia.org/");
        wiki.xxx();
        assertEquals("https://en.wikipedia.org/wiki/Playwright", page.url());
    }

    @Test
    void myTest() {
        page.navigate("https://www.google.com/search?q=google&oq=google&gs_lcrp=EgZjaHJvbWUyBggAEEUYOdIBCDI0MTVqMGo0qAIAsAIA&sourceid=chrome&ie=UTF-8");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Accept all")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Google Google https://www.")).click();
        page.getByLabel("Search", new Page.GetByLabelOptions().setExact(true)).click();
        page.getByLabel("Search", new Page.GetByLabelOptions().setExact(true)).fill("ebay");
        page.getByLabel("Search", new Page.GetByLabelOptions().setExact(true)).press("Enter");
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Google").setExact(true))).isVisible();
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("eBay: Electronics, Cars,"))).isVisible();
        assertThat(page.locator("#APjFqb")).containsText("ebay");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("eBay: Electronics, Cars,")).click();
        assertThat(page.locator("#gh-la")).isVisible();
        page.getByPlaceholder("Keressen rá bármire").click();
        page.getByPlaceholder("Keressen rá bármire").fill("iphone 15 pro");
        page.getByPlaceholder("Keressen rá bármire").press("Enter");
    }
}
