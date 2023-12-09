package org.play.config.factory;

import com.github.javafaker.Faker;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import org.aeonbits.owner.ConfigFactory;
import org.play.config.properties.ConfigurationProp;

@Factory
public class BeansFactory {
    private final ConfigurationProp configurationProp = ConfigFactory.create(ConfigurationProp.class);

    @Bean
    public Faker faker() {
        return new Faker();
    }

    @Bean
    public ConfigurationProp configurationProp() {
        return configurationProp;
    }
}
