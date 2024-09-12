package io.sentry;

import java.util.Map;

public interface JsonUnknown {
    Map<String, Object> getUnknown();

    void setUnknown(Map<String, Object> map);
}
