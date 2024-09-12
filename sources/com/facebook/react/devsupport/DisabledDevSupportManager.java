package com.facebook.react.devsupport;

import android.app.Activity;
import android.util.Pair;
import android.view.View;
import com.facebook.react.bridge.DefaultJSExceptionHandler;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.SurfaceDelegate;
import com.facebook.react.devsupport.interfaces.BundleLoadCallback;
import com.facebook.react.devsupport.interfaces.DevOptionHandler;
import com.facebook.react.devsupport.interfaces.DevSplitBundleCallback;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.ErrorCustomizer;
import com.facebook.react.devsupport.interfaces.ErrorType;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.devsupport.interfaces.RedBoxHandler;
import com.facebook.react.devsupport.interfaces.StackFrame;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import java.io.File;

public class DisabledDevSupportManager implements DevSupportManager {
    private final DefaultJSExceptionHandler mDefaultJSExceptionHandler = new DefaultJSExceptionHandler();

    public void addCustomDevOption(String str, DevOptionHandler devOptionHandler) {
    }

    public View createRootView(String str) {
        return null;
    }

    public SurfaceDelegate createSurfaceDelegate(String str) {
        return null;
    }

    public void destroyRootView(View view) {
    }

    public File downloadBundleResourceFromUrlSync(String str, File file) {
        return null;
    }

    public Activity getCurrentActivity() {
        return null;
    }

    public DeveloperSettings getDevSettings() {
        return null;
    }

    public boolean getDevSupportEnabled() {
        return false;
    }

    public String getDownloadedJSBundleFile() {
        return null;
    }

    public String getJSBundleURLForRemoteDebugging() {
        return null;
    }

    public int getLastErrorCookie() {
        return 0;
    }

    public StackFrame[] getLastErrorStack() {
        return null;
    }

    public String getLastErrorTitle() {
        return null;
    }

    public ErrorType getLastErrorType() {
        return null;
    }

    public RedBoxHandler getRedBoxHandler() {
        return null;
    }

    public String getSourceMapUrl() {
        return null;
    }

    public String getSourceUrl() {
        return null;
    }

    public void handleReloadJS() {
    }

    public boolean hasUpToDateJSBundleInCache() {
        return false;
    }

    public void hideRedboxDialog() {
    }

    public void loadSplitBundleFromServer(String str, DevSplitBundleCallback devSplitBundleCallback) {
    }

    public void onNewReactContextCreated(ReactContext reactContext) {
    }

    public void onReactInstanceDestroyed(ReactContext reactContext) {
    }

    public Pair<String, StackFrame[]> processErrorCustomizers(Pair<String, StackFrame[]> pair) {
        return pair;
    }

    public void registerErrorCustomizer(ErrorCustomizer errorCustomizer) {
    }

    public void reloadJSFromServer(String str) {
    }

    public void reloadJSFromServer(String str, BundleLoadCallback bundleLoadCallback) {
    }

    public void reloadSettings() {
    }

    public void setDevSupportEnabled(boolean z) {
    }

    public void setFpsDebugEnabled(boolean z) {
    }

    public void setHotModuleReplacementEnabled(boolean z) {
    }

    public void setPackagerLocationCustomizer(DevSupportManager.PackagerLocationCustomizer packagerLocationCustomizer) {
    }

    public void setRemoteJSDebugEnabled(boolean z) {
    }

    public void showDevOptionsDialog() {
    }

    public void showNewJSError(String str, ReadableArray readableArray, int i) {
    }

    public void showNewJavaError(String str, Throwable th) {
    }

    public void startInspector() {
    }

    public void stopInspector() {
    }

    public void toggleElementInspector() {
    }

    public void updateJSError(String str, ReadableArray readableArray, int i) {
    }

    public void isPackagerRunning(PackagerStatusCallback packagerStatusCallback) {
        packagerStatusCallback.onPackagerStatusFetched(false);
    }

    public void handleException(Exception exc) {
        this.mDefaultJSExceptionHandler.handleException(exc);
    }
}
