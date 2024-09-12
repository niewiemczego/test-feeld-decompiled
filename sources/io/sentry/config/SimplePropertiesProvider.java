package io.sentry.config;

import java.util.Properties;

final class SimplePropertiesProvider extends AbstractPropertiesProvider {
    public SimplePropertiesProvider(Properties properties) {
        super(properties);
    }
}
