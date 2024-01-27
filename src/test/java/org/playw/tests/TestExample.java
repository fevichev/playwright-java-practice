package org.playw.tests;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.play.config.properties.ConfigurationProp;
import org.playw.Base.Base;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class TestExample extends Base {
    @Inject
    Page page;
    @Inject
    ConfigurationProp cfg;

    @Test
    @Order(1)
    @DisplayName("Should check button test")
    void shouldClickButton() {
        page.navigate("data:text/html,<script>var result;</script><button onclick='result=\"Clicked\"'>Go</button>");
        page.locator("button").click();
        assertEquals("Clicked", page.evaluate("result"));
    }

    @Test
    @Order(2)
    @DisplayName("Should check the box test")
    void shouldCheckTheBox() {
        page.setContent("<input id='checkbox' type='checkbox'></input>");
        page.locator("input").check();
        assertTrue((Boolean) page.evaluate("() => window['checkbox'].checked"));
    }

    @Test
    @Order(3)
    @DisplayName("Search wiki test")
    void shouldSearchWiki() {
        page.navigate(cfg.baseWikiUrl());
        page.locator("input[name=\"search\"]").click();
//        page.click();
        page.locator("input[name=\"search\"]").fill("playwright");
        page.pause();
        page.locator("input[name=\"search\"]").press("Enter");
        assertEquals("https://en.wikipedia.org/wiki/Playwright", page.url());
    }

    @Test
    @Order(4)
    @DisplayName("DemoBlaze test")
    void demoBlazeTest() {
        page.navigate("https://www.demoblaze.com");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Nexus 6")).click();
        page.onceDialog(dialog -> {
            System.out.println(String.format("Dialog message: %s", dialog.message()));
            dialog.accept();
        });
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add to cart")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Home (current)")).click();
        page.locator("#next2").click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("MacBook Pro")).click();
        page.onceDialog(dialog -> {
            System.out.println(String.format("Dialog message: %s", dialog.message()));
            dialog.accept();
        });
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add to cart")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Cart").setExact(true)).click();
        page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("Nexus 6")).click();
        page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("MacBook Pro")).click();
        page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("1750")).click();
    }
}
