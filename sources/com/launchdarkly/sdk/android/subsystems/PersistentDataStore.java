package com.launchdarkly.sdk.android.subsystems;

import java.util.Collection;
import java.util.Map;

public interface PersistentDataStore {
    void clear(String str, boolean z);

    Collection<String> getAllNamespaces();

    Collection<String> getKeys(String str);

    String getValue(String str, String str2);

    void setValue(String str, String str2, String str3);

    void setValues(String str, Map<String, String> map);
}
