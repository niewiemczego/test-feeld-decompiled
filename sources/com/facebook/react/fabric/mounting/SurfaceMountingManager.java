package com.facebook.react.fabric.mounting;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.RetryableMountingLayerException;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.mapbuffer.ReadableMapBuffer;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.fabric.GuardedFrameCallback;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.fabric.mounting.mountitems.MountItem;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.ReactOverflowViewWithInset;
import com.facebook.react.uimanager.ReactRoot;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.RootViewManager;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerRegistry;
import com.facebook.react.views.view.ReactMapBufferViewManager;
import com.facebook.react.views.view.ReactViewManagerWrapper;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.annotation.Nullable;

public class SurfaceMountingManager {
    private static final boolean SHOW_CHANGED_VIEW_HIERARCHIES = false;
    public static final String TAG = "SurfaceMountingManager";
    /* access modifiers changed from: private */
    public final Set<Integer> mErroneouslyReaddedReactTags = new HashSet();
    private volatile boolean mIsStopped = false;
    /* access modifiers changed from: private */
    public JSResponderHandler mJSResponderHandler;
    /* access modifiers changed from: private */
    public MountingManager.MountItemExecutor mMountItemExecutor;
    /* access modifiers changed from: private */
    public ConcurrentLinkedQueue<MountItem> mOnViewAttachItems = new ConcurrentLinkedQueue<>();
    /* access modifiers changed from: private */
    public final Stack<Integer> mReactTagsToRemove = new Stack<>();
    private RemoveDeleteTreeUIFrameCallback mRemoveDeleteTreeUIFrameCallback;
    /* access modifiers changed from: private */
    public volatile boolean mRootViewAttached = false;
    /* access modifiers changed from: private */
    public RootViewManager mRootViewManager;
    /* access modifiers changed from: private */
    public final int mSurfaceId;
    /* access modifiers changed from: private */
    public Set<Integer> mTagSetForStoppedSurface;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<Integer, ViewState> mTagToViewState = new ConcurrentHashMap<>();
    @Nullable
    private ThemedReactContext mThemedReactContext;
    /* access modifiers changed from: private */
    public ViewManagerRegistry mViewManagerRegistry;

    public SurfaceMountingManager(int i, JSResponderHandler jSResponderHandler, ViewManagerRegistry viewManagerRegistry, RootViewManager rootViewManager, MountingManager.MountItemExecutor mountItemExecutor, ThemedReactContext themedReactContext) {
        this.mSurfaceId = i;
        this.mJSResponderHandler = jSResponderHandler;
        this.mViewManagerRegistry = viewManagerRegistry;
        this.mRootViewManager = rootViewManager;
        this.mMountItemExecutor = mountItemExecutor;
        this.mThemedReactContext = themedReactContext;
    }

    public boolean isStopped() {
        return this.mIsStopped;
    }

    public void attachRootView(View view, ThemedReactContext themedReactContext) {
        this.mThemedReactContext = themedReactContext;
        addRootView(view);
    }

    public int getSurfaceId() {
        return this.mSurfaceId;
    }

    public boolean isRootViewAttached() {
        return this.mRootViewAttached;
    }

    @Nullable
    public ThemedReactContext getContext() {
        return this.mThemedReactContext;
    }

