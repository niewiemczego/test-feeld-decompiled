package com.swmansion.reanimated.layoutReanimation;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.layoutanimation.LayoutAnimationController;
import com.facebook.react.uimanager.layoutanimation.LayoutAnimationListener;
import com.swmansion.reanimated.ReanimatedModule;
import com.swmansion.rnscreens.ScreenStackViewManager;
import com.swmansion.rnscreens.ScreenViewManager;
import com.swmansion.rnscreens.events.ScreenWillDisappearEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* compiled from: ReanimatedNativeHierarchyManager */
class ReaLayoutAnimator extends LayoutAnimationController {
    private AnimationsManager mAnimationsManager = null;
    private final ReactApplicationContext mContext;
    private volatile boolean mInitialized = false;
    private final WeakReference<NativeViewHierarchyManager> mWeakNativeViewHierarchyManager;
    private final ArrayList<View> viewsToSnapshot = new ArrayList<>();

    ReaLayoutAnimator(ReactApplicationContext reactApplicationContext, NativeViewHierarchyManager nativeViewHierarchyManager) {
        this.mContext = reactApplicationContext;
        this.mWeakNativeViewHierarchyManager = new WeakReference<>(nativeViewHierarchyManager);
    }

    public void maybeInit() {
        if (!this.mInitialized) {
            this.mInitialized = true;
            AnimationsManager animationsManager = ((ReanimatedModule) this.mContext.getNativeModule(ReanimatedModule.class)).getNodesManager().getAnimationsManager();
            this.mAnimationsManager = animationsManager;
            animationsManager.setReanimatedNativeHierarchyManager((ReanimatedNativeHierarchyManager) this.mWeakNativeViewHierarchyManager.get());
        }
    }

    public boolean shouldAnimateLayout(View view) {
        if (!isLayoutAnimationEnabled()) {
            return super.shouldAnimateLayout(view);
        }
        if (view == null || view.getParent() == null) {
            return false;
        }
        return true;
    }

    public void reset() {
        super.reset();
        Iterator<View> it = this.viewsToSnapshot.iterator();
        while (it.hasNext()) {
            View next = it.next();
            this.mAnimationsManager.onViewCreate(next, (ViewGroup) next.getParent(), new Snapshot(next, (NativeViewHierarchyManager) this.mWeakNativeViewHierarchyManager.get()));
        }
        this.viewsToSnapshot.clear();
    }

    public void applyLayoutUpdate(View view, int i, int i2, int i3, int i4) {
        if (!isLayoutAnimationEnabled()) {
            super.applyLayoutUpdate(view, i, i2, i3, i4);
            return;
        }
        UiThreadUtil.assertOnUiThread();
        maybeInit();
        if (view.getWidth() != 0 && view.getHeight() != 0) {
            Snapshot snapshot = new Snapshot(view, (NativeViewHierarchyManager) this.mWeakNativeViewHierarchyManager.get());
            view.layout(i, i2, i3 + i, i4 + i2);
            this.mAnimationsManager.onViewUpdate(view, snapshot, new Snapshot(view, (NativeViewHierarchyManager) this.mWeakNativeViewHierarchyManager.get()));
        } else if (!this.mAnimationsManager.hasAnimationForTag(view.getId(), 1)) {
            super.applyLayoutUpdate(view, i, i2, i3, i4);
            this.mAnimationsManager.maybeRegisterSharedView(view);
        } else {
            view.layout(i, i2, i3 + i, i4 + i2);
            if (view.getId() != -1) {
                this.viewsToSnapshot.add(view);
            }
        }
    }

    public void deleteView(View view, LayoutAnimationListener layoutAnimationListener) {
        if (!isLayoutAnimationEnabled()) {
            super.deleteView(view, layoutAnimationListener);
            return;
        }
        UiThreadUtil.assertOnUiThread();
        NativeViewHierarchyManager nativeViewHierarchyManager = (NativeViewHierarchyManager) this.mWeakNativeViewHierarchyManager.get();
        try {
            if (nativeViewHierarchyManager.resolveViewManager(view.getId()).getName().equals(ScreenViewManager.REACT_CLASS) && view.getParent() != null && (view.getParent().getParent() instanceof View)) {
                try {
                    if (nativeViewHierarchyManager.resolveViewManager(((View) view.getParent().getParent()).getId()).getName().equals(ScreenStackViewManager.REACT_CLASS)) {
                        this.mAnimationsManager.cancelAnimationsInSubviews(view);
                        super.deleteView(view, layoutAnimationListener);
                        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ReactContext) view.getContext(), view.getId());
                        if (eventDispatcherForReactTag != null) {
                            eventDispatcherForReactTag.addListener(new ReaLayoutAnimator$$ExternalSyntheticLambda0(this));
                            return;
                        }
                        return;
                    }
                } catch (IllegalViewOperationException e) {
                    e.printStackTrace();
                    this.mAnimationsManager.cancelAnimationsInSubviews(view);
                    super.deleteView(view, layoutAnimationListener);
                    return;
                }
            }
            maybeInit();
            Objects.requireNonNull(layoutAnimationListener);
            this.mAnimationsManager.onViewRemoval(view, (ViewGroup) view.getParent(), new ReaLayoutAnimator$$ExternalSyntheticLambda1(layoutAnimationListener));
        } catch (IllegalViewOperationException e2) {
            e2.printStackTrace();
            this.mAnimationsManager.cancelAnimationsInSubviews(view);
            super.deleteView(view, layoutAnimationListener);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$deleteView$0$com-swmansion-reanimated-layoutReanimation-ReaLayoutAnimator  reason: not valid java name */
    public /* synthetic */ void m644lambda$deleteView$0$comswmansionreanimatedlayoutReanimationReaLayoutAnimator(Event event) {
        if (event.getEventName().equals(ScreenWillDisappearEvent.EVENT_NAME)) {
            getAnimationsManager().notifyAboutScreenWillDisappear();
        }
    }

    public boolean isLayoutAnimationEnabled() {
        if (!this.mContext.hasActiveReactInstance()) {
            return false;
        }
        maybeInit();
        return this.mAnimationsManager.isLayoutAnimationEnabled();
    }

    public AnimationsManager getAnimationsManager() {
        return this.mAnimationsManager;
    }
}
