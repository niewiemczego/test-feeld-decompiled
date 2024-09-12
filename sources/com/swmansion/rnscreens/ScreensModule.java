package com.swmansion.rnscreens;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.swmansion.rnscreens.events.ScreenTransitionProgressEvent;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001f\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\rH\u0003¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0011\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H J\u0017\u0010\u0014\u001a\u00020\u00152\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0003R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/swmansion/rnscreens/ScreensModule;", "Lcom/swmansion/rnscreens/NativeScreensModuleSpec;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "isActiveTransition", "Ljava/util/concurrent/atomic/AtomicBoolean;", "topScreenId", "", "finishTransition", "", "reactTag", "canceled", "", "(Ljava/lang/Integer;Z)V", "getName", "", "nativeInstall", "jsiPtr", "", "startTransition", "", "(Ljava/lang/Integer;)[I", "updateTransition", "progress", "", "Companion", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ReactModule(name = "RNSModule")
/* compiled from: ScreensModule.kt */
public final class ScreensModule extends NativeScreensModuleSpec {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String NAME = "RNSModule";
    private final AtomicBoolean isActiveTransition = new AtomicBoolean(false);
    private final ReactApplicationContext reactContext;
    private int topScreenId = -1;

    private final native void nativeInstall(long j);

    public String getName() {
        return "RNSModule";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScreensModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactContext");
        this.reactContext = reactApplicationContext;
        try {
            System.loadLibrary("rnscreens");
            JavaScriptContextHolder javaScriptContextHolder = getReactApplicationContext().getJavaScriptContextHolder();
            if (javaScriptContextHolder != null) {
                nativeInstall(javaScriptContextHolder.get());
            } else {
                Log.e("[RNScreens]", "Could not install JSI bindings.");
            }
        } catch (Exception unused) {
            Log.w("[RNScreens]", "Could not load RNScreens module.");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0033, code lost:
        r7 = (com.swmansion.rnscreens.ScreenStack) r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int[] startTransition(java.lang.Integer r7) {
        /*
            r6 = this;
            com.facebook.react.bridge.UiThreadUtil.assertOnUiThread()
            java.util.concurrent.atomic.AtomicBoolean r0 = r6.isActiveTransition
            boolean r0 = r0.get()
            r1 = 2
            if (r0 != 0) goto L_0x006f
            if (r7 != 0) goto L_0x000f
            goto L_0x006f
        L_0x000f:
            r0 = -1
            r6.topScreenId = r0
            int[] r0 = new int[r1]
            r0 = {-1, -1} // fill-array
            com.facebook.react.bridge.ReactApplicationContext r2 = r6.reactContext
            com.facebook.react.bridge.ReactContext r2 = (com.facebook.react.bridge.ReactContext) r2
            int r3 = r7.intValue()
            com.facebook.react.bridge.UIManager r2 = com.facebook.react.uimanager.UIManagerHelper.getUIManagerForReactTag(r2, r3)
            if (r2 == 0) goto L_0x002e
            int r7 = r7.intValue()
            android.view.View r7 = r2.resolveView(r7)
            goto L_0x002f
        L_0x002e:
            r7 = 0
        L_0x002f:
            boolean r2 = r7 instanceof com.swmansion.rnscreens.ScreenStack
            if (r2 == 0) goto L_0x006e
            com.swmansion.rnscreens.ScreenStack r7 = (com.swmansion.rnscreens.ScreenStack) r7
            java.util.ArrayList r2 = r7.getFragments()
            int r3 = r2.size()
            r4 = 1
            if (r3 <= r4) goto L_0x006e
            java.util.concurrent.atomic.AtomicBoolean r5 = r6.isActiveTransition
            r5.set(r4)
            r7.attachBelowTop()
            int r7 = r3 + -1
            java.lang.Object r7 = r2.get(r7)
            com.swmansion.rnscreens.ScreenStackFragmentWrapper r7 = (com.swmansion.rnscreens.ScreenStackFragmentWrapper) r7
            com.swmansion.rnscreens.Screen r7 = r7.getScreen()
            int r7 = r7.getId()
            r6.topScreenId = r7
            r5 = 0
            r0[r5] = r7
            int r3 = r3 - r1
            java.lang.Object r7 = r2.get(r3)
            com.swmansion.rnscreens.ScreenStackFragmentWrapper r7 = (com.swmansion.rnscreens.ScreenStackFragmentWrapper) r7
            com.swmansion.rnscreens.Screen r7 = r7.getScreen()
            int r7 = r7.getId()
            r0[r4] = r7
        L_0x006e:
            return r0
        L_0x006f:
            int[] r7 = new int[r1]
            r7 = {-1, -1} // fill-array
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreensModule.startTransition(java.lang.Integer):int[]");
    }

    private final void updateTransition(double d) {
        UiThreadUtil.assertOnUiThread();
        if (this.topScreenId != -1) {
            float f = (float) d;
            short coalescingKey = ScreenFragment.Companion.getCoalescingKey(f);
            EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(this.reactContext, this.topScreenId);
            if (eventDispatcherForReactTag != null) {
                eventDispatcherForReactTag.dispatchEvent(new ScreenTransitionProgressEvent(UIManagerHelper.getSurfaceId((Context) this.reactContext), this.topScreenId, f, true, true, coalescingKey));
            }
        }
    }

    private final void finishTransition(Integer num, boolean z) {
        UiThreadUtil.assertOnUiThread();
        if (!this.isActiveTransition.get() || num == null) {
            Log.e("[RNScreens]", "Unable to call `finishTransition` method before transition start.");
            return;
        }
        UIManager uIManagerForReactTag = UIManagerHelper.getUIManagerForReactTag(this.reactContext, num.intValue());
        View resolveView = uIManagerForReactTag != null ? uIManagerForReactTag.resolveView(num.intValue()) : null;
        if (resolveView instanceof ScreenStack) {
            if (z) {
                ((ScreenStack) resolveView).detachBelowTop();
            } else {
                ((ScreenStack) resolveView).notifyTopDetached();
            }
            this.isActiveTransition.set(false);
        }
        this.topScreenId = -1;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/swmansion/rnscreens/ScreensModule$Companion;", "", "()V", "NAME", "", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ScreensModule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
