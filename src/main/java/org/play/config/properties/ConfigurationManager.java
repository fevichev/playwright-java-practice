package org.play.config.properties;

import org.aeonbits.owner.ConfigCache;

public final class ConfigurationManager {
    private ConfigurationManager() {
    }

    public static ConfigurationProp getConfiguration() {
        return ConfigCache.getOrCreate(ConfigurationProp.class);
    }
}
