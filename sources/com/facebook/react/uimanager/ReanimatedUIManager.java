package com.facebook.react.uimanager;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import java.util.List;

@ReactModule(name = "UIManager")
public class ReanimatedUIManager extends UIManagerModule {
    public boolean canOverrideExistingModule() {
        return true;
    }

    public ReanimatedUIManager(ReactApplicationContext reactApplicationContext, List<ViewManager> list, int i) {
        super(reactApplicationContext, list, i);
    }

    public void onBatchComplete() {
        super.onBatchComplete();
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getConstantsForViewManager(String str) {
        return super.getConstantsForViewManager(str);
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getDefaultEventTypes() {
        return super.getDefaultEventTypes();
    }

    @ReactMethod
    public void removeRootView(int i) {
        super.removeRootView(i);
    }

    @ReactMethod
    public void createView(int i, String str, int i2, ReadableMap readableMap) {
        super.createView(i, str, i2, readableMap);
    }

    @ReactMethod
    public void updateView(int i, String str, ReadableMap readableMap) {
        super.updateView(i, str, readableMap);
    }

    @ReactMethod
    public void manageChildren(int i, ReadableArray readableArray, ReadableArray readableArray2, ReadableArray readableArray3, ReadableArray readableArray4, ReadableArray readableArray5) {
        super.manageChildren(i, readableArray, readableArray2, readableArray3, readableArray4, readableArray5);
    }

    @ReactMethod
    public void setChildren(int i, ReadableArray readableArray) {
        super.setChildren(i, readableArray);
    }

    @Deprecated
    @ReactMethod
    public void replaceExistingNonRootView(int i, int i2) {
        super.replaceExistingNonRootView(i, i2);
    }

    @Deprecated
    @ReactMethod
    public void removeSubviewsFromContainerWithID(int i) {
        super.removeSubviewsFromContainerWithID(i);
    }

    @ReactMethod
    public void measure(int i, Callback callback) {
        super.measure(i, callback);
    }

    @ReactMethod
    public void measureInWindow(int i, Callback callback) {
        super.measureInWindow(i, callback);
    }

    @ReactMethod
    public void measureLayout(int i, int i2, Callback callback, Callback callback2) {
        super.measureLayout(i, i2, callback, callback2);
    }

    @Deprecated
    @ReactMethod
    public void measureLayoutRelativeToParent(int i, Callback callback, Callback callback2) {
        super.measureLayoutRelativeToParent(i, callback, callback2);
    }

    @ReactMethod
    public void findSubviewIn(int i, ReadableArray readableArray, Callback callback) {
        super.findSubviewIn(i, readableArray, callback);
    }

    @Deprecated
    @ReactMethod
    public void viewIsDescendantOf(int i, int i2, Callback callback) {
        super.viewIsDescendantOf(i, i2, callback);
    }

    @ReactMethod
    public void setJSResponder(int i, boolean z) {
        super.setJSResponder(i, z);
    }

    @ReactMethod
    public void clearJSResponder() {
        super.clearJSResponder();
    }

    @ReactMethod
    public void dispatchViewManagerCommand(int i, Dynamic dynamic, ReadableArray readableArray) {
        super.dispatchViewManagerCommand(i, dynamic, readableArray);
    }

    @ReactMethod
    public void showPopupMenu(int i, ReadableArray readableArray, Callback callback, Callback callback2) {
        super.showPopupMenu(i, readableArray, callback, callback2);
    }

    @ReactMethod
    public void dismissPopupMenu() {
        super.dismissPopupMenu();
    }

    @ReactMethod
    public void setLayoutAnimationEnabledExperimental(boolean z) {
        super.setLayoutAnimationEnabledExperimental(z);
    }

    @ReactMethod
    public void configureNextLayoutAnimation(ReadableMap readableMap, Callback callback, Callback callback2) {
        super.configureNextLayoutAnimation(readableMap, callback, callback2);
    }

    @ReactMethod
    public void sendAccessibilityEvent(int i, int i2) {
        super.sendAccessibilityEvent(i, i2);
    }
}
