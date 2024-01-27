package org.play.browserconfiguration;

import com.microsoft.playwright.*;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.play.config.properties.ConfigurationProp;

import java.awt.*;
import java.nio.file.Paths;

import static org.play.config.properties.ConfigurationManager.getConfiguration;

@Singleton
public class BrowserConfig {
    @Inject
    ConfigurationProp cfg;

//    @Inject
//    Page page;

    public static Playwright playwright;
    public static Browser browser;
    public BrowserContext context;
    //    protected static ConfigurationProp configuration;
//    @Inject Page page;
//    public ConfigurationProp cfg = ConfigFactory.create(ConfigurationProp.class);

    public static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new
                BrowserType.LaunchOptions().setHeadless(getConfiguration().browserHeadless()));
//        browser = playwright.chromium().launch();
    }

    public static void closeBrowser() {
        playwright.close();
    }

    public void createContextAndPage() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1600, 1400));
//        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
        context.setDefaultTimeout(10000.0);
        if (cfg.tracingOptions().equals(true)) {
            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));
        }
        Page page = context.newPage();
    }

    public void closeContext() {
        if (cfg.tracingOptions().equals(true)) {
            context.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("trace.zip")));
        }
        context.close();
    }
}
