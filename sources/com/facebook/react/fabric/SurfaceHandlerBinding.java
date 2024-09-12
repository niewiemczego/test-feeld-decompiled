package com.facebook.react.fabric;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.fabric.mounting.LayoutMetricsConversions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class SurfaceHandlerBinding implements SurfaceHandler {
    public static final int DISPLAY_MODE_HIDDEN = 2;
    public static final int DISPLAY_MODE_SUSPENDED = 1;
    public static final int DISPLAY_MODE_VISIBLE = 0;
    private static final int NO_SURFACE_ID = 0;
    private final HybridData mHybridData;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DisplayModeTypeDef {
    }

    private native String getModuleNameNative();

    private native int getSurfaceIdNative();

    private static native HybridData initHybrid(int i, String str);

    private native boolean isRunningNative();

    private native void setDisplayModeNative(int i);

    private native void setLayoutConstraintsNative(float f, float f2, float f3, float f4, float f5, float f6, boolean z, boolean z2, float f7);

    private native void setPropsNative(NativeMap nativeMap);

    private native void setSurfaceIdNative(int i);

    private native void startNative();

    private native void stopNative();

    static {
        FabricSoLoader.staticInit();
    }

    public SurfaceHandlerBinding(String str) {
        this.mHybridData = initHybrid(0, str);
    }

    public int getSurfaceId() {
        return getSurfaceIdNative();
    }

    public void setSurfaceId(int i) {
        setSurfaceIdNative(i);
    }

    public String getModuleName() {
        return getModuleNameNative();
    }

    public void start() {
        startNative();
    }

    public void stop() {
        stopNative();
    }

    public boolean isRunning() {
        return isRunningNative();
    }

    public void setLayoutConstraints(int i, int i2, int i3, int i4, boolean z, boolean z2, float f) {
        setLayoutConstraintsNative(LayoutMetricsConversions.getMinSize(i) / f, LayoutMetricsConversions.getMaxSize(i) / f, LayoutMetricsConversions.getMinSize(i2) / f, LayoutMetricsConversions.getMaxSize(i2) / f, ((float) i3) / f, ((float) i4) / f, z, z2, f);
    }

    public void setProps(NativeMap nativeMap) {
        setPropsNative(nativeMap);
    }

    public void setMountable(boolean z) {
        setDisplayModeNative(z ^ true ? 1 : 0);
    }
}
