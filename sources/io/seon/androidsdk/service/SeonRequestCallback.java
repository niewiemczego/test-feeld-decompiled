package io.seon.androidsdk.service;

import java.util.List;
import java.util.Map;

public interface SeonRequestCallback {
    void onComplete(int i, String str, Map<String, List<String>> map);

    void onFailure(int i, String str, Map<String, List<String>> map);
}
