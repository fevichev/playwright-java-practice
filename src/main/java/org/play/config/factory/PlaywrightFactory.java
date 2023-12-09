package org.play.config.factory;

import com.microsoft.playwright.*;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Prototype;
import jakarta.inject.Scope;
import jakarta.inject.Singleton;

@Factory
public class PlaywrightFactory {

    @Bean
    public Playwright playwright() {
        return Playwright.create();
    }

    @Bean
//    @Singleton
    public Browser browser(Playwright playwright) {
        return playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @Bean
    public BrowserContext context(Browser browser) {
        return browser.newContext();
    }

    @Bean
    public Page page(BrowserContext context) {
        return context.newPage();
    }
}