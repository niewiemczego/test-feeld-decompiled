package com.launchdarkly.sdk.android;

import java.io.Closeable;
import java.io.File;

interface PlatformState extends Closeable {

    public interface ConnectivityChangeListener {
        void onConnectivityChanged(boolean z);
    }

    public interface ForegroundChangeListener {
        void onForegroundChanged(boolean z);
    }

    void addConnectivityChangeListener(ConnectivityChangeListener connectivityChangeListener);

    void addForegroundChangeListener(ForegroundChangeListener foregroundChangeListener);

    File getCacheDir();

    boolean isForeground();

    boolean isNetworkAvailable();

    void removeConnectivityChangeListener(ConnectivityChangeListener connectivityChangeListener);

    void removeForegroundChangeListener(ForegroundChangeListener foregroundChangeListener);
}
