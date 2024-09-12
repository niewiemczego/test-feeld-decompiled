package com.mvcpscrollviewmanager;

import android.view.View;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIImplementation;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.UIManagerModuleListener;
import com.facebook.react.views.scroll.ReactScrollView;
import com.facebook.react.views.view.ReactViewGroup;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MvcpScrollViewManagerModule extends ReactContextBaseJavaModule {
    /* access modifiers changed from: private */
    public HashMap<Integer, ScrollViewUIHolder> scrollViewUIHolders;
    /* access modifiers changed from: private */
    public HashMap<Integer, UIManagerModuleListener> uiManagerModuleListeners;

    public String getName() {
        return "MvcpScrollViewManager";
    }

    MvcpScrollViewManagerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public void initialize() {
        super.initialize();
        this.uiManagerModuleListeners = new HashMap<>();
        this.scrollViewUIHolders = new HashMap<>();
    }

    /* access modifiers changed from: private */
    public ScrollViewUIHolder getScrollViewUiHolderByViewTag(int i) {
        ScrollViewUIHolder scrollViewUIHolder = this.scrollViewUIHolders.get(Integer.valueOf(i));
        if (scrollViewUIHolder != null) {
            return scrollViewUIHolder;
        }
        ScrollViewUIHolder scrollViewUIHolder2 = new ScrollViewUIHolder();
        this.scrollViewUIHolders.put(Integer.valueOf(i), scrollViewUIHolder2);
        return scrollViewUIHolder2;
    }

    /* access modifiers changed from: private */
    public void removeScrollViewUiHolderByRNHandle(int i) {
        Iterator<ScrollViewUIHolder> it = this.scrollViewUIHolders.values().iterator();
        while (it.hasNext()) {
            if (it.next().getRnHandle() == i) {
                it.remove();
                return;
            }
        }
    }

    @ReactMethod
    public void enableMaintainVisibleContentPosition(int i, int i2, int i3, Promise promise) {
        final int i4 = i;
        final int i5 = i3;
        final int i6 = i2;
        final Promise promise2 = promise;
        getReactApplicationContext().runOnUiQueueThread(new Runnable() {
            public void run() {
                final UIManagerModule uIManagerModule = (UIManagerModule) MvcpScrollViewManagerModule.this.getReactApplicationContext().getNativeModule(UIManagerModule.class);
                if (uIManagerModule != null) {
                    final ScrollViewUIHolder access$100 = MvcpScrollViewManagerModule.this.getScrollViewUiHolderByViewTag(i4);
                    try {
                        AnonymousClass1 r2 = new UIManagerModuleListener() {
                            public void willDispatchViewUpdates(final UIManagerModule uIManagerModule) {
                                uIManagerModule.prependUIBlock(new UIBlock() {
                                    public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                                        ReactScrollView reactScrollView;
                                        ReactViewGroup reactViewGroup;
                                        try {
                                            reactScrollView = (ReactScrollView) uIManagerModule.resolveView(i4);
                                        } catch (IllegalViewOperationException unused) {
                                            reactScrollView = null;
                                        }
                                        if (reactScrollView != null && (reactViewGroup = (ReactViewGroup) reactScrollView.getChildAt(0)) != null) {
                                            int scrollY = reactScrollView.getScrollY();
                                            access$100.setCurrentScrollY(scrollY);
                                            for (int i = i5; i < reactViewGroup.getChildCount(); i++) {
                                                View childAt = reactViewGroup.getChildAt(i);
                                                if (childAt.getTop() >= scrollY) {
                                                    access$100.setPrevFirstVisibleTop(childAt.getTop());
                                                    access$100.setFirstVisibleView(childAt);
                                                    return;
                                                }
                                            }
                                        }
                                    }
                                });
                            }
                        };
                        AnonymousClass2 r3 = new UIImplementation.LayoutUpdateListener() {
                            public void onLayoutUpdated(ReactShadowNode reactShadowNode) {
                                ScrollViewUIHolder scrollViewUIHolder;
                                View firstVisibleView;
                                for (Map.Entry entry : MvcpScrollViewManagerModule.this.scrollViewUIHolders.entrySet()) {
                                    ReactScrollView reactScrollView = null;
                                    try {
                                        reactScrollView = (ReactScrollView) uIManagerModule.resolveView(((Integer) entry.getKey()).intValue());
                                    } catch (IllegalViewOperationException unused) {
                                    }
                                    if (!(reactScrollView == null || (firstVisibleView = scrollViewUIHolder.getFirstVisibleView()) == null)) {
                                        int top = firstVisibleView.getTop() - (scrollViewUIHolder = (ScrollViewUIHolder) entry.getValue()).getPrevFirstVisibleTop();
                                        boolean z = true;
                                        if (Math.abs(top) > 1) {
                                            int currentScrollY = scrollViewUIHolder.getCurrentScrollY();
                                            if (currentScrollY > i6) {
                                                z = false;
                                            }
                                            reactScrollView.setScrollY(currentScrollY + top);
                                            if (z) {
                                                reactScrollView.smoothScrollTo(reactScrollView.getScrollX(), 0);
                                            }
                                        }
                                    }
                                }
                            }
                        };
                        uIManagerModule.addUIManagerListener(r2);
                        uIManagerModule.getUIImplementation().setLayoutUpdateListener(r3);
                        int size = MvcpScrollViewManagerModule.this.uiManagerModuleListeners.size() + 1;
                        MvcpScrollViewManagerModule.this.uiManagerModuleListeners.put(Integer.valueOf(size), r2);
                        access$100.setRnHandle(size);
                        promise2.resolve(Integer.valueOf(size));
                    } catch (IllegalViewOperationException e) {
                        promise2.reject((Throwable) e);
                    }
                }
            }
        });
    }

    @ReactMethod
    public void disableMaintainVisibleContentPosition(final int i, Promise promise) {
        if (i >= 0) {
            try {
                final UIManagerModule uIManagerModule = (UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class);
                if (uIManagerModule != null) {
                    uIManagerModule.addUIBlock(new UIBlock() {
                        public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                            uIManagerModule.removeUIManagerListener((UIManagerModuleListener) MvcpScrollViewManagerModule.this.uiManagerModuleListeners.remove(Integer.valueOf(i)));
                            if (MvcpScrollViewManagerModule.this.uiManagerModuleListeners.size() == 0) {
                                uIManagerModule.getUIImplementation().removeLayoutUpdateListener();
                            }
                            MvcpScrollViewManagerModule.this.removeScrollViewUiHolderByRNHandle(i);
                        }
                    });
                }
            } catch (Exception unused) {
                promise.resolve(-1);
                return;
            }
        }
        promise.resolve((Object) null);
    }
}
