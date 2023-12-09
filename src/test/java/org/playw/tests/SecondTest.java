package org.playw.tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class SecondTest {
    @Inject
    private Playwright playwright;

    @Inject
    private Browser browser;

    @Inject
    private BrowserContext context;

    @Inject
    private Page page;

    @Test
    void shouldReturnInnerHTML() {
        page.setContent("<div>hello</div>");
        assertEquals("hello", page.innerHTML("css=div"));
    }

    @Test
    void shouldClickButton() {
        Page popup = page.waitForPopup(() -> page.evaluate("window.open('about:blank');"));
        assertEquals("about:blank", popup.url());
    }
}
