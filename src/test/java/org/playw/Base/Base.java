package org.playw.Base;

import jakarta.inject.Inject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.play.browserconfiguration.BrowserConfig;

public class Base {
    @Inject
    BrowserConfig browserConfig;

    @BeforeAll
    public static void launchBrowser() {
        BrowserConfig.launchBrowser();
    }

    @BeforeEach
    public void createContextAndPage() {
        browserConfig.createContextAndPage();
    }

    @AfterEach
    public void closeContext() {
        browserConfig.closeContext();
    }

    @AfterAll
    public static void closeBrowser() {
        BrowserConfig.closeBrowser();
    }
}
