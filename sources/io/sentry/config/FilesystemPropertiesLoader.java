package io.sentry.config;

import io.sentry.ILogger;
import io.sentry.SentryLevel;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

final class FilesystemPropertiesLoader implements PropertiesLoader {
    private final String filePath;
    private final ILogger logger;

    public FilesystemPropertiesLoader(String str, ILogger iLogger) {
        this.filePath = str;
        this.logger = iLogger;
    }

    public Properties load() {
        BufferedInputStream bufferedInputStream;
        try {
            File file = new File(this.filePath);
            if (!file.isFile() || !file.canRead()) {
                return null;
            }
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            Properties properties = new Properties();
            properties.load(bufferedInputStream);
            bufferedInputStream.close();
            return properties;
        } catch (IOException e) {
            this.logger.log(SentryLevel.ERROR, e, "Failed to load Sentry configuration from file: %s", this.filePath);
            return null;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }
}
