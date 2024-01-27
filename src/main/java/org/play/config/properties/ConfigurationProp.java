package org.play.config.properties;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "classpath:config.properties",
        "classpath:ServerConfig.properties"
})
public interface ConfigurationProp extends Config {
    @DefaultValue("https://www.google.com.ua/")
    @Key("base.wiki.url")
    String baseWikiUrl();

    @Key("browser.headless")
    Boolean browserHeadless();

    @DefaultValue("false")
    @Key("tracing.options")
    Boolean tracingOptions();
}
