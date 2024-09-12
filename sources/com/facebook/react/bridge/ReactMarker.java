package com.facebook.react.bridge;

import android.os.SystemClock;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ReactMarker {
    private static final List<FabricMarkerListener> sFabricMarkerListeners = new CopyOnWriteArrayList();
    private static final List<MarkerListener> sListeners = new CopyOnWriteArrayList();

    public interface FabricMarkerListener {
        void logFabricMarker(ReactMarkerConstants reactMarkerConstants, String str, int i, long j);
    }

    public interface MarkerListener {
        void logMarker(ReactMarkerConstants reactMarkerConstants, String str, int i);
    }

    public static void addListener(MarkerListener markerListener) {
        List<MarkerListener> list = sListeners;
        if (!list.contains(markerListener)) {
            list.add(markerListener);
        }
    }

    public static void removeListener(MarkerListener markerListener) {
        sListeners.remove(markerListener);
    }

    public static void clearMarkerListeners() {
        sListeners.clear();
    }

    public static void addFabricListener(FabricMarkerListener fabricMarkerListener) {
        List<FabricMarkerListener> list = sFabricMarkerListeners;
        if (!list.contains(fabricMarkerListener)) {
            list.add(fabricMarkerListener);
        }
    }

    public static void removeFabricListener(FabricMarkerListener fabricMarkerListener) {
        sFabricMarkerListeners.remove(fabricMarkerListener);
    }

    public static void clearFabricMarkerListeners() {
        sFabricMarkerListeners.clear();
    }

    public static void logFabricMarker(ReactMarkerConstants reactMarkerConstants, String str, int i, long j) {
        for (FabricMarkerListener logFabricMarker : sFabricMarkerListeners) {
            logFabricMarker.logFabricMarker(reactMarkerConstants, str, i, j);
        }
    }

    public static void logFabricMarker(ReactMarkerConstants reactMarkerConstants, String str, int i) {
        logFabricMarker(reactMarkerConstants, str, i, SystemClock.uptimeMillis());
    }

    public static void logMarker(String str) {
        logMarker(str, (String) null);
    }

    public static void logMarker(String str, int i) {
        logMarker(str, (String) null, i);
    }

    public static void logMarker(String str, String str2) {
        logMarker(str, str2, 0);
    }

    public static void logMarker(String str, String str2, int i) {
        logMarker(ReactMarkerConstants.valueOf(str), str2, i);
    }

    public static void logMarker(ReactMarkerConstants reactMarkerConstants) {
        logMarker(reactMarkerConstants, (String) null, 0);
    }

    public static void logMarker(ReactMarkerConstants reactMarkerConstants, int i) {
        logMarker(reactMarkerConstants, (String) null, i);
    }

    public static void logMarker(ReactMarkerConstants reactMarkerConstants, String str) {
        logMarker(reactMarkerConstants, str, 0);
    }

    public static void logMarker(ReactMarkerConstants reactMarkerConstants, String str, int i) {
        logFabricMarker(reactMarkerConstants, str, i);
        for (MarkerListener logMarker : sListeners) {
            logMarker.logMarker(reactMarkerConstants, str, i);
        }
    }
}
