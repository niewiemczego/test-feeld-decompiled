package com.facebook.react.modules.debug.interfaces;

public interface DeveloperSettings {
    void addMenuItem(String str);

    boolean isAnimationFpsDebugEnabled();

    boolean isDeviceDebugEnabled();

    boolean isElementInspectorEnabled();

    boolean isFpsDebugEnabled();

    boolean isJSDevModeEnabled();

    boolean isJSMinifyEnabled();

    boolean isRemoteJSDebugEnabled();

    boolean isStartSamplingProfilerOnInit();

    void setRemoteJSDebugEnabled(boolean z);
}
