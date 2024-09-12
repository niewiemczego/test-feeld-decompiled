package io.sentry;

import java.util.Locale;

public enum MonitorScheduleType {
    CRONTAB,
    INTERVAL;

    public String apiName() {
        return name().toLowerCase(Locale.ROOT);
    }
}
