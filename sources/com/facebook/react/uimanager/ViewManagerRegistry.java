package com.facebook.react.uimanager;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.MapBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ViewManagerRegistry implements ComponentCallbacks2 {
    private final ViewManagerResolver mViewManagerResolver;
    /* access modifiers changed from: private */
    public final Map<String, ViewManager> mViewManagers;

    public void onConfigurationChanged(Configuration configuration) {
    }

    public ViewManagerRegistry(ViewManagerResolver viewManagerResolver) {
        this.mViewManagers = MapBuilder.newHashMap();
        this.mViewManagerResolver = viewManagerResolver;
    }

    public ViewManagerRegistry(List<ViewManager> list) {
        HashMap newHashMap = MapBuilder.newHashMap();
        for (ViewManager next : list) {
            newHashMap.put(next.getName(), next);
        }
        this.mViewManagers = newHashMap;
        this.mViewManagerResolver = null;
    }

    public ViewManagerRegistry(Map<String, ViewManager> map) {
        this.mViewManagers = map == null ? MapBuilder.newHashMap() : map;
        this.mViewManagerResolver = null;
    }

    public ViewManager get(String str) {
        ViewManager viewManager = this.mViewManagers.get(str);
        if (viewManager != null) {
            return viewManager;
        }
        if (this.mViewManagerResolver != null) {
            ViewManager viewManagerFromResolver = getViewManagerFromResolver(str);
            if (viewManagerFromResolver != null) {
                return viewManagerFromResolver;
            }
            throw new IllegalViewOperationException("ViewManagerResolver returned null for " + str + ", existing names are: " + this.mViewManagerResolver.getViewManagerNames());
        }
        throw new IllegalViewOperationException("No ViewManager found for class " + str);
    }

    private ViewManager getViewManagerFromResolver(String str) {
        ViewManager viewManager = this.mViewManagerResolver.getViewManager(str);
        if (viewManager != null) {
            this.mViewManagers.put(str, viewManager);
        }
        return viewManager;
    }

    /* access modifiers changed from: package-private */
    public ViewManager getViewManagerIfExists(String str) {
        ViewManager viewManager = this.mViewManagers.get(str);
        if (viewManager != null) {
            return viewManager;
        }
        if (this.mViewManagerResolver != null) {
            return getViewManagerFromResolver(str);
        }
        return null;
    }

    public void onSurfaceStopped(final int i) {
        AnonymousClass1 r0 = new Runnable() {
            public void run() {
                for (Map.Entry value : ViewManagerRegistry.this.mViewManagers.entrySet()) {
                    ((ViewManager) value.getValue()).onSurfaceStopped(i);
                }
            }
        };
        if (UiThreadUtil.isOnUiThread()) {
            r0.run();
        } else {
            UiThreadUtil.runOnUiThread(r0);
        }
    }

    public void onTrimMemory(int i) {
        AnonymousClass2 r2 = new Runnable() {
            public void run() {
                for (Map.Entry value : ViewManagerRegistry.this.mViewManagers.entrySet()) {
                    ((ViewManager) value.getValue()).trimMemory();
                }
            }
        };
        if (UiThreadUtil.isOnUiThread()) {
            r2.run();
        } else {
            UiThreadUtil.runOnUiThread(r2);
        }
    }

    public void onLowMemory() {
        onTrimMemory(0);
    }
}