    private static void logViewHierarchy(ViewGroup viewGroup, boolean z) {
        int i;
        int id = viewGroup.getId();
        FLog.e(TAG, "  <ViewGroup tag=" + id + " class=" + viewGroup.getClass().toString() + ">");
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            FLog.e(TAG, "     <View idx=" + i2 + " tag=" + viewGroup.getChildAt(i2).getId() + " class=" + viewGroup.getChildAt(i2).getClass().toString() + ">");
        }
        String str = TAG;
        FLog.e(str, "  </ViewGroup tag=" + id + ">");
        if (z) {
            FLog.e(str, "Displaying Ancestors:");
            for (ViewParent parent = viewGroup.getParent(); parent != null; parent = parent.getParent()) {
                ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup2 == null) {
                    i = -1;
                } else {
                    i = viewGroup2.getId();
                }
                FLog.e(TAG, "<ViewParent tag=" + i + " class=" + parent.getClass().toString() + ">");
            }
        }
    }

    public boolean getViewExists(int i) {
        Set<Integer> set = this.mTagSetForStoppedSurface;
        if (set != null && set.contains(Integer.valueOf(i))) {
            return true;
        }
        ConcurrentHashMap<Integer, ViewState> concurrentHashMap = this.mTagToViewState;
        if (concurrentHashMap == null) {
            return false;
        }
        return concurrentHashMap.containsKey(Integer.valueOf(i));
    }

    public void executeOnViewAttach(MountItem mountItem) {
        this.mOnViewAttachItems.add(mountItem);
    }

    private void addRootView(final View view) {
        if (!isStopped()) {
            this.mTagToViewState.put(Integer.valueOf(this.mSurfaceId), new ViewState(this.mSurfaceId, view, new ReactViewManagerWrapper.DefaultViewManager(this.mRootViewManager), true));
            AnonymousClass1 r0 = new Runnable() {
                public void run() {
                    if (!SurfaceMountingManager.this.isStopped()) {
                        if (view.getId() == SurfaceMountingManager.this.mSurfaceId) {
                            ReactSoftExceptionLogger.logSoftException(SurfaceMountingManager.TAG, new IllegalViewOperationException("Race condition in addRootView detected. Trying to set an id of [" + SurfaceMountingManager.this.mSurfaceId + "] on the RootView, but that id has already been set. "));
                        } else if (view.getId() != -1) {
                            FLog.e(SurfaceMountingManager.TAG, "Trying to add RootTag to RootView that already has a tag: existing tag: [%d] new tag: [%d]", Integer.valueOf(view.getId()), Integer.valueOf(SurfaceMountingManager.this.mSurfaceId));
                            throw new IllegalViewOperationException("Trying to add a root view with an explicit id already set. React Native uses the id field to track react tags and will overwrite this field. If that is fine, explicitly overwrite the id field to View.NO_ID before calling addRootView.");
                        }
                        view.setId(SurfaceMountingManager.this.mSurfaceId);
                        View view = view;
                        if (view instanceof ReactRoot) {
                            ((ReactRoot) view).setRootViewTag(SurfaceMountingManager.this.mSurfaceId);
                        }
                        boolean unused = SurfaceMountingManager.this.mRootViewAttached = true;
                        SurfaceMountingManager.this.executeViewAttachMountItems();
                    }
                }
            };
            if (UiThreadUtil.isOnUiThread()) {
                r0.run();
            } else {
                UiThreadUtil.runOnUiThread(r0);
            }
        }
    }

    /* access modifiers changed from: private */
    public void executeViewAttachMountItems() {
        this.mMountItemExecutor.executeItems(this.mOnViewAttachItems);
    }

    public void stopSurface() {
        if (!isStopped()) {
            this.mIsStopped = true;
            for (ViewState next : this.mTagToViewState.values()) {
                if (next.mStateWrapper != null) {
                    next.mStateWrapper.destroyState();
                    next.mStateWrapper = null;
                }
                if (next.mEventEmitter != null) {
                    next.mEventEmitter.destroy();
                    next.mEventEmitter = null;
                }
            }
            AnonymousClass2 r0 = new Runnable() {
                public void run() {
                    for (ViewState access$500 : SurfaceMountingManager.this.mTagToViewState.values()) {
                        SurfaceMountingManager.this.onViewStateDeleted(access$500);
                    }
                    SurfaceMountingManager surfaceMountingManager = SurfaceMountingManager.this;
                    Set unused = surfaceMountingManager.mTagSetForStoppedSurface = surfaceMountingManager.mTagToViewState.keySet();
                    ConcurrentHashMap unused2 = SurfaceMountingManager.this.mTagToViewState = null;
                    JSResponderHandler unused3 = SurfaceMountingManager.this.mJSResponderHandler = null;
                    RootViewManager unused4 = SurfaceMountingManager.this.mRootViewManager = null;
                    MountingManager.MountItemExecutor unused5 = SurfaceMountingManager.this.mMountItemExecutor = null;
                    SurfaceMountingManager.this.mOnViewAttachItems.clear();
                    if (ReactFeatureFlags.enableViewRecycling) {
                        SurfaceMountingManager.this.mViewManagerRegistry.onSurfaceStopped(SurfaceMountingManager.this.mSurfaceId);
                    }
                }
            };
            if (UiThreadUtil.isOnUiThread()) {
                r0.run();
            } else {
                UiThreadUtil.runOnUiThread(r0);
            }
        }
    }

    public void addViewAt(int i, int i2, int i3) {
        UiThreadUtil.assertOnUiThread();
        if (!isStopped()) {
            ViewState viewState = getViewState(i);
            if (viewState.mView instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) viewState.mView;
                ViewState viewState2 = getViewState(i2);
                View view = viewState2.mView;
                if (view != null) {
                    ViewParent parent = view.getParent();
                    if (parent != null) {
                        boolean z = parent instanceof ViewGroup;
                        ReactSoftExceptionLogger.logSoftException(TAG, new IllegalStateException("addViewAt: cannot insert view [" + i2 + "] into parent [" + i + "]: View already has a parent: [" + (z ? ((ViewGroup) parent).getId() : -1) + "]  Parent: " + parent.getClass().getSimpleName() + " View: " + view.getClass().getSimpleName()));
                        if (z) {
                            ((ViewGroup) parent).removeView(view);
                        }
                        this.mErroneouslyReaddedReactTags.add(Integer.valueOf(i2));
                    }
                    try {
                        getViewGroupManager(viewState).addView(viewGroup, view, i3);
                    } catch (IllegalStateException e) {
                        throw new IllegalStateException("addViewAt: failed to insert view [" + i2 + "] into parent [" + i + "] at index " + i3, e);
                    }
                } else {
                    throw new IllegalStateException("Unable to find view for viewState " + viewState2 + " and tag " + i2);
                }
            } else {
                String str = "Unable to add a view into a view that is not a ViewGroup. ParentTag: " + i + " - Tag: " + i2 + " - Index: " + i3;
                FLog.e(TAG, str);
                throw new IllegalStateException(str);
            }
        }
    }

    public void removeViewAt(int i, int i2, int i3) {
        if (!isStopped()) {
            if (this.mErroneouslyReaddedReactTags.contains(Integer.valueOf(i))) {
                ReactSoftExceptionLogger.logSoftException(TAG, new IllegalViewOperationException("removeViewAt tried to remove a React View that was actually reused. This indicates a bug in the Differ (specifically instruction ordering). [" + i + "]"));
                return;
            }
            UiThreadUtil.assertOnUiThread();
            ViewState nullableViewState = getNullableViewState(i2);
            if (nullableViewState == null) {
                ReactSoftExceptionLogger.logSoftException(MountingManager.TAG, new IllegalStateException("Unable to find viewState for tag: [" + i2 + "] for removeViewAt"));
            } else if (nullableViewState.mView instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) nullableViewState.mView;
                if (viewGroup != null) {
                    ViewGroupManager<ViewGroup> viewGroupManager = getViewGroupManager(nullableViewState);
                    View childAt = viewGroupManager.getChildAt(viewGroup, i3);
                    int id = childAt != null ? childAt.getId() : -1;
                    if (id != i) {
                        int childCount = viewGroup.getChildCount();
                        int i4 = 0;
                        while (true) {
                            if (i4 >= childCount) {
                                i4 = -1;
                                break;
                            } else if (viewGroup.getChildAt(i4).getId() == i) {
                                break;
                            } else {
                                i4++;
                            }
                        }
                        if (i4 == -1) {
                            FLog.e(TAG, "removeViewAt: [" + i + "] -> [" + i2 + "] @" + i3 + ": view already removed from parent! Children in parent: " + childCount);
                            return;
                        }
                        logViewHierarchy(viewGroup, true);
                        ReactSoftExceptionLogger.logSoftException(TAG, new IllegalStateException("Tried to remove view [" + i + "] of parent [" + i2 + "] at index " + i3 + ", but got view tag " + id + " - actual index of view: " + i4));
                        i3 = i4;
                    }
                    try {
                        viewGroupManager.removeViewAt(viewGroup, i3);
                    } catch (RuntimeException e) {
                        int childCount2 = viewGroupManager.getChildCount(viewGroup);
                        logViewHierarchy(viewGroup, true);
                        throw new IllegalStateException("Cannot remove child at index " + i3 + " from parent ViewGroup [" + viewGroup.getId() + "], only " + childCount2 + " children in parent. Warning: childCount may be incorrect!", e);
                    }
                } else {
                    throw new IllegalStateException("Unable to find view for tag [" + i2 + "]");
                }
            } else {
                String str = "Unable to remove a view from a view that is not a ViewGroup. ParentTag: " + i2 + " - Tag: " + i + " - Index: " + i3;
                FLog.e(TAG, str);
                throw new IllegalStateException(str);
            }
        }
    }

    public void removeDeleteTreeAt(int i, int i2, int i3) {
        if (!isStopped()) {
            UiThreadUtil.assertOnUiThread();
            ViewState nullableViewState = getNullableViewState(i2);
            if (nullableViewState == null) {
                ReactSoftExceptionLogger.logSoftException(MountingManager.TAG, new IllegalStateException("Unable to find viewState for tag: [" + i2 + "] for removeDeleteTreeAt"));
            } else if (nullableViewState.mView instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) nullableViewState.mView;
                if (viewGroup != null) {
                    ViewGroupManager<ViewGroup> viewGroupManager = getViewGroupManager(nullableViewState);
                    View childAt = viewGroupManager.getChildAt(viewGroup, i3);
                    int id = childAt != null ? childAt.getId() : -1;
                    if (id != i) {
                        int childCount = viewGroup.getChildCount();
                        int i4 = 0;
                        while (true) {
                            if (i4 >= childCount) {
                                i4 = -1;
                                break;
                            } else if (viewGroup.getChildAt(i4).getId() == i) {
                                break;
                            } else {
                                i4++;
                            }
                        }
                        if (i4 == -1) {
                            FLog.e(TAG, "removeDeleteTreeAt: [" + i + "] -> [" + i2 + "] @" + i3 + ": view already removed from parent! Children in parent: " + childCount);
                            return;
                        }
                        logViewHierarchy(viewGroup, true);
                        ReactSoftExceptionLogger.logSoftException(TAG, new IllegalStateException("Tried to remove+delete view [" + i + "] of parent [" + i2 + "] at index " + i3 + ", but got view tag " + id + " - actual index of view: " + i4));
                        i3 = i4;
                    }
                    try {
                        viewGroupManager.removeViewAt(viewGroup, i3);
                        runDeferredTagRemovalAndDeletion();
                        this.mReactTagsToRemove.push(Integer.valueOf(i));
                    } catch (RuntimeException e) {
                        int childCount2 = viewGroupManager.getChildCount(viewGroup);
                        logViewHierarchy(viewGroup, true);
                        throw new IllegalStateException("Cannot remove child at index " + i3 + " from parent ViewGroup [" + viewGroup.getId() + "], only " + childCount2 + " children in parent. Warning: childCount may be incorrect!", e);
                    }
                } else {
                    throw new IllegalStateException("Unable to find view for tag [" + i2 + "]");
                }
            } else {
                String str = "Unable to remove+delete a view from a view that is not a ViewGroup. ParentTag: " + i2 + " - Tag: " + i + " - Index: " + i3;
                FLog.e(TAG, str);
                throw new IllegalStateException(str);
            }
        }
    }

    private void runDeferredTagRemovalAndDeletion() {
        if (this.mReactTagsToRemove.empty()) {
            if (this.mRemoveDeleteTreeUIFrameCallback == null) {
                this.mRemoveDeleteTreeUIFrameCallback = new RemoveDeleteTreeUIFrameCallback(this.mThemedReactContext);
            }
            ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.IDLE_EVENT, this.mRemoveDeleteTreeUIFrameCallback);
        }
    }

    public void createView(String str, int i, @Nullable Object obj, @Nullable StateWrapper stateWrapper, @Nullable EventEmitterWrapper eventEmitterWrapper, boolean z) {
        if (!isStopped()) {
            ViewState nullableViewState = getNullableViewState(i);
            if (nullableViewState == null || nullableViewState.mView == null) {
                createViewUnsafe(str, i, obj, stateWrapper, eventEmitterWrapper, z);
            }
        }
    }

    public void createViewUnsafe(String str, int i, @Nullable Object obj, @Nullable StateWrapper stateWrapper, @Nullable EventEmitterWrapper eventEmitterWrapper, boolean z) {
        View view;
        ReactViewManagerWrapper reactViewManagerWrapper;
        Object reactStylesDiffMap = obj instanceof ReadableMap ? new ReactStylesDiffMap((ReadableMap) obj) : obj;
        if (z) {
            if (obj instanceof ReadableMapBuffer) {
                reactViewManagerWrapper = ReactMapBufferViewManager.INSTANCE;
            } else {
                reactViewManagerWrapper = new ReactViewManagerWrapper.DefaultViewManager(this.mViewManagerRegistry.get(str));
            }
            view = reactViewManagerWrapper.createView(i, this.mThemedReactContext, reactStylesDiffMap, stateWrapper, this.mJSResponderHandler);
        } else {
            reactViewManagerWrapper = null;
            view = null;
        }
        ViewState viewState = new ViewState(i, view, reactViewManagerWrapper);
        viewState.mCurrentProps = reactStylesDiffMap;
        viewState.mStateWrapper = stateWrapper;
        viewState.mEventEmitter = eventEmitterWrapper;
        this.mTagToViewState.put(Integer.valueOf(i), viewState);
    }

    public void updateProps(int i, Object obj) {
        if (!isStopped()) {
            ViewState viewState = getViewState(i);
            if (obj instanceof ReadableMap) {
                obj = new ReactStylesDiffMap((ReadableMap) obj);
            }
            viewState.mCurrentProps = obj;
            View view = viewState.mView;
            if (view != null) {
                ((ReactViewManagerWrapper) Assertions.assertNotNull(viewState.mViewManager)).updateProperties(view, viewState.mCurrentProps);
                return;
            }
            throw new IllegalStateException("Unable to find view for tag [" + i + "]");
        }
    }

    @Deprecated
    public void receiveCommand(int i, int i2, @Nullable ReadableArray readableArray) {
        if (!isStopped()) {
            ViewState nullableViewState = getNullableViewState(i);
            if (nullableViewState == null) {
                throw new RetryableMountingLayerException("Unable to find viewState for tag: [" + i + "] for commandId: " + i2);
            } else if (nullableViewState.mViewManager == null) {
                throw new RetryableMountingLayerException("Unable to find viewManager for tag " + i);
            } else if (nullableViewState.mView != null) {
                nullableViewState.mViewManager.receiveCommand(nullableViewState.mView, i2, readableArray);
            } else {
                throw new RetryableMountingLayerException("Unable to find viewState view for tag " + i);
            }
        }
    }

    public void receiveCommand(int i, String str, @Nullable ReadableArray readableArray) {
        if (!isStopped()) {
            ViewState nullableViewState = getNullableViewState(i);
            if (nullableViewState == null) {
                throw new RetryableMountingLayerException("Unable to find viewState for tag: " + i + " for commandId: " + str);
            } else if (nullableViewState.mViewManager == null) {
                throw new RetryableMountingLayerException("Unable to find viewState manager for tag " + i);
            } else if (nullableViewState.mView != null) {
                nullableViewState.mViewManager.receiveCommand(nullableViewState.mView, str, readableArray);
            } else {
                throw new RetryableMountingLayerException("Unable to find viewState view for tag " + i);
            }
        }
    }

    public void sendAccessibilityEvent(int i, int i2) {
        if (!isStopped()) {
            ViewState viewState = getViewState(i);
            if (viewState.mViewManager == null) {
                throw new RetryableMountingLayerException("Unable to find viewState manager for tag " + i);
            } else if (viewState.mView != null) {
                viewState.mView.sendAccessibilityEvent(i2);
            } else {
                throw new RetryableMountingLayerException("Unable to find viewState view for tag " + i);
            }
        }
    }

    public void updateLayout(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (!isStopped()) {
            ViewState viewState = getViewState(i);
            if (!viewState.mIsRoot) {
                View view = viewState.mView;
                if (view != null) {
                    view.measure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), View.MeasureSpec.makeMeasureSpec(i6, 1073741824));
                    ViewParent parent = view.getParent();
                    if (parent instanceof RootView) {
                        parent.requestLayout();
                    }
                    ViewState viewState2 = getViewState(i2);
                    ViewGroupManager<?> viewGroupManager = null;
                    if (viewState2.mViewManager != null) {
                        viewGroupManager = viewState2.mViewManager.getViewGroupManager();
                    }
                    if (viewGroupManager == null || !viewGroupManager.needsCustomLayoutForChildren()) {
                        view.layout(i3, i4, i5 + i3, i6 + i4);
                    }
                    int i8 = i7 == 0 ? 4 : 0;
                    if (view.getVisibility() != i8) {
                        view.setVisibility(i8);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("Unable to find View for tag: " + i);
            }
        }
    }

    public void updatePadding(int i, int i2, int i3, int i4, int i5) {
        UiThreadUtil.assertOnUiThread();
        if (!isStopped()) {
            ViewState viewState = getViewState(i);
            if (!viewState.mIsRoot) {
                View view = viewState.mView;
                if (view != null) {
                    ReactViewManagerWrapper reactViewManagerWrapper = viewState.mViewManager;
                    if (reactViewManagerWrapper != null) {
                        reactViewManagerWrapper.setPadding(view, i2, i3, i4, i5);
                        return;
                    }
                    throw new IllegalStateException("Unable to find ViewManager for view: " + viewState);
                }
                throw new IllegalStateException("Unable to find View for tag: " + i);
            }
        }
    }

    public void updateOverflowInset(int i, int i2, int i3, int i4, int i5) {
        if (!isStopped()) {
            ViewState viewState = getViewState(i);
            if (!viewState.mIsRoot) {
                View view = viewState.mView;
                if (view == null) {
                    throw new IllegalStateException("Unable to find View for tag: " + i);
                } else if (view instanceof ReactOverflowViewWithInset) {
                    ((ReactOverflowViewWithInset) view).setOverflowInset(i2, i3, i4, i5);
                }
            }
        }
    }

    public void updateState(int i, @Nullable StateWrapper stateWrapper) {
        UiThreadUtil.assertOnUiThread();
        if (!isStopped()) {
            ViewState viewState = getViewState(i);
            StateWrapper stateWrapper2 = viewState.mStateWrapper;
            viewState.mStateWrapper = stateWrapper;
            ReactViewManagerWrapper reactViewManagerWrapper = viewState.mViewManager;
            if (reactViewManagerWrapper != null) {
                Object updateState = reactViewManagerWrapper.updateState(viewState.mView, viewState.mCurrentProps, stateWrapper);
                if (updateState != null) {
                    reactViewManagerWrapper.updateExtraData(viewState.mView, updateState);
                }
                if (stateWrapper2 != null) {
                    stateWrapper2.destroyState();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Unable to find ViewManager for tag: " + i);
        }
    }

    public void updateEventEmitter(int i, EventEmitterWrapper eventEmitterWrapper) {
        UiThreadUtil.assertOnUiThread();
        if (!isStopped()) {
            ViewState viewState = this.mTagToViewState.get(Integer.valueOf(i));
            if (viewState == null) {
                viewState = new ViewState(i, (View) null, (ReactViewManagerWrapper) null);
                this.mTagToViewState.put(Integer.valueOf(i), viewState);
            }
            EventEmitterWrapper eventEmitterWrapper2 = viewState.mEventEmitter;
            viewState.mEventEmitter = eventEmitterWrapper;
            if (!(eventEmitterWrapper2 == eventEmitterWrapper || eventEmitterWrapper2 == null)) {
                eventEmitterWrapper2.destroy();
            }
            if (viewState.mPendingEventQueue != null) {
                for (ViewEvent viewEvent : viewState.mPendingEventQueue) {
                    if (viewEvent.canCoalesceEvent()) {
                        eventEmitterWrapper.invokeUnique(viewEvent.getEventName(), viewEvent.getParams(), viewEvent.getCustomCoalesceKey());
                    } else {
                        eventEmitterWrapper.invoke(viewEvent.getEventName(), viewEvent.getParams(), viewEvent.getEventCategory());
                    }
                }
                viewState.mPendingEventQueue = null;
            }
        }
    }

    public synchronized void setJSResponder(int i, int i2, boolean z) {
        UiThreadUtil.assertOnUiThread();
        if (!isStopped()) {
            if (!z) {
                this.mJSResponderHandler.setJSResponder(i2, (ViewParent) null);
                return;
            }
            ViewState viewState = getViewState(i);
            View view = viewState.mView;
            if (i2 != i && (view instanceof ViewParent)) {
                this.mJSResponderHandler.setJSResponder(i2, (ViewParent) view);
            } else if (view == null) {
                SoftAssertions.assertUnreachable("Cannot find view for tag [" + i + "].");
            } else {
                if (viewState.mIsRoot) {
                    SoftAssertions.assertUnreachable("Cannot block native responder on [" + i + "] that is a root view");
                }
                this.mJSResponderHandler.setJSResponder(i2, view.getParent());
            }
        }
    }

    /* access modifiers changed from: private */
    public void onViewStateDeleted(ViewState viewState) {
        if (viewState.mStateWrapper != null) {
            viewState.mStateWrapper.destroyState();
            viewState.mStateWrapper = null;
        }
        if (viewState.mEventEmitter != null) {
            viewState.mEventEmitter.destroy();
            viewState.mEventEmitter = null;
        }
        ReactViewManagerWrapper reactViewManagerWrapper = viewState.mViewManager;
        if (!viewState.mIsRoot && reactViewManagerWrapper != null) {
            reactViewManagerWrapper.onDropViewInstance(viewState.mView);
        }
    }

    public void deleteView(int i) {
        UiThreadUtil.assertOnUiThread();
        if (!isStopped()) {
            ViewState nullableViewState = getNullableViewState(i);
            if (nullableViewState == null) {
                ReactSoftExceptionLogger.logSoftException(MountingManager.TAG, new IllegalStateException("Unable to find viewState for tag: " + i + " for deleteView"));
                return;
            }
            this.mTagToViewState.remove(Integer.valueOf(i));
            onViewStateDeleted(nullableViewState);
        }
    }

    public void preallocateView(String str, int i, @Nullable Object obj, @Nullable StateWrapper stateWrapper, @Nullable EventEmitterWrapper eventEmitterWrapper, boolean z) {
        UiThreadUtil.assertOnUiThread();
        if (!isStopped() && getNullableViewState(i) == null) {
            createViewUnsafe(str, i, obj, stateWrapper, eventEmitterWrapper, z);
        }
    }

    @Nullable
    public EventEmitterWrapper getEventEmitter(int i) {
        ViewState nullableViewState = getNullableViewState(i);
        if (nullableViewState == null) {
            return null;
        }
        return nullableViewState.mEventEmitter;
    }

    public View getView(int i) {
        View view;
        ViewState nullableViewState = getNullableViewState(i);
        if (nullableViewState == null) {
            view = null;
        } else {
            view = nullableViewState.mView;
        }
        if (view != null) {
            return view;
        }
        throw new IllegalViewOperationException("Trying to resolve view with tag " + i + " which doesn't exist");
    }

    private ViewState getViewState(int i) {
        ViewState viewState = this.mTagToViewState.get(Integer.valueOf(i));
        if (viewState != null) {
            return viewState;
        }
        throw new RetryableMountingLayerException("Unable to find viewState for tag " + i + ". Surface stopped: " + isStopped());
    }

    /* access modifiers changed from: private */
    @Nullable
    public ViewState getNullableViewState(int i) {
        ConcurrentHashMap<Integer, ViewState> concurrentHashMap = this.mTagToViewState;
        if (concurrentHashMap == null) {
            return null;
        }
        return concurrentHashMap.get(Integer.valueOf(i));
    }

    private static ViewGroupManager<ViewGroup> getViewGroupManager(ViewState viewState) {
        if (viewState.mViewManager != null) {
            return viewState.mViewManager.getViewGroupManager();
        }
        throw new IllegalStateException("Unable to find ViewManager for view: " + viewState);
    }

    public void printSurfaceState() {
        FLog.e(TAG, "Views created for surface {%d}:", Integer.valueOf(getSurfaceId()));
        for (ViewState next : this.mTagToViewState.values()) {
            Integer num = null;
            String name = next.mViewManager != null ? next.mViewManager.getName() : null;
            View view = next.mView;
            View view2 = view != null ? (View) view.getParent() : null;
            if (view2 != null) {
                num = Integer.valueOf(view2.getId());
            }
            FLog.e(TAG, "<%s id=%d parentTag=%s isRoot=%b />", name, Integer.valueOf(next.mReactTag), num, Boolean.valueOf(next.mIsRoot));
        }
    }

    public void enqueuePendingEvent(int i, ViewEvent viewEvent) {
        ViewState viewState;
        UiThreadUtil.assertOnUiThread();
        ConcurrentHashMap<Integer, ViewState> concurrentHashMap = this.mTagToViewState;
        if (concurrentHashMap != null && (viewState = concurrentHashMap.get(Integer.valueOf(i))) != null) {
            Assertions.assertCondition(viewState.mEventEmitter == null, "Only queue pending events when event emitter is null for the given view state");
            if (viewState.mPendingEventQueue == null) {
                viewState.mPendingEventQueue = new LinkedList();
            }
            viewState.mPendingEventQueue.add(viewEvent);
        }
    }

    private static class ViewState {
        @Nullable
        public ReadableMap mCurrentLocalData;
        @Nullable
        public Object mCurrentProps;
        @Nullable
        public EventEmitterWrapper mEventEmitter;
        final boolean mIsRoot;
        @Nullable
        public Queue<ViewEvent> mPendingEventQueue;
        final int mReactTag;
        @Nullable
        public StateWrapper mStateWrapper;
        @Nullable
        final View mView;
        @Nullable
        final ReactViewManagerWrapper mViewManager;

        private ViewState(int i, @Nullable View view, @Nullable ReactViewManagerWrapper reactViewManagerWrapper) {
            this(i, view, reactViewManagerWrapper, false);
        }

        private ViewState(int i, @Nullable View view, @Nullable ReactViewManagerWrapper reactViewManagerWrapper, boolean z) {
            this.mCurrentProps = null;
            this.mCurrentLocalData = null;
            this.mStateWrapper = null;
            this.mEventEmitter = null;
            this.mPendingEventQueue = null;
            this.mReactTag = i;
            this.mView = view;
            this.mIsRoot = z;
            this.mViewManager = reactViewManagerWrapper;
        }

        public String toString() {
            return "ViewState [" + this.mReactTag + "] - isRoot: " + this.mIsRoot + " - props: " + this.mCurrentProps + " - localData: " + this.mCurrentLocalData + " - viewManager: " + this.mViewManager + " - isLayoutOnly: " + (this.mViewManager == null);
        }
    }

    public static class ViewEvent {
        private final boolean mCanCoalesceEvent;
        private final int mCustomCoalesceKey;
        private final int mEventCategory;
        private final String mEventName;
        @Nullable
        private WritableMap mParams;

        public ViewEvent(String str, @Nullable WritableMap writableMap, int i, boolean z, int i2) {
            this.mEventName = str;
            this.mParams = writableMap;
            this.mEventCategory = i;
            this.mCanCoalesceEvent = z;
            this.mCustomCoalesceKey = i2;
        }

        public String getEventName() {
            return this.mEventName;
        }

        public boolean canCoalesceEvent() {
            return this.mCanCoalesceEvent;
        }

        public int getCustomCoalesceKey() {
            return this.mCustomCoalesceKey;
        }

        public int getEventCategory() {
            return this.mEventCategory;
        }

        @Nullable
        public WritableMap getParams() {
            return this.mParams;
        }
    }

    private class RemoveDeleteTreeUIFrameCallback extends GuardedFrameCallback {
        private static final long FRAME_TIME_MS = 16;
        private static final long MAX_TIME_IN_FRAME = 9;

        private RemoveDeleteTreeUIFrameCallback(ReactContext reactContext) {
            super(reactContext);
        }

        private boolean haveExceededNonBatchedFrameTime(long j) {
            return 16 - ((System.nanoTime() - j) / 1000000) < MAX_TIME_IN_FRAME;
        }

        /* JADX WARNING: Removed duplicated region for block: B:31:0x00a6 A[Catch:{ RuntimeException -> 0x009d, all -> 0x00f4 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void doFrameGuarded(long r12) {
            /*
                r11 = this;
                java.util.Stack r0 = new java.util.Stack
                r0.<init>()
                r1 = 0
                r2 = r1
            L_0x0007:
                com.facebook.react.fabric.mounting.SurfaceMountingManager r3 = com.facebook.react.fabric.mounting.SurfaceMountingManager.this     // Catch:{ all -> 0x00f4 }
                java.util.Stack r3 = r3.mReactTagsToRemove     // Catch:{ all -> 0x00f4 }
                boolean r3 = r3.empty()     // Catch:{ all -> 0x00f4 }
                if (r3 != 0) goto L_0x00cb
                com.facebook.react.fabric.mounting.SurfaceMountingManager r3 = com.facebook.react.fabric.mounting.SurfaceMountingManager.this     // Catch:{ all -> 0x00f4 }
                java.util.Stack r3 = r3.mReactTagsToRemove     // Catch:{ all -> 0x00f4 }
                java.lang.Object r3 = r3.pop()     // Catch:{ all -> 0x00f4 }
                java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x00f4 }
                int r3 = r3.intValue()     // Catch:{ all -> 0x00f4 }
                r4 = 1
                int r2 = r2 + r4
                com.facebook.react.fabric.mounting.SurfaceMountingManager r5 = com.facebook.react.fabric.mounting.SurfaceMountingManager.this     // Catch:{ all -> 0x00f4 }
                java.util.Set r5 = r5.mErroneouslyReaddedReactTags     // Catch:{ all -> 0x00f4 }
                java.lang.Integer r6 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00f4 }
                boolean r5 = r5.contains(r6)     // Catch:{ all -> 0x00f4 }
                if (r5 == 0) goto L_0x0059
                java.lang.String r4 = com.facebook.react.fabric.mounting.SurfaceMountingManager.TAG     // Catch:{ all -> 0x00f4 }
                com.facebook.react.uimanager.IllegalViewOperationException r5 = new com.facebook.react.uimanager.IllegalViewOperationException     // Catch:{ all -> 0x00f4 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f4 }
                r6.<init>()     // Catch:{ all -> 0x00f4 }
                java.lang.String r7 = "RemoveDeleteTree recursively tried to remove a React View that was actually reused. This indicates a bug in the Differ. ["
                java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ all -> 0x00f4 }
                java.lang.StringBuilder r3 = r6.append(r3)     // Catch:{ all -> 0x00f4 }
                java.lang.String r6 = "]"
                java.lang.StringBuilder r3 = r3.append(r6)     // Catch:{ all -> 0x00f4 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00f4 }
                r5.<init>(r3)     // Catch:{ all -> 0x00f4 }
                com.facebook.react.bridge.ReactSoftExceptionLogger.logSoftException(r4, r5)     // Catch:{ all -> 0x00f4 }
                goto L_0x0007
            L_0x0059:
                r0.clear()     // Catch:{ all -> 0x00f4 }
                com.facebook.react.fabric.mounting.SurfaceMountingManager r5 = com.facebook.react.fabric.mounting.SurfaceMountingManager.this     // Catch:{ all -> 0x00f4 }
                com.facebook.react.fabric.mounting.SurfaceMountingManager$ViewState r5 = r5.getNullableViewState(r3)     // Catch:{ all -> 0x00f4 }
                if (r5 == 0) goto L_0x0007
                android.view.View r6 = r5.mView     // Catch:{ all -> 0x00f4 }
                boolean r7 = r6 instanceof android.view.ViewGroup     // Catch:{ all -> 0x00f4 }
                if (r7 == 0) goto L_0x00a3
                r7 = r1
                r8 = r7
            L_0x006c:
                r9 = r6
                android.view.ViewGroup r9 = (android.view.ViewGroup) r9     // Catch:{ all -> 0x00f4 }
                android.view.View r9 = r9.getChildAt(r7)     // Catch:{ all -> 0x00f4 }
                if (r9 == 0) goto L_0x0095
                int r10 = r9.getId()     // Catch:{ all -> 0x00f4 }
                if (r8 != 0) goto L_0x0086
                com.facebook.react.fabric.mounting.SurfaceMountingManager r8 = com.facebook.react.fabric.mounting.SurfaceMountingManager.this     // Catch:{ all -> 0x00f4 }
                com.facebook.react.fabric.mounting.SurfaceMountingManager$ViewState r8 = r8.getNullableViewState(r10)     // Catch:{ all -> 0x00f4 }
                if (r8 == 0) goto L_0x0084
                goto L_0x0086
            L_0x0084:
                r8 = r1
                goto L_0x0087
            L_0x0086:
                r8 = r4
            L_0x0087:
                int r9 = r9.getId()     // Catch:{ all -> 0x00f4 }
                java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x00f4 }
                r0.push(r9)     // Catch:{ all -> 0x00f4 }
                int r7 = r7 + 1
                goto L_0x006c
            L_0x0095:
                if (r8 == 0) goto L_0x00a4
                android.view.ViewGroup r6 = (android.view.ViewGroup) r6     // Catch:{ RuntimeException -> 0x009d }
                r6.removeAllViews()     // Catch:{ RuntimeException -> 0x009d }
                goto L_0x00a4
            L_0x009d:
                r4 = move-exception
                java.lang.String r6 = com.facebook.react.fabric.mounting.SurfaceMountingManager.TAG     // Catch:{ all -> 0x00f4 }
                com.facebook.react.bridge.ReactSoftExceptionLogger.logSoftException(r6, r4)     // Catch:{ all -> 0x00f4 }
            L_0x00a3:
                r8 = r1
            L_0x00a4:
                if (r8 == 0) goto L_0x00af
                com.facebook.react.fabric.mounting.SurfaceMountingManager r4 = com.facebook.react.fabric.mounting.SurfaceMountingManager.this     // Catch:{ all -> 0x00f4 }
                java.util.Stack r4 = r4.mReactTagsToRemove     // Catch:{ all -> 0x00f4 }
                r4.addAll(r0)     // Catch:{ all -> 0x00f4 }
            L_0x00af:
                com.facebook.react.fabric.mounting.SurfaceMountingManager r4 = com.facebook.react.fabric.mounting.SurfaceMountingManager.this     // Catch:{ all -> 0x00f4 }
                java.util.concurrent.ConcurrentHashMap r4 = r4.mTagToViewState     // Catch:{ all -> 0x00f4 }
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00f4 }
                r4.remove(r3)     // Catch:{ all -> 0x00f4 }
                com.facebook.react.fabric.mounting.SurfaceMountingManager r3 = com.facebook.react.fabric.mounting.SurfaceMountingManager.this     // Catch:{ all -> 0x00f4 }
                r3.onViewStateDeleted(r5)     // Catch:{ all -> 0x00f4 }
                int r3 = r2 % 20
                if (r3 != 0) goto L_0x0007
                boolean r3 = r11.haveExceededNonBatchedFrameTime(r12)     // Catch:{ all -> 0x00f4 }
                if (r3 == 0) goto L_0x0007
            L_0x00cb:
                com.facebook.react.fabric.mounting.SurfaceMountingManager r12 = com.facebook.react.fabric.mounting.SurfaceMountingManager.this
                java.util.Stack r12 = r12.mReactTagsToRemove
                boolean r12 = r12.empty()
                if (r12 != 0) goto L_0x00e1
                com.facebook.react.modules.core.ReactChoreographer r12 = com.facebook.react.modules.core.ReactChoreographer.getInstance()
                com.facebook.react.modules.core.ReactChoreographer$CallbackType r13 = com.facebook.react.modules.core.ReactChoreographer.CallbackType.IDLE_EVENT
                r12.postFrameCallback(r13, r11)
                goto L_0x00f3
            L_0x00e1:
                com.facebook.react.fabric.mounting.SurfaceMountingManager r12 = com.facebook.react.fabric.mounting.SurfaceMountingManager.this
                java.util.Set r12 = r12.mErroneouslyReaddedReactTags
                r12.clear()
                com.facebook.react.fabric.mounting.SurfaceMountingManager r12 = com.facebook.react.fabric.mounting.SurfaceMountingManager.this
                java.util.Stack r12 = r12.mReactTagsToRemove
                r12.clear()
            L_0x00f3:
                return
            L_0x00f4:
                r12 = move-exception
                com.facebook.react.fabric.mounting.SurfaceMountingManager r13 = com.facebook.react.fabric.mounting.SurfaceMountingManager.this
                java.util.Stack r13 = r13.mReactTagsToRemove
                boolean r13 = r13.empty()
                if (r13 != 0) goto L_0x010b
                com.facebook.react.modules.core.ReactChoreographer r13 = com.facebook.react.modules.core.ReactChoreographer.getInstance()
                com.facebook.react.modules.core.ReactChoreographer$CallbackType r0 = com.facebook.react.modules.core.ReactChoreographer.CallbackType.IDLE_EVENT
                r13.postFrameCallback(r0, r11)
                goto L_0x011d
            L_0x010b:
                com.facebook.react.fabric.mounting.SurfaceMountingManager r13 = com.facebook.react.fabric.mounting.SurfaceMountingManager.this
                java.util.Set r13 = r13.mErroneouslyReaddedReactTags
                r13.clear()
                com.facebook.react.fabric.mounting.SurfaceMountingManager r13 = com.facebook.react.fabric.mounting.SurfaceMountingManager.this
                java.util.Stack r13 = r13.mReactTagsToRemove
                r13.clear()
            L_0x011d:
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.fabric.mounting.SurfaceMountingManager.RemoveDeleteTreeUIFrameCallback.doFrameGuarded(long):void");
        }
    }
}
