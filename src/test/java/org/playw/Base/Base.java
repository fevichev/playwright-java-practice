package org.playw.Base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import jakarta.inject.Inject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.play.config.properties.ConfigurationProp;

import java.awt.*;

import static org.play.config.properties.ConfigurationManager.getConfiguration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Base {
    @Inject
    Playwright playwright;

    @Inject
    Browser browser;

    @Inject
    BrowserContext context;

    @Inject
    Page page;

    @Inject
    ConfigurationProp cfg;

    @BeforeAll
    public void launchBrowser() {
//        browser = playwright.chromium().launch(new
//                BrowserType.LaunchOptions().setHeadless(getConfiguration().browserHeadless()));
//        browser = playwright.chromium().launch();
    }

    @BeforeEach
    public void createContextAndPage() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1600, 1400));
//        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
        context.setDefaultTimeout(10000.0);
        if (cfg.tracingOptions()) {
            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));
        }
        Page page = context.newPage();
    }

    @AfterEach
    public void closeContext() {
    }

    @AfterAll
    public void closeBrowser() {
    }
}
