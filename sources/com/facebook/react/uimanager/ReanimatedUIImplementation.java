package com.facebook.react.uimanager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.swmansion.reanimated.layoutReanimation.ReanimatedNativeHierarchyManager;
import java.util.List;

public class ReanimatedUIImplementation extends UIImplementation {
    public ReanimatedUIImplementation(ReactApplicationContext reactApplicationContext, ViewManagerResolver viewManagerResolver, EventDispatcher eventDispatcher, int i) {
        this(reactApplicationContext, new ViewManagerRegistry(viewManagerResolver), eventDispatcher, i);
    }

    public ReanimatedUIImplementation(ReactApplicationContext reactApplicationContext, List<ViewManager> list, EventDispatcher eventDispatcher, int i) {
        this(reactApplicationContext, new ViewManagerRegistry(list), eventDispatcher, i);
    }

    public ReanimatedUIImplementation(ReactApplicationContext reactApplicationContext, ViewManagerRegistry viewManagerRegistry, EventDispatcher eventDispatcher, int i) {
        super(reactApplicationContext, viewManagerRegistry, new UIViewOperationQueue(reactApplicationContext, new ReanimatedNativeHierarchyManager(viewManagerRegistry, reactApplicationContext), i), eventDispatcher);
    }

    public void manageChildren(int i, ReadableArray readableArray, ReadableArray readableArray2, ReadableArray readableArray3, ReadableArray readableArray4, ReadableArray readableArray5) {
        super.manageChildren(i, readableArray, readableArray2, readableArray3, readableArray4, readableArray5);
    }
}
