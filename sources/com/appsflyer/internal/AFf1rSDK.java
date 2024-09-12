package com.appsflyer.internal;

import com.appsflyer.internal.platform_extension.PluginInfo;
import java.util.Map;

public interface AFf1rSDK {
    Map<String, Object> AFInAppEventType();

    void AFKeystoreWrapper(PluginInfo pluginInfo);
}
