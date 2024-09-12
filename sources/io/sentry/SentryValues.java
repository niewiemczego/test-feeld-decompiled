package io.sentry;

import java.util.ArrayList;
import java.util.List;

final class SentryValues<T> {
    private final List<T> values;

    public static final class JsonKeys {
        public static final String VALUES = "values";
    }

    SentryValues(List<T> list) {
        this.values = new ArrayList(list == null ? new ArrayList<>(0) : list);
    }

    public List<T> getValues() {
        return this.values;
    }
}
