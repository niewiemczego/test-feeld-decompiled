package io.sentry;

import java.util.Locale;

public enum CheckInStatus {
    IN_PROGRESS,
    OK,
    ERROR;

    public String apiName() {
        return name().toLowerCase(Locale.ROOT);
    }
}
