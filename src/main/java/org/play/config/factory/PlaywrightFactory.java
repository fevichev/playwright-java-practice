package org.play.config.factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;

@Factory
public class PlaywrightFactory {

    @Bean(preDestroy = "close")
    public Playwright playwright() {
        return Playwright.create();
    }

    @Bean(preDestroy = "close")
    public Browser browser(Playwright playwright) {
        return playwright.chromium().launch();
    }

    @Bean
    public BrowserContext browserContext(Browser browser) {
        return browser.newContext();
    }

    @Bean
    public Page page(BrowserContext context) {
        return context.newPage();
    }
}