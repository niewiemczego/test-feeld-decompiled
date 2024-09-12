package com.swmansion.gesturehandler.react;

import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.RootView;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.core.GestureHandlerOrchestrator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fJ\u000e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\fJ\u0006\u0010\u001b\u001a\u00020\u0015J\b\u0010\u001c\u001a\u00020\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerRootHelper;", "", "context", "Lcom/facebook/react/bridge/ReactContext;", "wrappedView", "Landroid/view/ViewGroup;", "(Lcom/facebook/react/bridge/ReactContext;Landroid/view/ViewGroup;)V", "jsGestureHandler", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "orchestrator", "Lcom/swmansion/gesturehandler/core/GestureHandlerOrchestrator;", "passingTouch", "", "rootView", "getRootView", "()Landroid/view/ViewGroup;", "shouldIntercept", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "handleSetJSResponder", "", "viewTag", "", "blockNativeResponder", "requestDisallowInterceptTouchEvent", "disallowIntercept", "tearDown", "tryCancelAllHandlers", "Companion", "RootViewGestureHandler", "react-native-gesture-handler_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RNGestureHandlerRootHelper.kt */
public final class RNGestureHandlerRootHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final float MIN_ALPHA_FOR_TOUCH = 0.1f;
    private final ReactContext context;
    private final GestureHandler<?> jsGestureHandler;
    private final GestureHandlerOrchestrator orchestrator;
    private boolean passingTouch;
    private final ViewGroup rootView;
    /* access modifiers changed from: private */
    public boolean shouldIntercept;

    public RNGestureHandlerRootHelper(ReactContext reactContext, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(reactContext, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "wrappedView");
        this.context = reactContext;
        UiThreadUtil.assertOnUiThread();
        int id = viewGroup.getId();
        if (id < 1 ? false : true) {
            NativeModule nativeModule = reactContext.getNativeModule(RNGestureHandlerModule.class);
            Intrinsics.checkNotNull(nativeModule);
            RNGestureHandlerModule rNGestureHandlerModule = (RNGestureHandlerModule) nativeModule;
            RNGestureHandlerRegistry registry = rNGestureHandlerModule.getRegistry();
            ViewGroup access$findRootViewTag = Companion.findRootViewTag(viewGroup);
            this.rootView = access$findRootViewTag;
            Log.i(ReactConstants.TAG, "[GESTURE HANDLER] Initialize gesture handler for root view " + access$findRootViewTag);
            GestureHandlerOrchestrator gestureHandlerOrchestrator = new GestureHandlerOrchestrator(viewGroup, registry, new RNViewConfigurationHelper());
            gestureHandlerOrchestrator.setMinimumAlphaForTraversal(0.1f);
            this.orchestrator = gestureHandlerOrchestrator;
            RootViewGestureHandler rootViewGestureHandler = new RootViewGestureHandler();
            rootViewGestureHandler.setTag(-id);
            GestureHandler<?> gestureHandler = rootViewGestureHandler;
            this.jsGestureHandler = gestureHandler;
            registry.registerHandler(gestureHandler);
            registry.attachHandlerToView(gestureHandler.getTag(), id, 3);
            rNGestureHandlerModule.registerRootHelper(this);
            return;
        }
        throw new IllegalStateException(("Expect view tag to be set for " + viewGroup).toString());
    }

    public final ViewGroup getRootView() {
        return this.rootView;
    }

    public final void tearDown() {
        Log.i(ReactConstants.TAG, "[GESTURE HANDLER] Tearing down gesture handler registered for root view " + this.rootView);
        NativeModule nativeModule = this.context.getNativeModule(RNGestureHandlerModule.class);
        Intrinsics.checkNotNull(nativeModule);
        RNGestureHandlerModule rNGestureHandlerModule = (RNGestureHandlerModule) nativeModule;
        RNGestureHandlerRegistry registry = rNGestureHandlerModule.getRegistry();
        GestureHandler<?> gestureHandler = this.jsGestureHandler;
        Intrinsics.checkNotNull(gestureHandler);
        registry.dropHandler(gestureHandler.getTag());
        rNGestureHandlerModule.unregisterRootHelper(this);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0000R\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0014¨\u0006\n"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerRootHelper$RootViewGestureHandler;", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerRootHelper;", "(Lcom/swmansion/gesturehandler/react/RNGestureHandlerRootHelper;)V", "onCancel", "", "onHandle", "event", "Landroid/view/MotionEvent;", "sourceEvent", "react-native-gesture-handler_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: RNGestureHandlerRootHelper.kt */
    private final class RootViewGestureHandler extends GestureHandler<RootViewGestureHandler> {
        public RootViewGestureHandler() {
        }

        /* access modifiers changed from: protected */
        public void onHandle(MotionEvent motionEvent, MotionEvent motionEvent2) {
            Intrinsics.checkNotNullParameter(motionEvent, "event");
            Intrinsics.checkNotNullParameter(motionEvent2, "sourceEvent");
            if (getState() == 0) {
                begin();
                RNGestureHandlerRootHelper.this.shouldIntercept = false;
            }
            if (motionEvent.getActionMasked() == 1) {
                end();
            }
        }

        /* access modifiers changed from: protected */
        public void onCancel() {
            RNGestureHandlerRootHelper.this.shouldIntercept = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            obtain.setAction(3);
            if (RNGestureHandlerRootHelper.this.getRootView() instanceof RootView) {
                ((RootView) RNGestureHandlerRootHelper.this.getRootView()).onChildStartedNativeGesture(obtain);
            }
        }
    }

    public final void requestDisallowInterceptTouchEvent(boolean z) {
        if (this.orchestrator != null && !this.passingTouch) {
            tryCancelAllHandlers();
        }
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        this.passingTouch = true;
        GestureHandlerOrchestrator gestureHandlerOrchestrator = this.orchestrator;
        Intrinsics.checkNotNull(gestureHandlerOrchestrator);
        gestureHandlerOrchestrator.onTouchEvent(motionEvent);
        this.passingTouch = false;
        return this.shouldIntercept;
    }

    private final void tryCancelAllHandlers() {
        GestureHandler<?> gestureHandler = this.jsGestureHandler;
        if (gestureHandler != null && gestureHandler.getState() == 2) {
            gestureHandler.activate();
            gestureHandler.end();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: handleSetJSResponder$lambda-6  reason: not valid java name */
    public static final void m641handleSetJSResponder$lambda6(RNGestureHandlerRootHelper rNGestureHandlerRootHelper) {
        Intrinsics.checkNotNullParameter(rNGestureHandlerRootHelper, "this$0");
        rNGestureHandlerRootHelper.tryCancelAllHandlers();
    }

    public final void handleSetJSResponder(int i, boolean z) {
        if (z) {
            UiThreadUtil.runOnUiThread(new RNGestureHandlerRootHelper$$ExternalSyntheticLambda0(this));
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerRootHelper$Companion;", "", "()V", "MIN_ALPHA_FOR_TOUCH", "", "findRootViewTag", "Landroid/view/ViewGroup;", "viewGroup", "react-native-gesture-handler_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: RNGestureHandlerRootHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final ViewGroup findRootViewTag(ViewGroup viewGroup) {
            UiThreadUtil.assertOnUiThread();
            ViewParent viewParent = viewGroup;
            while (viewParent != null && !(viewParent instanceof RootView)) {
                viewParent = viewParent.getParent();
            }
            if (viewParent != null) {
                return (ViewGroup) viewParent;
            }
            throw new IllegalStateException(("View " + viewGroup + " has not been mounted under ReactRootView").toString());
        }
    }
}
