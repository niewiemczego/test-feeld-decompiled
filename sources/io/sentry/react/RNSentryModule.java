package io.sentry.react;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;

public class RNSentryModule extends ReactContextBaseJavaModule {
    private final RNSentryModuleImpl impl;

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap fetchNativeStackFramesBy(ReadableArray readableArray) {
        return null;
    }

    public String getName() {
        return RNSentryModuleImpl.NAME;
    }

    RNSentryModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.impl = new RNSentryModuleImpl(reactApplicationContext);
    }

    @ReactMethod
    public void addListener(String str) {
        this.impl.addListener(str);
    }

    @ReactMethod
    public void removeListeners(double d) {
        this.impl.removeListeners(d);
    }

    @ReactMethod
    public void initNativeReactNavigationNewFrameTracking(Promise promise) {
        this.impl.initNativeReactNavigationNewFrameTracking(promise);
    }

    @ReactMethod
    public void initNativeSdk(ReadableMap readableMap, Promise promise) {
        this.impl.initNativeSdk(readableMap, promise);
    }

    @ReactMethod
    public void crash() {
        this.impl.crash();
    }

    @ReactMethod
    public void fetchModules(Promise promise) {
        this.impl.fetchModules(promise);
    }

    @ReactMethod
    public void fetchNativeRelease(Promise promise) {
        this.impl.fetchNativeRelease(promise);
    }

    @ReactMethod
    public void fetchNativeAppStart(Promise promise) {
        this.impl.fetchNativeAppStart(promise);
    }

    @ReactMethod
    public void fetchNativeFrames(Promise promise) {
        this.impl.fetchNativeFrames(promise);
    }

    @ReactMethod
    public void captureEnvelope(String str, ReadableMap readableMap, Promise promise) {
        this.impl.captureEnvelope(str, readableMap, promise);
    }

    @ReactMethod
    public void captureScreenshot(Promise promise) {
        this.impl.captureScreenshot(promise);
    }

    @ReactMethod
    public void fetchViewHierarchy(Promise promise) {
        this.impl.fetchViewHierarchy(promise);
    }

    @ReactMethod
    public void setUser(ReadableMap readableMap, ReadableMap readableMap2) {
        this.impl.setUser(readableMap, readableMap2);
    }

    @ReactMethod
    public void addBreadcrumb(ReadableMap readableMap) {
        this.impl.addBreadcrumb(readableMap);
    }

    @ReactMethod
    public void clearBreadcrumbs() {
        this.impl.clearBreadcrumbs();
    }

    @ReactMethod
    public void setExtra(String str, String str2) {
        this.impl.setExtra(str, str2);
    }

    @ReactMethod
    public void setContext(String str, ReadableMap readableMap) {
        this.impl.setContext(str, readableMap);
    }

    @ReactMethod
    public void setTag(String str, String str2) {
        this.impl.setTag(str, str2);
    }

    @ReactMethod
    public void closeNativeSdk(Promise promise) {
        this.impl.closeNativeSdk(promise);
    }

    @ReactMethod
    public void enableNativeFramesTracking() {
        this.impl.enableNativeFramesTracking();
    }

    @ReactMethod
    public void disableNativeFramesTracking() {
        this.impl.disableNativeFramesTracking();
    }

    @ReactMethod
    public void fetchNativeDeviceContexts(Promise promise) {
        this.impl.fetchNativeDeviceContexts(promise);
    }

    @ReactMethod
    public void fetchNativeSdkInfo(Promise promise) {
        this.impl.fetchNativeSdkInfo(promise);
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap startProfiling() {
        return this.impl.startProfiling();
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap stopProfiling() {
        return this.impl.stopProfiling();
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public String fetchNativePackageName() {
        return this.impl.fetchNativePackageName();
    }
}
